package com.example.demo.service.impl;

import com.example.demo.entity.Role;
import com.example.demo.entity.UserAccount;
import com.example.demo.entity.UserRole;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.repository.UserRoleRepository;
import com.example.demo.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;
    private final UserAccountRepository userAccountRepository;
    private final RoleRepository roleRepository;
    
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository,
                              UserAccountRepository userAccountRepository,
                              RoleRepository roleRepository) {
        this.userRoleRepository = userRoleRepository;
        this.userAccountRepository = userAccountRepository;
        this.roleRepository = roleRepository;
    }
    
    @Override
    public UserRole assignRole(UserRole userRole) {
        UserAccount user = userAccountRepository.findById(userRole.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Role role = roleRepository.findById(userRole.getRole().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));
        
        if (!user.isActive()) {
            throw new BadRequestException("Cannot assign role to inactive user");
        }
        if (!role.isActive()) {
            throw new BadRequestException("Cannot assign inactive role");
        }
        
        return userRoleRepository.save(userRole);
    }
    
    @Override
    public List<UserRole> getRolesForUser(Long userId) {
        return userRoleRepository.findByUser_Id(userId);
    }
    
    @Override
    public UserRole getMappingById(Long id) {
        return userRoleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User role mapping not found"));
    }
    
    @Override
    public void removeRole(Long id) {
        if (!userRoleRepository.existsById(id)) {
            throw new ResourceNotFoundException("User role mapping not found");
        }
        userRoleRepository.deleteById(id);
    }
}
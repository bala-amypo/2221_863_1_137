package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        user.setId(null); // important
        return userAccountRepository.save(user);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userAccountRepository.findAll();
    }

    @Override
    public UserAccount getUserById(Long id) {
        return userAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    @Override
    public UserAccount updateUser(Long id, UserAccount user) {
        UserAccount existing = getUserById(id);
        existing.setEmail(user.getEmail());
        existing.setFullName(user.getFullName());
        existing.setActive(user.isActive());
        return userAccountRepository.save(existing);
    }

    @Override
    public void deleteUser(Long id) {
        UserAccount existing = getUserById(id);
        userAccountRepository.delete(existing);
    }
}

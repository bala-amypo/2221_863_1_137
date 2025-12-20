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
        return userAccountRepository.save(user);
    }

    @Override
    public UserAccount getUserById(Long id) {
        return userAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userAccountRepository.findAll();
    }

    @Override
    public UserAccount updateUser(Long id, UserAccount user) {
        UserAccount existing = getUserById(id);
        existing.setFullName(user.getFullName());
        existing.setActive(user.getActive());
        return userAccountRepository.save(existing);
    }

    @Override
    public void deactivateUser(Long id) {
        UserAccount user = getUserById(id);
        user.setActive(false);
        userAccountRepository.save(user);
    }
}

package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService userAccountService;

    // Constructor Injection
    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

   @PostMapping("/users")
public UserAccount createUser(@RequestBody UserAccount user) {
    return userAccountService.createUser(user);
}


    // Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getUserById(
            @PathVariable Long id) {
        return ResponseEntity.ok(
                userAccountService.getUserById(id)
        );
    }

    // Get All Users
    @GetMapping
    public ResponseEntity<List<UserAccount>> getAllUsers() {
        return ResponseEntity.ok(
                userAccountService.getAllUsers()
        );
    }

    // Update User
    @PutMapping("/{id}")
    public ResponseEntity<UserAccount> updateUser(
            @PathVariable Long id,
            @RequestBody UserAccount userAccount) {
        return ResponseEntity.ok(
                userAccountService.updateUser(id, userAccount)
        );
    }

    // Deactivate User (Soft Delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivateUser(
            @PathVariable Long id) {
        userAccountService.deactivateUser(id);
        return ResponseEntity.noContent().build();
    }
}

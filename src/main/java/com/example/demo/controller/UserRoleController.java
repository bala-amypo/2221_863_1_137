package com.example.demo.controller;

import com.example.demo.entity.UserRole;
import com.example.demo.service.UserRoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

    private final UserRoleService userRoleService;

    // Constructor Injection
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    // Assign Role to User
    @PostMapping
    public ResponseEntity<UserRole> assignRole(
            @RequestBody UserRole userRole) {
        return ResponseEntity.ok(
                userRoleService.assignRole(userRole)
        );
    }

    // Get Roles for a User
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserRole>> getRolesForUser(
            @PathVariable Long userId) {
        return ResponseEntity.ok(
                userRoleService.getRolesForUser(userId)
        );
    }

    // Remove Role from User
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeRole(
            @PathVariable Long id) {
        userRoleService.removeRole(id);
        return ResponseEntity.noContent().build();
    }
}

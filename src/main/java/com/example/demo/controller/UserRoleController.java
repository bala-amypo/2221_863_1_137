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
@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping
    public UserRole assignRoleToUser(
            @RequestParam Long userId,
            @RequestParam Long roleId) {

        return userRoleService.assignRole(userId, roleId);
    }
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

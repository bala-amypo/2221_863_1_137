package com.example.demo.controller;

import com.example.demo.entity.Permission;
import com.example.demo.service.PermissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

    private final PermissionService permissionService;

    // Constructor Injection
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    // Create Permission
    @PostMapping
    public ResponseEntity<Permission> createPermission(
            @RequestBody Permission permission) {
        return ResponseEntity.ok(
                permissionService.createPermission(permission)
        );
    }

    // Get Permission by ID
    @GetMapping("/{id}")
    public ResponseEntity<Permission> getPermissionById(
            @PathVariable Long id) {
        return ResponseEntity.ok(
                permissionService.getPermissionById(id)
        );
    }

    // Get All Permissions
    @GetMapping
    public ResponseEntity<List<Permission>> getAllPermissions() {
        return ResponseEntity.ok(
                permissionService.getAllPermissions()
        );
    }

    // Update Permission
    @PutMapping("/{id}")
    public ResponseEntity<Permission> updatePermission(
            @PathVariable Long id,
            @RequestBody Permission permission) {
        return ResponseEntity.ok(
                permissionService.updatePermission(id, permission)
        );
    }

    // Deactivate Permission (Soft Delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivatePermission(
            @PathVariable Long id) {
        permissionService.deactivatePermission(id);
        return ResponseEntity.noContent().build();
    }
}

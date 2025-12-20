package com.example.demo.controller;

import com.example.demo.entity.RolePermission;
import com.example.demo.service.RolePermissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role-permissions")
public class RolePermissionController {

    private final RolePermissionService rolePermissionService;

    // Constructor Injection
    public RolePermissionController(RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    // Grant Permission to Role
    @PostMapping
    public ResponseEntity<RolePermission> grantPermission(
            @RequestBody RolePermission rolePermission) {
        return ResponseEntity.ok(
                rolePermissionService.grantPermission(rolePermission)
        );
    }

    // Get Permissions for a Role
    @GetMapping("/role/{roleId}")
    public ResponseEntity<List<RolePermission>> getPermissionsForRole(
            @PathVariable Long roleId) {
        return ResponseEntity.ok(
                rolePermissionService.getPermissionsForRole(roleId)
        );
    }

    // Revoke Permission from Role
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> revokePermission(
            @PathVariable Long id) {
        rolePermissionService.revokePermission(id);
        return ResponseEntity.noContent().build();
    }
}

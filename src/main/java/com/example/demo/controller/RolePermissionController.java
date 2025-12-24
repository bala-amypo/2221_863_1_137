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
    
    public RolePermissionController(RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }
    
    @GetMapping("/role/{roleId}")
    public ResponseEntity<List<RolePermission>> getRolePermissions(@PathVariable Long roleId) {
        return ResponseEntity.ok(rolePermissionService.getPermissionsForRole(roleId));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RolePermission> getMapping(@PathVariable Long id) {
        return ResponseEntity.ok(rolePermissionService.getMappingById(id));
    }
}
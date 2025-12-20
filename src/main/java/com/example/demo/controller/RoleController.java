package com.example.demo.controller;

import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    // Constructor Injection
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    // Create Role
    @PostMapping
    public ResponseEntity<Role> createRole(
            @RequestBody Role role) {
        return ResponseEntity.ok(
                roleService.createRole(role)
        );
    }

    // Get Role by ID
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(
            @PathVariable Long id) {
        return ResponseEntity.ok(
                roleService.getRoleById(id)
        );
    }

    // Get All Roles
    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(
                roleService.getAllRoles()
        );
    }

    // Update Role
    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(
            @PathVariable Long id,
            @RequestBody Role role) {
        return ResponseEntity.ok(
                roleService.updateRole(id, role)
        );
    }

    // Deactivate Role (Soft Delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivateRole(
            @PathVariable Long id) {
        roleService.deactivateRole(id);
        return ResponseEntity.noContent().build();
    }
}

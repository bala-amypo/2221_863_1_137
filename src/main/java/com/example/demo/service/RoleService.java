package com.example.demo.service;

import com.example.demo.entity.Role;
import java.util.List;

public interface RoleService {

    Role createRole(Role role);

    Role getRoleById(Long id);

    List<Role> getAllRoles();

    Role updateRole(Long id, Role role);

    void deactivateRole(Long id);
}

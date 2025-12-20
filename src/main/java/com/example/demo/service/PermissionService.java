package com.example.demo.service;

import com.example.demo.entity.Permission;
import java.util.List;

public interface PermissionService {

    Permission createPermission(Permission permission);

    Permission getPermissionById(Long id);

    List<Permission> getAllPermissions();

    Permission updatePermission(Long id, Permission permission);

    void deactivatePermission(Long id);
}

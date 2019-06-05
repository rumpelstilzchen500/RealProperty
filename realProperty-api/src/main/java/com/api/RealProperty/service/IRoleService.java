package com.api.RealProperty.service;

import com.api.RealProperty.entity.Role;

import java.util.List;

public interface IRoleService {
    Role addRole(Role role);

    Role getRole(Long roleId);

    Role updateRole(Role role);

    Role deleteRole(Long roleId);

    List<Role> getAllRole();
}

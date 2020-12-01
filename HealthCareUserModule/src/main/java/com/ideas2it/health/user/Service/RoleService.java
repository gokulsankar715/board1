package com.ideas2it.health.user.Service;

import com.ideas2it.health.user.Dto.RoleDto;

public interface RoleService {

	public RoleDto addRole(RoleDto roleDto);

	public RoleDto updateRole(String rolename, RoleDto roleDto);

	public String deleteRole(String rolename);

	public RoleDto getRoleDetails(String rolename);
}

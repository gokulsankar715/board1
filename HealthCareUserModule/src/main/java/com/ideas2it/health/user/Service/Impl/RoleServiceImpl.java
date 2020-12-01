package com.ideas2it.health.user.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ideas2it.health.user.Dto.RoleDto;
import com.ideas2it.health.user.Manager.RoleManager;
import com.ideas2it.health.user.Repositary.RoleRepositary;
import com.ideas2it.health.user.Service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Lazy
	@Autowired
	public RoleServiceImpl(RoleRepositary roleRepositary, RoleManager roleManager) {
		super();
		this.roleRepositary = roleRepositary;
		this.roleManager = roleManager;
	}

	private final RoleRepositary roleRepositary;

	private final RoleManager roleManager;

	public RoleDto addRole(RoleDto roleDto) {
		return roleManager.addRole(roleDto);
	}

	public RoleDto updateRole(String rolename, RoleDto roleDto) {
		return roleManager.updateRole(rolename, roleDto);
	}

	public String deleteRole(String rolename) {
		roleRepositary.delete(roleRepositary.findByRolename(rolename));
		return String.format("Role %1$s Deleted Succesfully", rolename);
	}

	public RoleDto getRoleDetails(String rolename) {
		RoleDto roleDto = new RoleDto();
		return roleDto.convertRoleDto(roleRepositary.findByRolename(rolename));

	}

}

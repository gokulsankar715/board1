package com.ideas2it.health.user.Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ideas2it.health.user.Dto.RoleDto;
import com.ideas2it.health.user.Model.Role;
import com.ideas2it.health.user.Repositary.RoleRepositary;

@Service
public class RoleManager {

	@Lazy
	@Autowired
	public RoleManager(RoleRepositary roleRepositary) {
		super();
		this.roleRepositary = roleRepositary;
	}

	private final RoleRepositary roleRepositary;

	public RoleDto addRole(RoleDto roleDto) {
		return roleDto.convertRoleDto(roleRepositary.save(roleDto.convertRoleDomain(roleDto)));
	}

	public RoleDto updateRole(String rolename, RoleDto roleDto) {
		RoleDto roles = roleDto.convertRoleDto(roleRepositary.findByRolename(rolename));
		roles.setRolename(roleDto.getRolename());
		Role role = roleDto.convertRoleDomain(roles);
		return roleDto.convertRoleDto(roleRepositary.save(role));
	}

}

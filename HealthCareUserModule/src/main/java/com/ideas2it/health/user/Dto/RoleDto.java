package com.ideas2it.health.user.Dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.ideas2it.health.user.Model.Role;
import com.ideas2it.health.user.Model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto implements Serializable {

	private static final long serialVersionUID = -4523042738125604747L;

	private int role_id;

	private String rolename;

	private List<User> roles;

	private String createdBy;

	private LocalDateTime createdAt;

	private String updatedBy;

	private LocalDateTime updateAt;

	public static Role convertRoleDomain(RoleDto roleDto) {
		Role role = new Role();
		role.setRole_id(roleDto.getRole_id());
		role.setRolename(roleDto.getRolename());
		role.setRoles(roleDto.getRoles());
		role.setCreatedAt(roleDto.getCreatedAt());
		role.setCreatedBy(roleDto.getCreatedBy());
		role.setUpdateAt(roleDto.getUpdateAt());
		role.setUpdatedBy(roleDto.getUpdatedBy());
		return role;
	}

	public static RoleDto convertRoleDto(Role role) {
		RoleDto roleDto = new RoleDto();
		roleDto.setRole_id(role.getRole_id());
		roleDto.setRolename(role.getRolename());
		roleDto.setRoles(role.getRoles());
		roleDto.setCreatedAt(role.getCreatedAt());
		roleDto.setCreatedBy(role.getCreatedBy());
		roleDto.setUpdateAt(role.getUpdateAt());
		roleDto.setUpdatedBy(role.getUpdatedBy());
		return roleDto;
	}
}

package com.ideas2it.health.user.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ideas2it.health.user.Dto.UserRoleDto;
import com.ideas2it.health.user.Repositary.RoleRepositary;

@Service
public class RoleService {

	@Lazy
	@Autowired
	public RoleService(RoleRepositary roleRepositary) {
		super();
		this.roleRepositary = roleRepositary;
	}

	private final RoleRepositary roleRepositary;

	public List<UserRoleDto> getRoleNames(String rolename) {
		return roleRepositary.getRoleNames(rolename);
	}

}

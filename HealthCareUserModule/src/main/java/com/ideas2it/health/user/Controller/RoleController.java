package com.ideas2it.health.user.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.health.user.Advice.AuditTrailLogging;
import com.ideas2it.health.user.Dto.RoleDto;
import com.ideas2it.health.user.Service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	private final RoleService roleService;

	@Lazy
	@Autowired
	public RoleController(RoleService roleService) {
		super();
		this.roleService = roleService;
	}

	/* Get the Role Details Based On RoleName */
	@AuditTrailLogging
	@GetMapping("/{rolename}")
	public RoleDto getRoleDetails(@PathVariable String rolename) {
		return roleService.getRoleDetails(rolename);
	}

	/* ADD the New-Role */
	@AuditTrailLogging
	@PostMapping("/")
	public RoleDto addRole(@RequestBody RoleDto roleDto) {
		return roleService.addRole(roleDto);
	}

	/* Update Role-Info */
	@AuditTrailLogging
	@PutMapping("/{rolename}")
	public RoleDto updateRole(@PathVariable String rolename, @RequestBody RoleDto roleDto) {
		return roleService.updateRole(rolename, roleDto);
	}

	/* Delete Role */
	@AuditTrailLogging
	@DeleteMapping("/{rolename}")
	public String deleteRole(@PathVariable String rolename) {
		return roleService.deleteRole(rolename);
	}

}

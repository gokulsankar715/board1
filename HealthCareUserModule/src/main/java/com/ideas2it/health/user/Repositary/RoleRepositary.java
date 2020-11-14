package com.ideas2it.health.user.Repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ideas2it.health.user.Dto.UserRoleDto;
import com.ideas2it.health.user.Model.Role;

public interface RoleRepositary extends JpaRepository<Role, Integer> {

	/* Get User-Info & Role-Info based on Role-Name */
	@Query("Select new com.ideas2it.health.user.Dto.UserRoleDto(u.userid,u.username,r.rolename) FROM Role r JOIN r.roles u where r.rolename=?1")
	List<UserRoleDto> getRoleNames(String rolename);

}

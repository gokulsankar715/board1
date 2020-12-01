package com.ideas2it.health.user.Repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ideas2it.health.user.Model.User;

@Repository
public interface UserRepositary extends JpaRepository<User, Long> {

	/* Get User-info Based on UserName */
	User findByUsername(String username);

	/* Get User-Info based on Role-Id */
	List<User> findByRoleid(int roleid);

	/* Get the Specified Role Count in Hospital */
	@Query("Select Count(*) From User where role_id=?1")
	public int rowcount(@Param("roleid") long role_id);

	/* Get User-Info based on UserName and Password */
	@Query("From User where user_name=?1 and password=?2")
	List<User> getRole(@Param("user_name") String user_name, @Param("password") String password);

	User findByUserid(long userid);

	// User save(UserDto user);

//	UserDto save(UserDto user);

//	/* Get User-Info & Role-Info based on Role-Name */
//	@Query("Select new com.example.health.user.Dto.UserRoleResponse(u.userid,u.username,r.rolename) FROM User u JOIN u.roles r where r.rolename=?1")
//	List<UserRoleResponse> getRoleNames(String rolename);

}

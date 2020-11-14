package com.ideas2it.health.user.Manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ideas2it.health.user.Dto.UserDto;
import com.ideas2it.health.user.Model.User;
import com.ideas2it.health.user.Repositary.UserRepositary;

@Service
public class UserManager {

	@Lazy
	@Autowired
	public UserManager(UserRepositary userRepositary) {
		super();
		this.userRepositary = userRepositary;
	}

	private final UserRepositary userRepositary;

	public User UserAddManager(UserDto userDto) {
		User user = new User();
		user.setUserid(userDto.getUserid());
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setRoleid(userDto.getRoleid());
		return userRepositary.save(user);

	}

	public User findByUsername(String username) {
		return userRepositary.findByUsername(username);
	}

	public List<User> findAll() {
		return userRepositary.findAll();
	}

	public List<User> findByRoleid(int roleid) {
		return userRepositary.findByRoleid(roleid);
	}

	public List<User> getRole(String username, String password) {
		return userRepositary.getRole(username, password);
	}

}

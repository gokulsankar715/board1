package com.ideas2it.health.user.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ideas2it.health.user.Dto.UserDto;
import com.ideas2it.health.user.Manager.UserManager;
import com.ideas2it.health.user.Model.User;
import com.ideas2it.health.user.Util.JwtUtil;

@Service
public class UserService implements UserDetailsService {

	@Lazy
	@Autowired
	public UserService(UserManager userManager, JwtUtil jwtUtil) {
		super();
		this.userManager = userManager;
		this.jwtUtil = jwtUtil;
	}

	private final UserManager userManager;
	private final JwtUtil jwtUtil;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userManager.findByUsername(username);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());

	}

	public String tokenInfo(String username, String password) {
		List<User> role = userManager.getRole(username, password);
		String result = null;
		String token = jwtUtil.generateToken(username);
		if (role.get(0).getRoleid() == 101) {
			result = String.format("Welcome to Doctor Dash board Mr/Ms : %1$s \n Your Token is %2$s", username, token);
		} else if (role.get(0).getRoleid() == 102) {
			result = String.format("Welcome to Surgeon Dash board Mr/Ms : %1$s \n Your Token is %2$s", username, token);
		} else if (role.get(0).getRoleid() == 103) {
			result = String.format("Welcome to Nurses Dash board Mr/Ms : %1$s \n Your Token is %2$s", username, token);
		} else if (role.get(0).getRoleid() == 104) {
			result = String.format("Welcome to Patient Dash board Mr/Ms : %1$s \n Your Token is %2$s", username, token);
		} else if (role.get(0).getRoleid() == 100) {
			result = String.format("Welcome to Admin Dash board Mr/Ms : %1$s \n Your Token is %2$s", username, token);
		} else {
			result = String.format("Welcome to Support-Staff Dash board Mr/Ms : %1$s \n Your Token is %2$s", username,
					token);
		}
		return result;

	}

	public User UserInfo(UserDto userDto) {
		return userManager.UserAddManager(userDto);
	}

	public List<User> findAll() {
		return userManager.findAll();
	}

	public User findByUsername(String username) {
		return userManager.findByUsername(username);
	}

	public List<User> findByRoleid(int roleid) {
		return userManager.findByRoleid(roleid);
	}

	public List<User> getRole(String name, String pass) {
		return userManager.getRole(name, pass);
	}

}

package com.ideas2it.health.user.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ideas2it.health.user.Dto.UserDto;
import com.ideas2it.health.user.Manager.UserManager;
import com.ideas2it.health.user.Repositary.UserRepositary;
import com.ideas2it.health.user.Service.UserService;
import com.ideas2it.health.user.Util.JwtUtil;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

	@Lazy
	@Autowired
	public UserServiceImpl(UserManager userManager, JwtUtil jwtUtil, AuthenticationManager authenticationManager,
			UserRepositary userRepositary) {
		super();
		this.userManager = userManager;
		this.jwtUtil = jwtUtil;
		this.authenticationManager = authenticationManager;
		this.userRepositary = userRepositary;
	}

	private final UserManager userManager;

	private final JwtUtil jwtUtil;

	private final AuthenticationManager authenticationManager;

	private final UserRepositary userRepositary;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto userDto = new UserDto();
		userDto = userDto.convertUserDto(userRepositary.findByUsername(username));
		return new org.springframework.security.core.userdetails.User(userDto.getUsername(), userDto.getPassword(),
				new ArrayList<>());

	}

	public String tokenInfo(String username, String password) throws Exception {
		try {

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		} catch (Exception e) {
			throw new Exception("invaild Username/Password");
		}
		List<UserDto> role = userManager.getRole(username, password);
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

	@CachePut("user")
	public UserDto addUser(UserDto userDto) {
		return userManager.addUser(userDto);
	}

	@Cacheable("user")
	public String findAll() {
		return userManager.findAll();
	}

	@Cacheable("user")
	public String getUserDetails(String username) {
		return userManager.getUserDetails(username);
	}

	@Cacheable("user")
	public List<UserDto> getRole(String name, String pass) {
		return userManager.getRole(name, pass);
	}

	@CachePut("user")
	public String updateuser(long userid, UserDto userDto) {
		return userManager.updateUser(userid, userDto);
	}

	@CacheEvict("user")
	public String deleteUser(long userid) {
		return userManager.deleteUserInfo(userid);
	}

}

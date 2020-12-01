package com.ideas2it.health.user.Service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.ideas2it.health.user.Dto.UserDto;

public interface UserService {

	public UserDto addUser(UserDto userDto);

	public String findAll();

	public String getUserDetails(String username);

	public List<UserDto> getRole(String name, String pass);

	public String updateuser(long userid, UserDto userDto);

	public String deleteUser(long userid);

	public UserDetails loadUserByUsername(String username);

	public String tokenInfo(String username, String password) throws Exception;

}

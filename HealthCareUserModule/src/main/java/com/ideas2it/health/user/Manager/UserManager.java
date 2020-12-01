package com.ideas2it.health.user.Manager;

import java.util.List;
import java.util.stream.Collectors;

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

	public UserDto addUser(UserDto userDto) {
		return userDto.convertUserDto(userRepositary.save(userDto.convertUserDomain(userDto)));
	}

	public String getUserDetails(String username) {
		UserDto userDto = new UserDto();
		// return userDto.convertUserDto(userRepositary.findByUsername(username));
		if (userRepositary.findByUsername(username) != null) {
			return userRepositary.findByUsername(username).toString();
		} else {
			// throw new ResourceNotFoundExecption("User +"u);
			return String.format("User-Name : %1$s Not Available in Database", username);
		}
	}

	public String findAll() {
		// UserDto userDto = new UserDto();
		// .stream().map(a -> userDto.convertUserDto(a)).collect(Collectors.toList());
		if (userRepositary.findAll() != null) {
			System.out.println(userRepositary.findAll());
			return userRepositary.findAll().toString();
		} else {
			return "User-Data Not Available in DataBase";
		}
	}

	public List<UserDto> getRole(String username, String password) {
		UserDto userDto = new UserDto();
		return userRepositary.getRole(username, password).stream().map(a -> userDto.convertUserDto(a))
				.collect(Collectors.toList());
	}

	public String updateUser(long userid, UserDto userDto) {
		if (userRepositary.findByUserid(userid) != null) {
			UserDto users = userDto.convertUserDto(userRepositary.findByUserid(userid));
			users.setUsername(userDto.getUsername());
			users.setPassword(userDto.getPassword());
			User user = userDto.convertUserDomain(users);
			return userRepositary.save(user).toString();
		} else {
			return String.format("User-id : %1$s Not Available in Database", userid);
		}
	}

	public String deleteUserInfo(long userid) {
		if (userRepositary.findByUserid(userid) != null) {
			userRepositary.delete(userRepositary.findByUserid(userid));
			return String.format("User-id : %1$s Deleted Succesfully", userid);
		} else {
			return String.format("User-id : %1$s Not Available in Database", userid);
		}
	}

}

package com.ideas2it.health.user.Dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.ideas2it.health.user.Model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

	private static final long serialVersionUID = 6340298171379460244L;

	private long userid;
	private String username;
	private String password;
	private int roleid;
	private String createdBy;
	private LocalDateTime createdAt;
	private String updatedBy;
	private LocalDateTime updateAt;

	public static User convertUserDomain(UserDto userDto) {
		User user = new User();
		user.setUserid(userDto.getUserid());
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setRoleid(userDto.getRoleid());
		user.setCreatedAt(userDto.getCreatedAt());
		user.setCreatedBy(userDto.getCreatedBy());
		user.setUpdateAt(userDto.getUpdateAt());
		user.setUpdatedBy(userDto.getUpdatedBy());
		return user;
	}

	public static UserDto convertUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setUserid(user.getUserid());
		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
		userDto.setRoleid(user.getRoleid());
		userDto.setCreatedAt(user.getCreatedAt());
		userDto.setCreatedBy(user.getCreatedBy());
		userDto.setUpdateAt(user.getUpdateAt());
		userDto.setUpdatedBy(user.getUpdatedBy());
		return userDto;
	}
}

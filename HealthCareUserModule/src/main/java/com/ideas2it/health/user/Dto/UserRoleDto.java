package com.ideas2it.health.user.Dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleDto implements Serializable {

	private long userid;
	private String username;
	private String rolename;

}

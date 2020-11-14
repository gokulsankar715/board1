package com.ideas2it.health.user.Dto;

import java.time.LocalDateTime;
import java.util.List;

import com.ideas2it.health.user.Model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {

	private int role_id;

	private String rolename;

	private List<User> roles;

	private String createdBy;

	private LocalDateTime createdAt;

	private String updatedBy;

	private LocalDateTime updateAt;

}

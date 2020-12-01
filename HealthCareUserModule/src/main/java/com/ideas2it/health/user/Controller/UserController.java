package com.ideas2it.health.user.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.health.user.Advice.AuditTrailLogging;
import com.ideas2it.health.user.Dto.UserDto;
import com.ideas2it.health.user.Service.UserService;

@RestController
@EnableDiscoveryClient
@RequestMapping("/users")
public class UserController {

	@Lazy
	@Autowired
	public UserController(UserService userservice) {
		super();
		this.userservice = userservice;
	}

	private final UserService userservice;

	/* Get the All User Details */
	@AuditTrailLogging
	@GetMapping("/")
	public String getAllUser() {
		return userservice.findAll();
	}

	/* Get the User Details */
	@AuditTrailLogging
	@GetMapping("/{username}")
	public String getUserDetails(@PathVariable String username) {
		return userservice.getUserDetails(username);
	}

	/* ADD the User-Info */
	@AuditTrailLogging
	@PostMapping("/")
	public UserDto addUser(@RequestBody UserDto userDto) {
		return userservice.addUser(userDto);
	}

	/* Generate Token and Authenticate */
	@AuditTrailLogging
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody UserDto authRequest) throws Exception {
		return userservice.tokenInfo(authRequest.getUsername(), authRequest.getPassword());
	}

	/* Update User-Info */
	@AuditTrailLogging
	@PutMapping("/{userid}")
	public String updateUser(@PathVariable long userid, @RequestBody UserDto userDto) {
		return userservice.updateuser(userid, userDto);
	}

	/* Delete User */
	@AuditTrailLogging
	@DeleteMapping("/{userid}")
	public String deleteUser(@PathVariable long userid) {
		return userservice.deleteUser(userid);
	}
}

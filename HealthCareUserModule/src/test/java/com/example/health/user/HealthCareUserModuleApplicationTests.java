package com.example.health.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.ideas2it.health.user.Dto.UserDto;
import com.ideas2it.health.user.Manager.UserManager;
import com.ideas2it.health.user.Model.User;
import com.ideas2it.health.user.Repositary.UserRepositary;

@SpringBootTest
@ContextConfiguration
@SpringBootConfiguration
class HealthCareUserModuleApplicationTests {

	@Mock
	private UserRepositary userRepositary;

	@InjectMocks
	private UserManager userManager;

	@Test
	public void getAllUserTest1() {
		List<User> list = new ArrayList<User>();
		when(userRepositary.findAll()).thenReturn(null);
		assertEquals("User-Data Not Available in DataBase", userManager.findAll());
	}

	@Test
	public void getAllUserTest2() {
		List<User> list = new ArrayList<User>();
		User user1 = new User(430, "gokul", "g123", 104, null, null, null, null);
		User user2 = new User(550, "sankar", "s123", 101, null, null, null, null);
		list.add(user1);
		list.add(user2);
		when(userRepositary.findAll()).thenReturn(list);
		assertEquals(
				"[User(userid=430, username=gokul, password=g123, roleid=104, createdBy=null, createdAt=null, updatedBy=null, updateAt=null), User(userid=550, username=sankar, password=s123, roleid=101, createdBy=null, createdAt=null, updatedBy=null, updateAt=null)]",
				userManager.findAll());
	}

	@Test
	public void getUserDetailsTest() {
		User user1 = new User(430, "gokul", "g123", 104, null, null, null, null);
		when(userRepositary.findByUsername("gokul")).thenReturn(user1);
		assertEquals(
				"User(userid=430, username=gokul, password=g123, roleid=104, createdBy=null, createdAt=null, updatedBy=null, updateAt=null)",
				userManager.getUserDetails("gokul"));
		assertEquals("User-Name : gokul1 Not Available in Database", userManager.getUserDetails("gokul1"));
	}

	@Test
	public void addUserTest() {
		User user1 = new User(430, "gokul", "g123", 104, null, null, null, null);
		UserDto user = new UserDto(430, "gokul", "g123", 104, null, null, null, null);
		when(userRepositary.save(user1)).thenReturn(user1);
		assertEquals(user1, UserDto.convertUserDomain(userManager.addUser(user)));
	}

//	@Test
//	public void deleteUserTest() {
//		User user1 = new User(430, "gokul", "g123", 104, null, null, null, null);
//		UserDto user = new UserDto(430, "gokul", "g123", 104, null, null, null, null);
//		when(userRepositary.save(user1)).thenReturn(user1);
//		assertEquals(user1, UserDto.convertUserDomain(userServiceImpl.addUser(user)));
////		verify(userRepositary, times(1)).delete(user1);
//
//		assertEquals("User-id : 430 Deleted Succesfully", userServiceImpl.deleteUserInfo(430));
//	}
}

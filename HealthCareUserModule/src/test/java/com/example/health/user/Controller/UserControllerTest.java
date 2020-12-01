package com.example.health.user.Controller;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ideas2it.health.user.Controller.UserController;
import com.ideas2it.health.user.Manager.UserManager;
import com.ideas2it.health.user.Model.User;
import com.ideas2it.health.user.Repositary.UserRepositary;
import com.ideas2it.health.user.Service.Impl.UserServiceImpl;

//@ExtendWith(MockitoExtension.class)
//@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
@SpringBootConfiguration
public class UserControllerTest {

	@Mock
	private UserRepositary userRepositary;

	@InjectMocks
	private UserServiceImpl userServiceImpl;

	@InjectMocks
	private UserController userController;

	@InjectMocks
	private UserManager userManager;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(UserController.class).build();
	}

	@Test
	public void retrieveDetailsForCourse() throws Exception {
		User user1 = new User(430, "gokul", "g123", 104, null, null, null, null);
		String s = null;
		Mockito.when(userRepositary.findByUsername("gokul")).thenReturn(user1);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/" + "gokul");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
		String expected = "User(userid=430, username=gokul, password=g123, roleid=104, createdBy=null, createdAt=null, updatedBy=null, updateAt=null)";
		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K
		// Students","steps":["Learn Maven","Import Project","First Example","Second
		// Example"]}
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

//	@Test
//	public void getAllUserTest1() throws Exception {
//		List<User> list = new ArrayList<User>();
//		when(userRepositary.findAll()).thenReturn(null);
//		this.mockMvc.perform(get("/users/")).andExpect(status().isOk()).andExpect("User-Data Not Available in DataBase",
//				is(userController.getAllUser()));
//	}

//	@Test
//	public void getAllUserTest2() {
//		List<User> list = new ArrayList<User>();
//		User user1 = new User(430, "gokul", "g123", 104, null, null, null, null);
//		User user2 = new User(550, "sankar", "s123", 101, null, null, null, null);
//		list.add(user1);
//		list.add(user2);
//		when(userRepositary.findAll()).thenReturn(list);
//		assertEquals(
//				"[User(userid=430, username=gokul, password=g123, roleid=104, createdBy=null, createdAt=null, updatedBy=null, updateAt=null), User(userid=550, username=sankar, password=s123, roleid=101, createdBy=null, createdAt=null, updatedBy=null, updateAt=null)]",
//				userManager.findAll());
//	}
//
//	@Test
//	public void getUserDetailsTest() {
//		User user1 = new User(430, "gokul", "g123", 104, null, null, null, null);
//		when(userRepositary.findByUsername("gokul")).thenReturn(user1);
//		assertEquals(
//				"User(userid=430, username=gokul, password=g123, roleid=104, createdBy=null, createdAt=null, updatedBy=null, updateAt=null)",
//				userManager.getUserDetails("gokul"));
//		assertEquals("User-Name : gokul1 Not Available in Database", userManager.getUserDetails("gokul1"));
//	}
//
//	@Test
//	public void addUserTest() {
//		User user1 = new User(430, "gokul", "g123", 104, null, null, null, null);
//		UserDto user = new UserDto(430, "gokul", "g123", 104, null, null, null, null);
//		when(userRepositary.save(user1)).thenReturn(user1);
//		assertEquals(user1, UserDto.convertUserDomain(userManager.addUser(user)));
//	}

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

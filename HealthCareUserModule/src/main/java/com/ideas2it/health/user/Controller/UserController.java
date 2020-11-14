package com.ideas2it.health.user.Controller;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.health.user.Advice.TrackLogging;
import com.ideas2it.health.user.Dto.PatientDto;
import com.ideas2it.health.user.Dto.UserDto;
import com.ideas2it.health.user.Dto.UserRoleDto;
import com.ideas2it.health.user.Dto.VitalSignDto;
import com.ideas2it.health.user.Model.User;
import com.ideas2it.health.user.Service.PatientService;
import com.ideas2it.health.user.Service.RoleService;
import com.ideas2it.health.user.Service.UserService;
import com.ideas2it.health.user.Service.VitalSignsService;
import com.ideas2it.health.user.Util.JwtUtil;

@RestController
@EnableDiscoveryClient
@RequestMapping("/users")
public class UserController {

	@Lazy
	@Autowired
	public UserController(JwtUtil jwtUtil, AuthenticationManager authenticationManager, UserService userservice,
			VitalSignsService vitalSignsService, PatientService patientService, RoleService roleService) {
		super();
		this.jwtUtil = jwtUtil;
		this.authenticationManager = authenticationManager;
		this.userservice = userservice;
		this.vitalSignsService = vitalSignsService;
		this.patientService = patientService;
		this.roleService = roleService;
	}

	private final JwtUtil jwtUtil;

	private final AuthenticationManager authenticationManager;

	private final UserService userservice;

	private final VitalSignsService vitalSignsService;

	private final PatientService patientService;

	private final RoleService roleService;

	/* Get the Patient VitalSigns Details Based on Patient-Id */
	@TrackLogging
	@GetMapping("/vitalsigns/{patient_id}")
	public List<VitalSignDto> getPatientVitalSignResponse(@PathVariable long patient_id) {
		return vitalSignsService.getPatientInfo(patient_id);
	}

	/* Get the All Patient Details */
	@GetMapping("/patients")
	public List<PatientDto> getAllpatients() {
		return patientService.getAllPatient();
	}

	/* Get the Patient Details based in Patient-Id */
	@GetMapping("/patient/{patient_id}")
	// @Cacheable(value = "patient", key = "#patient_id")
	public PatientDto getpatients(@PathVariable long patient_id) {
		return patientService.getPatient(patient_id);
	}

	// Get All the User Details
	@TrackLogging
	@GetMapping("/info")
	public List<User> getUserDetails() {
		return userservice.findAll();
	}

	// Get All the User Details
	@GetMapping("/user-name/{username}")
	@Cacheable(value = "use", key = "#username")
	public User getUserDetails(@PathVariable String username) {
		return userservice.findByUsername(username);
	}

	// Get All the Role Based User Details
	// If 101-Doctor , 102-Surgeon , 103-Nurses , 104-Patient , 105-Support-Staff
	@GetMapping("/role-id/{roleid}")
	@Cacheable(value = "use", key = "#roleid")
	public List<User> getRoleDetails(@PathVariable int roleid) {
		return userservice.findByRoleid(roleid);
	}

	@TrackLogging
	@GetMapping("/role-name/{rolename}")
	@Cacheable(value = "use", key = "#rolename")
	public List<UserRoleDto> getRoleName(@PathVariable String rolename) {
		return roleService.getRoleNames(rolename);
	}

	/* ADD the User-Info */
	@PostMapping("/add-user")
	@CachePut(value = "use")
	public User addUser(@RequestBody UserDto user) throws UnknownHostException {
		return userservice.UserInfo(user);
	}

	/* ADD the Patient-Details */
	@PostMapping("/add-patient")
	public PatientDto AddPatient(@RequestBody PatientDto patientDto) {
		return patientService.AddPatient(patientDto);
	}

	/* ADD CheckUp-Info */
	@PostMapping("/add-checkup")
	public VitalSignDto AddCheckUp(@RequestBody VitalSignDto vitalSignDto) {
		return vitalSignsService.AddCheckup(vitalSignDto);
	}

	/* Generate Token and Authenticate */
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody UserDto authRequest) throws Exception {
		try {

			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("invaild Username/Password");
		}
		return userservice.tokenInfo(authRequest.getUsername(), authRequest.getPassword());
	}

}

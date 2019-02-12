package com.example.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.main.model.Company;
import com.example.main.model.ProfileInfo;
import com.example.main.model.Role;
import com.example.main.model.User;
import com.example.main.model.Users;
import com.example.main.service.AESDecryptorService;
import com.example.main.service.CompanyService;
import com.example.main.service.ProfileInfoService;
import com.example.main.service.RoleService;
import com.example.main.service.UsersService;

@RestController
public class TestController {

	@Autowired
	RoleService roleService;

	@Autowired
	AESDecryptorService aesDecryptor;

	@Autowired
	CompanyService companyService;

	@Autowired
	UsersService usersService;

	@Autowired
	ProfileInfoService profileInfoService;

	@GetMapping("/welcome")
	public String welcome() {
		return "This is something";
	}

	@GetMapping("/allRoles")
	public List<Role> getAllRoles() {
		return roleService.findAll();
	}

	@GetMapping("/allRoleNative")
	public Role getRoleByNative() {
		return roleService.findRoleNativeQuery();
	}

	@GetMapping("/getRoleByRoleId/{id}")
	public Role getRoleByRoleId(@PathVariable Integer id) {
		return roleService.findRoleByRoleId(id);
	}

	@GetMapping("/getRoleByRoleName")
	public List<Role> getRoleByRoleName(@RequestParam String role) {
		return roleService.findByRole(role);
	}

	@GetMapping("/getRoleByRoleSalary")
	public List<Role> getRoleByRoleSalary(@RequestParam String salary) {
		return roleService.findBySalary(salary);
	}

	@GetMapping("/getRoleByRoleIdQueryString")
	public Role getRoleByRoleID1(@RequestParam Integer id) {
		return roleService.findRoleByRoleId(id);
	}

	@GetMapping("/getCompanyData")
	public List<Company> getAllCompanies() {
		return companyService.getAllCompanies();
	}

	@GetMapping("/getRoleByRoleIdWithSession")
	public String getRoleByRoleIDSession(@RequestParam String sessionString) {
		String loginUserId = aesDecryptor.decryptThisKey(sessionString).split("~")[0];
		Users users = usersService.findUsersById(Integer.parseInt(loginUserId));
		ProfileInfo profileInfo = profileInfoService.getProfileInfoById(users.getProfile_id());
		return "Hi " + profileInfo.getFirstName() + " " + profileInfo.getLastName() + ", Welcome to Rest API";
	}

	@GetMapping("/getAllUsers")
	public List<Users> getAllUsers() {
		return usersService.findAll();
	}

	@GetMapping("/getUserById")
	public Users getUsersById(@RequestParam Integer userId) {
		return usersService.findUsersById(userId);
	}

	@GetMapping("/getMovieString")
	public String getMovieCatalog() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:8889/welcome", String.class);
	}

	@GetMapping("/getEmployeeByUserId")
	public User getAllEmployees(@RequestParam Integer userId) {
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject("http://localhost:8889/getAllEmployee?userId=" + userId, User.class);
		return user;
	}

	@PostMapping("")
	public void addRole(@ModelAttribute("role") Role role) {

	}
}

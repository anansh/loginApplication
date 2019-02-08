package com.example.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.main.model.Role;
import com.example.main.model.User;
import com.example.main.service.RoleService;

@RestController
public class TestController {

	@Autowired
	RoleService roleService;

	@RequestMapping("/welcome")
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

	@RequestMapping("/getRoleByRoleId/{id}")
	public Role getRoleByRoleId(@PathVariable Integer id) {
		return roleService.findRoleByRoleId(id);
	}

	@RequestMapping("/getRoleByRoleIdQueryString")
	public Role getRoleByRoleID1(@RequestParam Integer id) {
		return roleService.findRoleByRoleId(id);
	}

	@RequestMapping("/getMovieString")
	public String getMovieCatalog() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:8889/welcome", String.class);
	}

	@RequestMapping("/getEmployeeByUserId")
	public User getAllEmployees(@RequestParam Integer userId) {
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject("http://localhost:8889/getAllEmployee?userId=" + userId, User.class);
		return user;
	}
}

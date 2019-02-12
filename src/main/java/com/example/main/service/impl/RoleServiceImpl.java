package com.example.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.model.Role;
import com.example.main.repository.RoleRepository;
import com.example.main.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findRoleNativeQuery() {
		return roleRepository.findRoleByNativeQuery();
	}

	@Override
	public Role findRoleByRoleId(int roleId) {
		return roleRepository.findRoleByRoleId(roleId);
	}

	@Override
	public void add(Role role) {
		roleRepository.save(role);
	}

	@Override
	public void delete(Role role) {
		roleRepository.delete(role.getId());
	}

	@Override
	public List<Role> findByRole(String role) {
		return roleRepository.findByRole(role);
	}

	@Override
	public List<Role> findBySalary(String salary) {
		return roleRepository.findBySalary(salary);
	}
}
package com.example.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.main.model.Role;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {
	List<Role> findAll();

	@Query(value = "SELECT * FROM role u WHERE u.role_id = 1", nativeQuery = true)
	Role findRoleByNativeQuery();

	@Query(value = "SELECT * FROM role u WHERE u.role_id = ?1", nativeQuery = true)
	Role findRoleByRoleId(Integer roleId);

	List<Role> findByRole(String name);

	List<Role> findBySalary(String salary);

}
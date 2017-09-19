package com.example.main.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.main.dao.RoleDAO;
import com.example.main.model.Role;

@Transactional
@Repository
public class RoleDAOImpl implements RoleDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Role getRoleDetailsById(int role_id) {
		return entityManager.find(Role.class, role_id);
	}

	//Using HQL
	@Override
	public Role getRoleByHQL(String table, String condition) {
		// TODO Auto-generated method stub
		return null;
	}
}
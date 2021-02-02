package com.example.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "active")
	private int active;

	@Column(name = "email")
	private String email;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;

}
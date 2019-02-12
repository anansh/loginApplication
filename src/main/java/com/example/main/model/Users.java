package com.example.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "emp_id")
	private int emp_id;

	@Column(name = "level_id")
	private int level_id;

	@Column(name = "reg_div_id", nullable = true)
	private String reg_div_id;

	@Column(name = "profile_id")
	private int profile_id;

	@Column(name = "finance_id", nullable = true)
	private String finance_id;

	@Column(name = "create_date")
	private int create_date;

	public int getCreate_date() {
		return create_date;
	}

	public void setCreate_date(int create_date) {
		this.create_date = create_date;
	}

	public String getFinance_id() {
		return finance_id;
	}

	public void setFinance_id(String finance_id) {
		this.finance_id = finance_id;
	}

	public int getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}

	public String getReg_div_id() {
		return reg_div_id;
	}

	public void setReg_div_id(String reg_div_id) {
		this.reg_div_id = reg_div_id;
	}

	public int getLevel_id() {
		return level_id;
	}

	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

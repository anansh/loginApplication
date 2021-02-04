package com.example.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "temp_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TempDetails {
	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	private TempTable tempTable;
	
	@Column(name = "temp_details_id")
	private String tempDetailsId;

	@Column(name = "temp_name")
	private String tempName;
}
package com.example.main.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "temp1")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TempTable {

	@Id
	@Column
	private int id;

	@Column
	private String city;

	@Column
	private String town;

	@Column
	private String h2hCovered;

	@Column
	private int temp_details_id;

	@OneToMany(mappedBy = "tempTable")
	private List<TempDetails> tempDetails;
}
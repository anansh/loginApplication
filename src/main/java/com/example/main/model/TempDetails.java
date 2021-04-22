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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TempTable getTempTable() {
		return tempTable;
	}

	public void setTempTable(TempTable tempTable) {
		this.tempTable = tempTable;
	}

	public String getTempDetailsId() {
		return tempDetailsId;
	}

	public void setTempDetailsId(String tempDetailsId) {
		this.tempDetailsId = tempDetailsId;
	}

	public String getTempName() {
		return tempName;
	}

	public void setTempName(String tempName) {
		this.tempName = tempName;
	}
}
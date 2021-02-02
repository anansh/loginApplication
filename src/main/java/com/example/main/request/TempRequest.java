package com.example.main.request;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TempRequest {

	@Size(min = 4, message = "Name should have atleast 4 characters")
	private String city;
	private String town;
	private String h2hCovered;
}
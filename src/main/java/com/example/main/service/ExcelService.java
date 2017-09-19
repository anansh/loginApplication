package com.example.main.service;

public interface ExcelService {
	public void readExcel(String exSheet);

	public void writeExcel(String booleanResult, String exSheet, int rowNum);

	public String buildMyQuery(String parameter1, String parameter2, String expression, String sourceRule2,
			String sourceRule3);
}
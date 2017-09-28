package com.example.main.service;

public interface ExcelService {
	public void readExcel(String exSheet);

	public void writeExcel(String booleanResult, String exSheet, int rowNum);

	public boolean buildMyQuery(String expression, String groupBy, String OrderBy);
}
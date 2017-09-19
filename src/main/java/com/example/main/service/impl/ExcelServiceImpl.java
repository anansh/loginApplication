package com.example.main.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.dao.RoleDAO;
import com.example.main.model.Role;
import com.example.main.service.ExcelService;

@Service("excelService")
public class ExcelServiceImpl implements ExcelService {
	@Autowired
	private RoleDAO roleDao;

	@Override
	public void readExcel(String exSheet) {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File(exSheet));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(inputStream);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Sheet firstSheet = workbook.getSheetAt(0);

		int totalRows = firstSheet.getLastRowNum();
		for (int i = 0; i <= totalRows; i++) {
			if (i == 0) {
				continue;
			} else {
				Row row = firstSheet.getRow(i);
				if (row == null) {
					break;
				}
				String entity = row.getCell(0).getRichStringCellValue().toString();
				String parameter = row.getCell(1).getRichStringCellValue().toString();
				String sourceRule1 = row.getCell(2).getRichStringCellValue().toString();
				String sourceRule2 = row.getCell(3).getRichStringCellValue().toString();
				String sourceRule3 = row.getCell(4).getRichStringCellValue().toString();
				try {
					String booleanResult = buildMyQuery(entity, parameter, sourceRule1, sourceRule2, sourceRule3);
					writeExcel(booleanResult, exSheet, i);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		try {
			workbook.close();
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public String buildMyQuery(String parameter1, String parameter2, String expression, String sourceRule2,
			String sourceRule3) {
		String finalResult = "true";

		if (parameter2 == null || parameter2 == "" || parameter2.equals("")) {
			parameter2 = "*";
		}

		String mySql = "Select " + parameter2 + " from " + parameter1 + " where " + expression;
		System.out.println(mySql);

		int role_id = 1;
		System.out.println(roleDao);
		Role role = roleDao.getRoleDetailsById(role_id);
		System.out.println(role);
		return finalResult;
	}

	@Override
	public void writeExcel(String booleanResult, String exSheet, int rowNum) {
		Workbook workbook = null;
		System.out.println("booleanResult : " + booleanResult);
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(new File(exSheet));
			workbook = WorkbookFactory.create(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Cell cell2Update = sheet.getRow(rowNum).getCell(5);
			Row sheetrow = sheet.getRow(rowNum);
			if (cell2Update == null) {
				System.out.println(cell2Update);
				cell2Update = sheetrow.createCell(5);
				System.out.println(cell2Update);
			}
			cell2Update.setCellValue(booleanResult);
			outputStream = new FileOutputStream(new File(exSheet));
			workbook.write(outputStream);
			outputStream.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			workbook.close();
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
package com.example.main.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.example.main.dao.ExtractDAO;
import com.example.main.service.ExcelService;

@Service("excelService")
public class ExcelServiceImpl implements ExcelService {

	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

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
				try {
					boolean booleanResult = buildMyQuery(entity, parameter, sourceRule1);
					writeExcel(Boolean.toString(booleanResult), exSheet, i);
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
	public boolean buildMyQuery(String expression, String groupBy, String OrderBy) {

		expression.toString().contains("[");

		String newExpression = (expression.replace("{", "").replace("]", "").replace("[", "").replace(")", "")
				.replace("(", "").replace("}", "").replace("&&", " AND ").replace("||", " OR ").replace("!=", " <> ")
				.replace("==", " = ").replace("=", " = ").replaceAll("“", "'").replaceAll("”", "'")).toString();

		String[] splited = newExpression.split("\\s+|=");
		String[] hashedTable = null;
		Set<String> tableName = new HashSet<String>();

		for (int i = 0; i < splited.length; i++) {
			if (splited[i].toString().contains(".")) {
				hashedTable = splited[i].trim().split("\\.");
				tableName.add(hashedTable[0]);
			}
		}
		StringBuffer evenNumbers = new StringBuffer();
		int count = 1;
		for (String string : tableName) {
			if (count == tableName.size()) {
				evenNumbers.append(string);
				break;
			} else {
				evenNumbers.append(string).append(',');
			}
			count++;
		}

		System.out.println(evenNumbers);

		String query = "Select count(*) from " + evenNumbers.toString() + " where " + newExpression;

		System.out.println(query);
		ExtractDAO extractDAO = (ExtractDAO) context.getBean("extractDAO");
		boolean finalResult =extractDAO.getRoleDetailsById(query);
		return finalResult;
	}

	@Override
	public void writeExcel(String booleanResult, String exSheet, int rowNum) {
		Workbook workbook = null;
		// System.out.println("booleanResult : " + booleanResult);
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(new File(exSheet));
			workbook = WorkbookFactory.create(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Cell cell2Update = sheet.getRow(rowNum).getCell(3);
			Row sheetrow = sheet.getRow(rowNum);
			if (cell2Update == null) {
				System.out.println(cell2Update);
				cell2Update = sheetrow.createCell(3);
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
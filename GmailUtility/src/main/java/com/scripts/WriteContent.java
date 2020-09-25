package com.scripts;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.utility.Utilities;

public class WriteContent {

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	FileOutputStream file;
	Row row;

	@Test
	// method to create the excel sheet
	public void createExcel() throws IOException {

		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("ContentSheet");

		/**** name of the sheet to be according to the time it is executed ***/

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		LocalDateTime now = LocalDateTime.now();
		String Timegiven = dtf.format(now);
		String Time = Timegiven.replace(":", "");

		OutputStream files = new FileOutputStream(
				new File(System.getProperty("user.home") + "\\Desktop\\" + Time + "content.xlsx"));

		String content = Utilities.getContent();
		String Para[] = content.split("((\\n\\r)|(\\r\\n)){2}|(\\r){2}|(\\n){2}");
		for (int k = 0; k < Para.length; k++) {

			writeExcel(Para[k], k);

		}

	}

	// method to write the content extracted in spreadsheet
	public void writeExcel(String data, int j) throws IOException {
		Row row = sheet.createRow(j);
		Cell cell = row.createCell(0);
		cell.setCellValue(data);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		LocalDateTime now = LocalDateTime.now();
		String Timegiven = dtf.format(now);
		String Time = Timegiven.replace(":", "");

		FileOutputStream file = new FileOutputStream(
				new File(System.getProperty("user.home") + "\\Desktop\\" + Time + "content.xlsx"));
		workbook.write(file);

	}

}

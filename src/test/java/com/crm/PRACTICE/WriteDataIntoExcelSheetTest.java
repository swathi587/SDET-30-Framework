package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteDataIntoExcelSheetTest {
@Test
public void writeDataIntoExcelSheetTest() throws Throwable
{
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Excelsheet.xlsx");
	
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	Row ro = sh.getRow(0);	
	Cell ce = ro.createCell(7);
	ce.setCellValue("tc_100");
	FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\Excelsheet.xlsx");
     wb.write(fos);
}
}

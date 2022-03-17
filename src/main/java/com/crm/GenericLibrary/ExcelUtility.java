package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods to read and write data into excel sheet
 * @author Swathi G S
 *
 */
public class ExcelUtility {
	


		/**
		 * This method will read data from excel sheet and return the value when sheet name
		 * row no and cell no is specified
		 * @param SheetName
		 * @param Rownum
		 * @param CelNum
		 * @return
		 * @throws Throwable
		 */
		public String readDataFromExcel(String SheetName, int Rownum, int CelNum) throws Throwable
		{
			FileInputStream fis=new FileInputStream(IpathConstanants.ExcelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(SheetName);
			Row ro = sh.getRow(Rownum);
			Cell cel = ro.getCell(CelNum);
			String value = cel.getStringCellValue();
			return value;
		}
		
		public double readNumDataFromExcel(String SheetName, int Rownum, int CelNum) throws Throwable
		{
			FileInputStream fis=new FileInputStream(IpathConstanants.ExcelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(SheetName);
			Row ro = sh.getRow(Rownum);
			Cell cel = ro.getCell(CelNum);
			 double value = cel.getNumericCellValue();
			return value;
		}
		/**
		 * This method will write data into excel sheet
		 * @param SheetName
		 * @param Rownum
		 * @param CelNum
		 * @param value
		 * @throws Throwable
		 */
		public void writeDataIntoExcel(String SheetName, int Rownum, int CelNum, String value) throws Throwable
		{
			FileInputStream fis=new FileInputStream(IpathConstanants.ExcelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(SheetName);
			Row ro = sh.getRow(Rownum);
			Cell cel = ro.createCell(CelNum);
			 cel.setCellValue(value);
			 FileOutputStream fos=new FileOutputStream(IpathConstanants.ExcelPath);
			 wb.write(fos);
		}
	
		/**
		 * This method will return last row number
		 * @param SheetName
		 * @return
		 * @throws Throwable
		 */
		public int getRowCount(String SheetName) throws Throwable
		{
			FileInputStream fis=new FileInputStream(IpathConstanants.ExcelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(SheetName);
			int row = sh.getLastRowNum();
			return row;
		}
		
		public Object[][] readmultipleDataPrFromExcel(String SheetName) throws Throwable
		{
		FileInputStream fis = new FileInputStream(IpathConstanants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();


		Object[][] data = new Object[lastRow][lastCell];

		for(int i = 0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}

		return data;

		}

}
	




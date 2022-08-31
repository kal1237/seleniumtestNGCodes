package com.selfmwk.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook xwb;
	
	public ExcelDataProvider() 
	{
		File src=new File("./TestData/TestData.xlsx");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			xwb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("excel data not loaded"+e.getMessage());
		}
		
	}
	
	public String getDataInString(int sheetIndex,int row,int col)
	{
		return xwb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
	}
	public String getDataInString(String sheetName,int row,int col)
	{
		return xwb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}
	
	public double getNumericData(String sheetName,int row,int col)
	{
		return xwb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}
	

	}
	


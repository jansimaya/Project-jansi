package org.test4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelType {
	public static void main(String[] args) throws IOException {
		
	
    File f=new File("C:\\Users\\Freshservice\\eclipse-workspace\\Maven-Jansi\\src\\test\\resources\\ExcelReadd.xlsx");
	FileInputStream fi=new FileInputStream(f);
	Workbook w=new XSSFWorkbook(fi);
	Sheet s=w.getSheet("Sheet1");
	Row r=s.getRow(1);
	Cell c=r.getCell(0);
	int type = c.getCellType();
	System.out.println(type); 
	//type 1=String
	//type 0=number,date
	if(type==1) {
		String value = c.getStringCellValue();
		System.out.println(value);
	}
	else {
		if(DateUtil.isCellDateFormatted(c)) {
			Date d = c.getDateCellValue();
			SimpleDateFormat s1=new SimpleDateFormat("dd-MMM-yyyy");
			String value = s1.format(d);
			System.out.println(value);
			}
		else {
			double d= c.getNumericCellValue();
			long l=(long)d;
			String value = String.valueOf(l);
			System.out.println(value);
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	}
}

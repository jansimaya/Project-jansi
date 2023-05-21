package org.test4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
public static void main(String[] args) throws IOException {
	File f=new File("C:\\Users\\Freshservice\\eclipse-workspace\\Maven-Jansi\\src\\test\\resources\\ExcelReadd.xlsx");
	
	FileInputStream fi=new FileInputStream(f);
	
	Workbook w=new XSSFWorkbook(fi);
	
	Sheet s=w.getSheet("Sheet1");
	
	Row r=s.getRow(1);
	
	Cell c=r.getCell(0);
	
	
	System.out.println(c);
	
	int pr = s.getPhysicalNumberOfRows();
	System.out.println(pr);
	
	int pc = r.getPhysicalNumberOfCells();
	System.out.println(pc);
	
	for(int i=0;i<r.getPhysicalNumberOfCells();i++) {
		Cell c1 = r.getCell(i);
		System.out.println(c1);
	}
		for(int i=0;i<s.getPhysicalNumberOfRows();i++){
			Row row = s.getRow(i);
		for(int j=0;j<row.getPhysicalNumberOfCells();i++) {
			Cell c2 = r.getCell(j);
			System.out.println(c2);
		}
		}
		
		
	
	
	
	
	
}
}

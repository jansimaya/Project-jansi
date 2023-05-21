package org.test2;

import java.io.File;
import java.io.IOException;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


import org.test1.BaseClass;
import org.test3.LoginPage;

public class BrowserLaunch extends BaseClass{
public static void main(String[] args) throws IOException, InterruptedException {
	ChromeBrowser();
	urlLaunch("https://www.facebook.com/");
	maximize();
	wait(10);
   LoginPage l=new LoginPage();
   
   click(l.getCreatenew());
   sendKeys(l.getFirstname(), getExcel("ExcelReadd", "Sheet1", 1, 0));
   sendKeys(l.getLastname(), getExcel("ExcelReadd", "Sheet1", 1, 1));
   sendKeys(l.getMobile(), getExcel("ExcelReadd", "Sheet1", 1, 3));
   sendKeys(l.getPassword(), "Dkr@jmp");
   selectByIndex(l.getDay(), 8);
   selectByIndex(l.getMonth(), 2);
   selectByValue(l.getYear(), "1994");
   click(l.getFemalebtn());
   click(l.getSignup());

	
	
}


	
}
	
	
	
	


package org.test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriver ChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  return driver;
		 }
	public static WebDriver EdgeBrowser() {
		WebDriverManager.edgedriver().setup();
		  driver=new EdgeDriver();
		  return driver;
	}
	 public static void urlLaunch(String url) {
		 driver.get(url);
		}
	 public static void maximize() {
		driver.manage().window().maximize();
}
	 public static void wait( int sec) {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
		
	}
	 
	 
	public static void sendKeys(WebElement e,String value) {
		e.sendKeys(value);
}
	public static void click(WebElement e) {
		e.click();
}
	public static String currentUrl() {
		String url = driver.getCurrentUrl();
		return url;
		}
	public static String title() {
		String title = driver.getTitle();
		return title;

}
	public static void selectByIndex(WebElement e,int index) {
		Select s=new Select(e);
        s.selectByIndex(index);
	}
	public static void selectByValue(WebElement e,String value) {
		Select s=new Select(e);
        s.selectByValue(value);

	}
	public static String getExcel(String Filename,String Sheetname,int Row,int Cell) throws IOException {
		File f=new File("C:\\Users\\Freshservice\\eclipse-workspace\\Maven-Jansi\\src\\test\\resources\\"+Filename+".xlsx");
		FileInputStream fi=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fi);
		Sheet s=w.getSheet(Sheetname);
		Row r=s.getRow(Row);
		Cell c=r.getCell(Cell);
		int type = c.getCellType();
		System.out.println(type); 
		//type 1=String
		//type 0=number,date
		String value;
		if(type==1) {
			 value = c.getStringCellValue();
			System.out.println(value);
		}
		else {
			if(DateUtil.isCellDateFormatted(c)) {
				Date d = c.getDateCellValue();
				SimpleDateFormat s1=new SimpleDateFormat("dd-MMM-yyyy");
				 value = s1.format(d);
				System.out.println(value);
				}
			else {
				double d= c.getNumericCellValue();
				long l=(long)d;
				 value = String.valueOf(l);
				System.out.println(value);
				
			}
		}
		return value;

	}
	
	
	public static String getText(WebElement e) {
		String text = e.getText();
		return text;	
		}
	public static void javaScriptDown(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}
	public static void javaScript(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", e);
	}
    public static void javaScriptSendKeys(String txt,WebElement e) {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("arguments[0].setAttribute('value', 'txt')",e);
	}
	
	
	
	
	public static void takeScreenShot(String path) throws IOException {
		
	TakesScreenshot tk=(TakesScreenshot)driver;
	File src = tk.getScreenshotAs(OutputType.FILE);
	File des=new File(path);
	FileUtils.copyFile(src, des);
	}
	public static void windowHandles() {
		String parentid = driver.getWindowHandle();
	Set<String> allid = driver.getWindowHandles();
	
	for(String eachid : allid) {
		if(!parentid.equals(allid)) {
			driver.switchTo().window(eachid);
	
		}
	}
	
	}
	public static String webTable(WebElement e) {
		String text = e.getText();
		
	    List<WebElement> headings = e.findElements(By.tagName("th"));	
		for(int i=0;i<headings.size();i++) {
			WebElement heading = headings.get(i);
			String text2 = heading.getText();

	}
		return text;
}

}






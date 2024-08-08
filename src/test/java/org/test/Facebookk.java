package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebookk {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	WebElement email = driver.findElement(By.id("email"));
	email.sendKeys("jansi");	
	WebElement pass = driver.findElement(By.id("pass"));
    pass.sendKeys("9834");
	 driver.findElement(By.name("login").click);
	
	
	
	
	
	
	
}
}

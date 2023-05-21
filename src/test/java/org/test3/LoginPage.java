package org.test3;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test1.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@role='button'])[2]")
	private WebElement createnew;
    @FindBy(name="firstname")
	private WebElement firstname;
	@FindBy(xpath="(//input[@type='text'])[3]")
	private WebElement lastname;
    @FindBy(xpath="(//input[@type='text'])[4]")
	private WebElement mobile;
    @FindBy(xpath="(//button[text()='Sign Up'])[1]")
	private WebElement signup;
     @FindBy(id="password_step_input")
    private WebElement password;
    @FindBy(xpath="//label[text()='Female']")
    private WebElement femalebtn;
    @FindBy(id="day")
    private WebElement day;
    @FindBy(id="month")
    private WebElement month;
    @FindBy(id="year")
    private WebElement year;
    
    
	public WebElement getCreatenew() {
		return createnew;
	}
	public WebElement getFirstname() {
		return firstname;
	}
	public WebElement getLastname() {
		return lastname;
	}
	public WebElement getMobile() {
		return mobile;
	}
	public WebElement getSignup() {
		return signup;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getFemalebtn() {
		return femalebtn;
	}
	
	public WebElement getDay() {
		return day;
		
	}
	public WebElement getMonth() {
       return month;
	}
	
	public WebElement getYear() {
		return year;
	}
	
	}
	
	
	


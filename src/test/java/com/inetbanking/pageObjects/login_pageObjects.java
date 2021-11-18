package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_pageObjects {

	WebDriver ldriver;
	
	public login_pageObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(name="uid") WebElement username;
	
	@FindBy(name="password") WebElement pword;
	
	@FindBy(xpath="//input[@value=\"LOGIN\"]")  WebElement loginbbtn;
	
	
	public void setusername(String name) {
		username.sendKeys(name);
	}
	
	public void setpassword(String pwd) {
		pword.sendKeys(pwd);
	}
	
	public void loginclick() {
    loginbbtn.click();
	}
	
	
}

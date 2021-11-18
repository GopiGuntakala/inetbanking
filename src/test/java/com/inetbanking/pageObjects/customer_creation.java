package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class customer_creation {
WebDriver ldriver;
	
	public customer_creation(WebDriver driver) {
		
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href=\"addcustomerpage.php\"]") WebElement newcustomer;
	@FindBy(name="name") WebElement custname;
	@FindBy(name="dob") WebElement dateb;
	@FindBy(name="addr") WebElement addr;
	@FindBy(name="city") WebElement city;
	@FindBy(name="state") WebElement state;
	@FindBy(name="pinno") WebElement pin;
	@FindBy(name="telephoneno") WebElement telephoneno;
	@FindBy(name="emailid") WebElement emailid;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//input[@value=\"Submit\"]") WebElement submitbtn;
	
	
	
	public void clicknewcust() {
		newcustomer.click();
	}
	
	public void setcutname(String customerName) {
		custname.sendKeys(customerName);
	}
	
	public void Setdob(String dob) {
		dateb.sendKeys(dob);
	}
	
	public void setaddress(String address) {
		addr.sendKeys(address);
	}
	
	public void setcity(String City) {
		city.sendKeys(City);
	}
	
	public void setState(String State) {
		state.sendKeys(State);
	}
	
	public void setpin(String pinno) {
		pin.sendKeys(pinno);
	}
	
	public void setphno(String phno) {
		telephoneno.sendKeys(phno);
	}
	
	public void setemail(String email) {
		emailid.sendKeys(email);
	}
	
	public void setpwd(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void submitbtn() {
		submitbtn.click();
	}
	
	
}

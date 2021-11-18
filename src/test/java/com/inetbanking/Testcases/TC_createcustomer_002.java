package com.inetbanking.Testcases;

import java.io.IOException;
import java.util.Random;

import org.apache.commons.math3.random.RandomGenerator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.inetbanking.pageObjects.customer_creation;
import com.inetbanking.pageObjects.login_pageObjects;
import com.inetbanking.utilities.Reporting;
import com.inetbanking.utilities.excelutilities;

public class TC_createcustomer_002 extends BaseClass{
	
	excelutilities xlutils;
	customer_creation cc;
	login_pageObjects lp;
	Reporting report;
	String excelpath="C:\\selenium workspace\\inetbanking\\src\\test\\java\\com\\inetbanking\\Testdata\\userdata.xlsx";

	@Test
	public void creatingCustomer() throws IOException {
		xlutils=new excelutilities();
		cc=new customer_creation(driver);
		lp=new login_pageObjects(driver);
		 report=new Reporting();
		for(int i=1; i<=xlutils.getRowCount(excelpath,"Sheet1"); i++){
			
			XSSFRow row=xlutils.ws.getRow(i);
			
			String customerName=row.getCell(0).getStringCellValue();
			
			String DOB=row.getCell(1).getStringCellValue();
			String Address=row.getCell(2).getStringCellValue();
			String city=row.getCell(3).getStringCellValue();
			String state=row.getCell(4).getStringCellValue();
			String pin=row.getCell(5).getStringCellValue();
			String MobileNm=row.getCell(6).getStringCellValue();
			//String Email=row.getCell(7).getStringCellValue();
			String Password=row.getCell(8).getStringCellValue();
			
			lp.setusername(username);
			log.info("Entered username");
		
	//report.logger.info("Entered username -------------");
		//	report.logger.log(Status.INFO, MarkupHelper.createLabel("Entered username -------------", ExtentColor.BLUE));
			//report.logger=report.extent.createTest("Log generation");
		//	report.logger.log(Status.INFO, "Hello");
			
			lp.setpassword(password);
			log.info("Entered password");
			lp.loginclick();
			log.info("clicked on login button");
			cc.clicknewcust();
			log.info("Clicked on New Customer on home page");
			cc.setcutname(customerName);
			log.info("Entered customer name");
			cc.Setdob(DOB);
			log.info("Entered date of birth");
			cc.setaddress(Address);
			log.info("Entered Address");
			cc.setcity(city);
			log.info("Entered city name");
			cc.setState(state);
			log.info("Entered state name");
			cc.setpin(pin);
			log.info("Entered pincode");
			cc.setphno(MobileNm);
			log.info("Entered Mobile number");
			
			//Random randomEmail=new Random();
			//int number=randomEmail.nextInt(100);
			cc.setemail("usermail"+getRandomnum()+"@gmail.com");
			
			
			//cc.setemail(Email);
			log.info("Entered Email id");
			cc.setpwd(Password);
			log.info("Entered password");
			cc.submitbtn();
			log.info("Clicked on submit");
			
			if(driver.getPageSource().contains("Customer Registered Successfully!!!")) {
				Assert.assertTrue(true);
				log.info("Customer Resistration process successfully completed");
			}
			else {
				CaptureScreenshot(driver, "TC_createcustomer_002");
				log.info("Customer Resistration process not successfully completed");
				Assert.assertTrue(false);
				
			}
			
			
			
			
		}
		
		
	}
	
	
	public int getRandomnum() {
		Random randomEmail=new Random();
		int number=randomEmail.nextInt(1000);
		return number;
		
	}
	
	
	
}

package com.inetbanking.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.login_pageObjects;

public class TC_Login_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {
		
		log.info("URL launched");
		login_pageObjects lp=new login_pageObjects(driver);
		lp.setusername(username);
		log.info("Entered username");
		lp.setpassword(password);
		log.info("Entered password");
		lp.loginclick();
		log.info("Clicked on Login Button");
	
		
		if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage")) {
			
			Assert.assertTrue(true);
			log.info("Got expected Title");
			
		}
		else {
			CaptureScreenshot(driver,"TC_Login_001");
			log.info("Got unexpected Title");
			
			Assert.assertTrue(false);
			
		}
	}
	
	
}

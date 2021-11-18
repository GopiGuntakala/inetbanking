package com.inetbanking.Testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.utils.FileUtil;
import com.inetbanking.utilities.Readconfig;


public class BaseClass {
	
	Readconfig readprop=new Readconfig();
	WebDriver driver;
	
	String URL=readprop.getaBaseURL();
	String username=readprop.getUsername();
	String password=readprop.getPassword();
	
	Logger log;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		log=Logger.getLogger("inetbanking");
		PropertyConfigurator.configure("log4j.properties");
		
		
		if(br.equalsIgnoreCase("chrome")) {
		
		System.setProperty("webdriver.chrome.driver",readprop.getchromepath());
		driver=new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",readprop.getfirefoxpath());
			driver=new FirefoxDriver();
		}
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(URL);
		
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	
	public void CaptureScreenshot(WebDriver driver, String name) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+name+".png");
		FileUtils.copyFile(file, target);
		System.out.println("Scressnshot taken");
		
	}
}

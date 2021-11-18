package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {
	
	Properties pro;
	
	public Readconfig() {
		
		File file=new File("./configuration//config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(file);
			pro=new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
			
		}
		
		
		
		}
	
	    public String getaBaseURL() {
		String url=pro.getProperty("baseurl");
		return url;
	    }
		public String getUsername() {
			String uname=pro.getProperty("username");
			return uname;
		}
		
		public String getPassword() {
			String password=pro.getProperty("password");
			return password;
			
		}
		public String getchromepath() {
			String chromepath=pro.getProperty("chromepath");
			return chromepath;
			
		}
		
		public String getfirefoxpath() {
			String firefoxpath=pro.getProperty("firefoxpath");
			return firefoxpath;
			
		}
	}



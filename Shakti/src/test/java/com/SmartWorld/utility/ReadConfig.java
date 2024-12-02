package com.SmartWorld.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	String path="C:\\Users\\ernik\\eclipse-workspace\\Shakti\\configuration\\Config.properties";
	
	public ReadConfig() {
		try {
		properties =new Properties();
		FileInputStream fis=new FileInputStream(path);
		properties.load(fis); }
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public  String getBaseUrl() {
		String value=properties.getProperty("url");
		if(value!=null)
		return value;
		else
			throw new RuntimeException("url not specified in the properties file");
	}
	
	public String getBrowser() {
		String value=properties.getProperty("browser");
		if(value!=null)
		return value;
		else 
			throw new RuntimeException("browser is not specified in properties file");
	}
	
	public String getUsername() {
		String value=properties.getProperty("username");
		if(value!=null)
		return value;
		else 
			throw new RuntimeException("username is not specified in properties file");
	}
	
	public String getPassword() {
		String value=properties.getProperty("password");
		if(value!=null)
		return value;
		else
			throw new RuntimeException("password is not configured in the properties file");
	} 
	
	
	/*public String dataToBeRead(String data) {
		String value=properties.getProperty(data);
		return value;
	} */
 
}

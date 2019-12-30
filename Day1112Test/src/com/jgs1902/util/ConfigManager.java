package com.jgs1902.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
	private static ConfigManager configManager;
	Properties properties=new Properties();
	
	private ConfigManager() {
		String configFile="database.properties";
		InputStream in=ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	提供一个唯一的ConfigManager对象
	public static synchronized ConfigManager getInstance() {
		if(configManager==null) {
			configManager = new ConfigManager();
		}
		return configManager;
	}
//	根据键获取值
	public String getString(String key) {
		return properties.getProperty(key);
	}
}

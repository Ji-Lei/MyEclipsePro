package com.jgs1902.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	public static String getValue(String key) {
		Properties properties=new Properties();
		String configFile="database.properties";
		InputStream in=Config.class.getClassLoader().getResourceAsStream(configFile);
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}

}

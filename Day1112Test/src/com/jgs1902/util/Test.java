package com.jgs1902.util;

public class Test {
	public static void main(String[] args) {
//		String driver=Config.getValue("driver");
//		String url=Config.getValue("url");
//		String uname=Config.getValue("uname");
//		String password=Config.getValue("password");
		String driver=ConfigManager.getInstance().getString("driver");
		String url=ConfigManager.getInstance().getString("url");
		String uname=ConfigManager.getInstance().getString("uname");
		String password=ConfigManager.getInstance().getString("password");
		System.out.println(driver+" "+url+" "+uname+" "+password);
	}
}

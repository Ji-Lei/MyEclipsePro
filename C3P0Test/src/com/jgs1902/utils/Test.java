package com.jgs1902.utils;

import com.jgs1902.sql.LoginSql;

public class Test {
	public static void main(String[] args) {
		LoginSql loginSql=new LoginSql();
		loginSql.checkLogin("admin");
	}
}

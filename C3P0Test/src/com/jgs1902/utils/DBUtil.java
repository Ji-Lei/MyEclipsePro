package com.jgs1902.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {
	static ComboPooledDataSource cpds;// 静态代码块
	static {
		/*        
         * 读取c3p0的xml配置文件创建数据源，c3p0的xml配置文件c3p0-config.xml必须放在src目录下
         * 使用c3p0的命名配置读取数据源
         */
		cpds = new ComboPooledDataSource("dev");
		}

// 从数据源中获取数据库的连接
	public static Connection getConnection() throws SQLException {
		return cpds.getConnection();
	}

	// 释放资源，将数据库连接还给数据库连接池
	public static void closeDB(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
//				rs.close();
				rs.close();	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
			if (ps != null) {
				ps.close();
			}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
				if (conn != null) {
					conn.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
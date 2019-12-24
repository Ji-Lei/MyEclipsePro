package com.air.util;

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
	
	static Connection conn = null;
	static PreparedStatement psmt = null;
	static ResultSet rs = null;
  //公共查询方法
    public static ResultSet select(String sql, Object[] obj) {
        
        try {
        	//1.创建连接
        	conn=DBUtil.getConnection();
            //2.写SQL
            //3.创建预处理对象
            psmt = conn.prepareStatement(sql);
            //4.给占位符赋值
            if (obj.length > 0) {
                for (int i = 0; i < obj.length; i++) {
                    psmt.setObject(i+1,obj[i]);
                }
            }
            //5.运行SQL返回结果集
            rs = psmt.executeQuery();
            //6.处理结果集,由于不同的查询条件，返回的结果集内容不同
            //所以将结果集作为方法的返回值，交由不同的方法来处理
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

//    1.创建连接
//    2.写SQL
//    3.创建预处理对象
//    4.给占位符传参
//    5.执行并返回数字
    //增删改的公共方法
    public static Integer update(String sql, Object[] obj) {
        int count = 0;   
        try {
        	//1.创建连接
        	conn=DBUtil.getConnection();
            //2.写SQL
            //3.创建预处理对象
            psmt = conn.prepareStatement(sql);
            //4.给占位符赋值
            if (obj.length > 0) {
                for (int i = 0; i < obj.length; i++) {
                    psmt.setObject(i+1,obj[i]);
                }
            }
            //5.执行并返回数字
            count = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeDB(conn, psmt, rs);
        }
        return count;
    }
	
}
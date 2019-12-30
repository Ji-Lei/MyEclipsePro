package com.jgs1902.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jgs1902.util.Config;
import com.jgs1902.util.ConfigManager;

public class BaseDao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
    public boolean getConn(){
        //注册jdbc驱动
        try {
            Class.forName(ConfigManager.getInstance().getString("driver"));
            conn = DriverManager.getConnection(ConfigManager.getInstance().getString("url"), ConfigManager.getInstance().getString("uname"), ConfigManager.getInstance().getString("password"));
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
	//关闭对象方法
    public void closeSql(ResultSet rs,Statement st,Connection conn){
        closeRs(rs);
        closeSt(st);
        closeConn(conn);
    }
    public void closeSql(Statement st,Connection conn){
        closeSt(st);
        closeConn(conn);
    }
    //关闭ResultSet对象
    private static void  closeRs(ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            rs=null;
        }
    }
    //关闭Statement对象
    private static void  closeSt(Statement st){
        try{
            if(st!=null){
                st.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            st=null;
        }
    }
    //关闭Connection对像
    private static void  closeConn(Connection conn){
        try{
            if(conn!=null){
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            conn=null;
        }
    }
    
    
    public Integer executeUpdate(String sql,Object[] params) {
    	//将占位符的位置设置成数组模式，并且长度不固定，可通过循环的方式设置占位符的值
    	Integer conut=0;
    	if(this.getConn()) {
    		try {
				ps=conn.prepareStatement(sql);
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
				conut=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	
    	return conut;
    }
    public ResultSet executeSql(String sql,Object[] params) {
    	if(this.getConn()) {
    		try {
				ps=conn.prepareStatement(sql);
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
				rs = ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	return rs;
    }
}

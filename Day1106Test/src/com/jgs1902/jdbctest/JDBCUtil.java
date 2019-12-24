package com.jgs1902.jdbctest;

import java.sql.*;

//JDBC公共方法（连接和关闭）
public class JDBCUtil {

    public  static Connection getConn(){
        Connection conn=null;
        //注册jdbc驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://120.78.187.149:3306/username", "root", "yulei970423L");
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return conn;
    }
    //关闭对象方法
    public static void closeSql(ResultSet rs,Statement st,Connection conn){
        closeRs(rs);
        closeSt(st);
        closeConn(conn);
    }
    public static void closeSql(Statement st,Connection conn){
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

}

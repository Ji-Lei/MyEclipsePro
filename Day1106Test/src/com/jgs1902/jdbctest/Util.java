package com.jgs1902.jdbctest;

import java.sql.*;

public class Util {

//    注册方法
    public static void insertRegi(String userid,String upwd,String email,String name,String sex,String hobbise){
        Connection conn=null;
        Statement st=null;
        try {
            conn=JDBCUtil.getConn();
            st=conn.createStatement();
            String sql="insert into regiUser values ("+null+",'"+userid+"','"+upwd+"','"+email+"','"+name+"','"+sex+"','"+hobbise+"')";
            st.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtil.closeSql(st,conn);
        }
    }

    public static String getUserid(String userid){
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        String user=null;
        try {
            conn=JDBCUtil.getConn();
            st=conn.createStatement();
            String sql="select userid from regiUser where userid='"+userid+"';";
            rs=st.executeQuery(sql);
            while (rs.next()){
                user=rs.getString("userid");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtil.closeSql(rs,st,conn);
        }
        return user;
    }

    public static String getEmail(String email){
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        String user=null;
        try {
            conn=JDBCUtil.getConn();
            st=conn.createStatement();
            String sql="select email from regiUser where email='"+email+"';";
            rs=st.executeQuery(sql);
            while (rs.next()){
                user=rs.getString("email");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtil.closeSql(rs,st,conn);
        }
        return user;
    }

    public static String getName(String userid){
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        String user=null;
        try {
            conn=JDBCUtil.getConn();
            st=conn.createStatement();
            String sql="select name from regiUser where userid='"+userid+"';";
            rs=st.executeQuery(sql);
            while (rs.next()){
                user=rs.getString("name");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtil.closeSql(rs,st,conn);
        }
        return user;
    }

}

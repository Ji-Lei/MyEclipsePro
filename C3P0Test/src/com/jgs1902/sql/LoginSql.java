package com.jgs1902.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jgs1902.utils.DBUtil;

public class LoginSql {
	public boolean checkLogin(String userid){
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//调用getConnection()数据连接
			connection = DBUtil.getConnection();
			String sql="select * from regiUser where userid=?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(
								rs.getString("userid")+"\n"+
								rs.getString("password")+"\n"+
								rs.getString("email")+"\n"+
								rs.getString("name")+"\n"+
								rs.getString("sex")+"\n"+
								rs.getString("hobbies")+"\n"
						);
				return true;
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBUtil.closeDB(connection, ps, rs);
			}
		return false;
	}

}

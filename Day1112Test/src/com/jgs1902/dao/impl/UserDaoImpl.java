package com.jgs1902.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jgs1902.dao.UserDao;
import com.jgs1902.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao{


//查询用户信息
	public List<User> getUserList() {
		List<User> list=new ArrayList<User>();
		try {
			this.getConn();
			String sql="select * from regiUser;";
			Object[] params= {};
			ResultSet rs=this.executeSql(sql, params);
			while(rs.next()) {
				String userid=rs.getString("userid");
				String password=rs.getString("password");
				String email=rs.getString("email");
				String name=rs.getString("name");
				String sex=rs.getString("sex");
				String hobbies=rs.getString("hobbies");
				User user=new User(userid, password, email, name, sex, hobbies);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeSql(rs, ps, conn);
		}
		return list;
	}

//	根据用户名查询单个用户信息
	public User getUserById(String userid) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User user=new User();
		try {
			this.getConn();
			String sql="select * from regiUser where userid=?";
			Object[] params= {userid};
			ResultSet rs1=this.executeSql(sql, params);
			while(rs1.next()) {
				user.setName(rs1.getString("name"));
				user.setEmail(rs1.getString("email"));
				user.setHobbies(rs1.getString("hobbies"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeSql(rs, ps, conn);
		}
		return user;
	}

	@Override
	public Integer addUser(User user) {
		Integer count=0;
		this.getConn();
		Object[] params = {user.getUserid(), user.getPassword(), user.getEmail(), user.getName(), user.getSex(), user.getHobbies()};
		String sql="insert into regiUser values(?,?,?,?,?,?)";
		count=this.executeUpdate(sql, params);//调用该方法同时运行sql语句
		this.closeSql(ps, conn);
		return count;
	}

//	修改用户信息
	public Integer updateUser(User user) {
		Integer count=0;
		this.getConn();
		Object[] params = {user.getPassword(), user.getEmail(), user.getName(), user.getSex(), user.getHobbies(),user.getUserid()};
		String sql="update regiUser set password=?,email=?,name=?,sex=?,hobbies=? where userid=?";
		count=this.executeUpdate(sql,params);
		this.closeSql(ps, conn);
		return count;
	}

//	删除
	public Integer deleteUser(String userid) {
		Integer count=0;
		this.getConn();
		Object[] params= {userid};
		String sql="delete from regiUser where userid=?";
		this.executeUpdate(sql, params);
		this.closeSql(ps, conn);
		return count;
	}   
}

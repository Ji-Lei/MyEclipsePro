package com.jgs1902.pojo;

public class User {
	private String userid;
	private String password;
	private String email;
	private String name;
	private String sex;
	private String hobbies;
	
	public User() {
	}
	
	public User(String userid, String password, String email, String name, String sex, String hobbies) {
		this.userid = userid;
		this.password = password;
		this.email = email;
		this.name = name;
		this.sex = sex;
		this.hobbies = hobbies;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	
}

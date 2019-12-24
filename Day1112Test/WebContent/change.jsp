<%@page import="com.jgs1902.pojo.User"%>
<%@page import="com.jgs1902.dao.impl.UserDaoImpl"%>
<%@page import="com.jgs1902.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//设置字符编码
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");

	UserDao userDao=new UserDaoImpl();
	String userid=(String)session.getAttribute("userid");
	String password=request.getParameter("password");
	String email=request.getParameter("email");
	String name=request.getParameter("name");
	String sex=request.getParameter("sex");
	String hobbies=request.getParameter("hobbies");
	User user = new User(userid,password,email,name,sex,hobbies);
	Integer conut=userDao.updateUser(user);
	response.sendRedirect(request.getContextPath()+"/index.jsp");
%>
</body>
</html>
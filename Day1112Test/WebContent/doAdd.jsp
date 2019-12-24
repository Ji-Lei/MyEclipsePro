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
		//获取表单页提交的数据
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String hobbies=request.getParameter("hobbies");
		
		UserDao dao=new UserDaoImpl();
		User user=new User(userid,password,email,name,sex,hobbies);
		request.setAttribute("error", "请添加！！！");
		Integer conut=dao.addUser(user);
		if(conut>0){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else{
			request.setAttribute("error", "添加失败，用户名或邮箱重复！！"+conut);
			request.getRequestDispatcher("add.jsp").forward(request, response);
		}
%>
</body>
</html>
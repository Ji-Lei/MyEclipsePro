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
	UserDao dao=new UserDaoImpl();
	String userid=(String)session.getAttribute("userid");
	Integer count = dao.deleteUser(userid);
	response.sendRedirect(request.getContextPath()+"/index.jsp");
%>
</body>
</html>
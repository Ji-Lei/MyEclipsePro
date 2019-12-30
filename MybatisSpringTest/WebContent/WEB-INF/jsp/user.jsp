<%@page import="pojo.User"%>
<%@page import="pojo.UsersList"%>
<%@page import="java.util.List"%>
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
	List<UsersList> list=(List)request.getAttribute("user");
	for(UsersList usersList:list) {
		for(User user:usersList.getList()) {
			System.out.println("用户名："+user.getUsername());
		}
	}
%>
	数量：${user}
	<form action="user/user1">
		<input type="text" name="username">
		<input type="submit">
	</form>
</body>
</html>
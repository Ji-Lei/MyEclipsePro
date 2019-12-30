<%@page import="com.jgs1902.pojo.User"%>
<%@page import="java.util.List"%>
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
<!-- 注：没用新闻类，用的用户类，也包含增删改查，实现了一样的功能 -->
<%
	UserDao dao=new UserDaoImpl();
	List<User> userList=dao.getUserList();
%>
<a href="add.jsp">点击添加用户信息！</a>

<table border="1">
	<tr>
		<th>用户名</th>
		<th>密码</th>
		<th>邮箱</th>
		<th>姓名</th>
		<th>性别</th>
		<th>爱好</th>
		<th>操作</th>
	</tr>
	<%
		for(User user:userList){
	%>
	<tr>
		<td><%=user.getUserid()%></td>
		<td><%=user.getPassword()%></td>
		<td><%=user.getEmail()%></td>
		<td><%=user.getName()%></td>
		<td><%=user.getSex()%></td>
		<td><%=user.getHobbies()%></td>
		<th>
			<%
				session.setAttribute("userid", user.getUserid());
			%>
			<a href="delete.jsp">删除</a>
			<a href="update.jsp?userid=<%=user.getUserid()%>">修改</a>
		</th>
	</tr>
	
	<%
		}
	%>
</table>
</body>
</html>
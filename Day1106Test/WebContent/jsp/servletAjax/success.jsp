<%--
  Created by IntelliJ IDEA.
  User: 纪小雷
  Date: 2019/11/06
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" ; charset=UTF-8>
    <title>Title</title>
    
</head>
<body>
<h3 class="wel"></h3>
    <%
    	String name=request.getParameter("name");
        out.print("注册成功，欢迎您加入架构师1902大家庭："+name);
    %>
</body>
</html>

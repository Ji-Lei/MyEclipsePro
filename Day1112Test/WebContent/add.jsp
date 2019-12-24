<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=request.getAttribute("error") %>
<h3>注：为演示效果，密码也展示</h3>
<form action="doAdd.jsp" method="post">
	用户名：<input type="text" name="userid" /><br/>
	密码：<input type="password" name="password" /><br/>
	邮箱：<input type="text" name="email" /><br/>
	姓名：<input type="text" name="name" /><br/>
	性别：<input type="text" name="sex" /><br/>
	爱好：<input type="text" name="hobbies" /><br/>
	<input type="submit" value="提交" />
</form>
</body>
</html>
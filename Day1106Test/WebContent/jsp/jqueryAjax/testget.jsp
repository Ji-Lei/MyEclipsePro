<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../js/jquery-3.4.1.js"></script>

<script type="text/javascript">
function register(){
	var mobile=$("#mobile").val();
	$.get(
			"../../mobile",
			"mobile="+mobile,
			function (result){//后面可以加个state状态参数function (result,state)，成功的话，返回success
				if(result=="true"){
					alert("注册成功！！");
				}else{
					alert("该改手机号已经被注册，注册失败！！");
				}
			},
			"text"
		);
}
</script>

</head>
<body>
用户名：<input type="text" id="mobile" value=""/>
    <input type="submit" value="注册" onclick="register()" />
</body>
</html>
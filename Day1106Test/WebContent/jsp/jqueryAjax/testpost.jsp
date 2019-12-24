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
	$.post(
			"../../mobile",
			"mobile="+mobile,
			function (result){
				if(result=="true"){
					alert("该改手机号已经被注册，注册失败！！");
				}else{
					$(".phone").html(result);
				}
			},
			"text"
		);
}

</script>


</head>
<body>
<h3 class="phone"></h3>
用户名：<input type="text" id="mobile" value=""/>
    <input type="submit" value="注册" onclick="register()" />
</body>
</html>
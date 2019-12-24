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
		$.ajax({
			url:"../../mobile?mobile="+mobile,
			type:"post",
			success:function(result,testStatus){//testStatus运行状态，成功返回success
				if(result=="true"){
					alert("注册成功！！");
				}else{
					alert("手机号已经存在，注册失败！！");
				}
			},
			//服务端错误会跳到下面
			error:function(xhr,errorMessage,e){
				alert("系统异常！！");
			}
		});
	}
</script>
</head>
<body>
    用户名：<input type="text" id="mobile" value=""/>
    <input type="submit" value="注册" onclick="register()" />
</body>
</html>
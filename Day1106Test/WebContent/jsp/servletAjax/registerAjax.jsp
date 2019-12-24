<%@ page import="com.jgs1902.jdbctest.Util" %><%--
  Created by IntelliJ IDEA.
  User: 纪小雷
  Date: 2019/11/06
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" ; charset=UTF-8>
    <title>请注册！！</title>
    <script>
    /* 连接服务器数据库，可通过任何电脑连接，测试 */
        function register() {

            var userid=document.getElementById("userid").value;
            var check1=document.getElementsByClassName("check1");
            if(userid==""){
                check1[0].innerHTML="用户名不能为空！！！";
                return false;
            }
             check1[0].innerHTML="";
            var password=document.getElementById("password").value;
            var check2=document.getElementsByClassName("check2");
            if(password==""){
                check2[0].innerHTML="密码不能为空！！！";
                return false;
            }
            check2[0].innerHTML="";
            var email=document.getElementById("email").value;
            //对email格式进行判断
            var check3=document.getElementsByClassName("check3");
            var reg = /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/; //正则表达式
            if(email==""){
                check3[0].innerHTML="邮箱不能为空！！！";
                return false;
            }else if(!reg.test(email)){
                check3[0].innerHTML="邮箱格式不正确！！！";
                return false;
            }
            check3[0].innerHTML="";

            var name=document.getElementById("name").value;
            var check4=document.getElementsByClassName("check4");
            if(name==""){
                check4[0].innerHTML="姓名不能为空！！！"
                return false;
            }
            check4[0].innerHTML="";
            // alert("纪雷");//测试有没有运行至此
            var sexs=document.getElementsByName("sex1");
            var sex="";
            for(var i=0;i<sexs.length;i++){
                if(sexs[i].checked==true){
                    sex=sexs[i].value;
                    break;
                }
            }
            //alert(sex);//测试有没有运行至此
            var hobbis=document.getElementsByName("hobby");
            var hobbies="";
            for (var i = 0; i < hobbis.length; i++) {
                if(hobbis[i].checked==true){
                    hobbies=hobbies+hobbis[i].value+" ";
                }
            }
            //alert(hobbies);//测试有没有运行至此
            //    通过Ajax异步方式请求服务器
            xmlHttpRequest = new XMLHttpRequest();

            //    设置xmlHttpRequest的回调函数
            xmlHttpRequest.onreadystatechange = callBack;
			//请求方式和servlet地址
            xmlHttpRequest.open("post","../../register",true);
            //    设置post方式的头信息
            xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

            xmlHttpRequest.send("userid="+userid+"&password="+password+"&email="+email+"&name="+name+"&sex="+sex+"&hobbies="+hobbies);
            // alert("纪雷");//测试有没有运行至此
        }
        function callBack() {
            // alert("纪小雷");//测试有没有运行至此
            //判断状态码是多少（服务器是否正常运行）
            if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200){
                // 接收服务端返回数据

                var date = xmlHttpRequest.responseText;//服务端返回值为String格式
                if(date == "true"){
                    //注册失败,不跳转,弹出失败原因
                    alert("此用户名已存在，请更换！！！");
                }else if (date == "exit") {
                    //注册失败,不跳转,弹出失败原因
                    alert("此邮箱已经被注册！！！");
                }else {
                	var name=document.getElementById("name").value;
                	window.location.href="success.jsp?name="+name;
                }
            }
        }
    </script>
</head>
<body>
    用户名：<input type="text" id="userid" value=""/><span style="color: red;font-size: 10px;" class="check1"></span><br>
    密码：<input type="password" id="password" value=""><span style="color: red;font-size: 10px;" class="check2"></span><br>
    邮箱：<input type="text" id="email" value=""/><span style="color: red;font-size: 10px;" class="check3"></span><br>
    姓名：<input type="text" id="name" value=""><span style="color: red;font-size: 10px;" class="check4"></span><br>
    性别：<input type="radio" name="sex1" value="男"/>男
         <input type="radio" name="sex1" value="女"/>女<br>
    爱好：<input type="checkbox" name="hobby" value="篮球"/>篮球
         <input type="checkbox" name="hobby" value="足球"/>足球
         <input type="checkbox" name="hobby" value="乒乓球"/>乒乓球<br>
    <input type="button" value="注册" onclick="register()" />
</body>
</html>

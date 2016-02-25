<%@page import="com.manyouyou.ordersystem.commons.ResponseConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>标题</title>        
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
  <script type="text/javascript" src="js/common.js"></script>
  <link href="css/index.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript">
	
	var $name;//设置全局变量
	var $nameError;
	var $password;
	var $passwordError;
	$(function(){
		$name = $("#name");
		$password = $("#password");
		$nameError = $("#nameError");
		$passwordError = $("#passwordError");
		var $submit = $("#submit");
		var $loginForm = $("#loginForm");
		//console.info($name);
		//name输入框绑定鼠标焦点事件，当焦点离开时触发
		 $name.blur(function() {
			 validate($name,$nameError);
             
		 });
		 
		 $password.blur(function() {
			 validate($password,$passwordError);
		 });
		
		var $registButt = $("#regist");
		
		$registButt.click(function(){
			//$.post("user/regist.do",function(data){},"json");
			window.location.href="view/user/registUser.jsp";
		});
		
	});
	

	/*提交表单前先校验用户名和密码是否为空*/
	function checkOnsubmit(){
		var nameValue = $name.val();
		var pwdValue = $password.val();
		if(isNullOrBlank(nameValue)){
			$nameError.html("用户名不能为空");
			$nameError.css("color","red");
			return false;
		}else if(isNullOrBlank(pwdValue)){
			$passwordError.html("密码不能为空");
			$passwordError.css("color","red");
			return false;
		}else{
			return true;
		}
	}
	
</script>
 </head>
<body>
	<div class="loginHead">
		<p align="center" style="font: 4">welcome to order manager system</p>

	</div>
	<div class="logindiv">
		<form action="user/login.do" method="post" accept-charset="utf-8" onsubmit="return checkOnsubmit()">
			<table>
				<tr>
					<td>username:</td>
					<td>
						<input type="text" name="name" id="name" placeholder="place input username"/>
						<span id="nameError"></span>
					</td>
				</tr>
				<tr>
					<td>password:</td>
					<td>
						<input type="password" name="password" id="password" placeholder="place input password"/>
						<span id="passwordError"></span>
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" value="regist" id="regist"/>
					</td>
					<td>
						<input type="submit" value="submit" id="submit"/>
					</td>		
				</tr>
			</table>
		</form>
	</div>
	<div class="loginErrorDiv">
		<span>
			<%=request.getAttribute(ResponseConstant.RSP_ATTR_LOGIN_ERROR)==null ? "":request.getAttribute(ResponseConstant.RSP_ATTR_LOGIN_ERROR) %>
		</span>
	</div>
</body>
</html>
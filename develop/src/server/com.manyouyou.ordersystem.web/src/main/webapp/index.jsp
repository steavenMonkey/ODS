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
	
	$(function(){

		var $name = $("#name");
		var $password = $("#password");
		var $nameError = $("#nameError");
		var $passwordError = $("#passwordError");
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
	
	
	
</script>
 </head>
<body style="">
	<div class="loginHead">
		<p align="center" style="font: 4">welcome to order manager system</p>

	</div>
	<div style="margin-top: 100px" class="logindiv">
		<form action="user/login.do" method="post" accept-charset="utf-8">
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
						<input type="submit" value="submit"/>
					</td>		
				</tr>
			</table>
		</form>

	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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

<link href="css/newUser.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
	$(function(){
		var $resetButt = $("#resetButt");
		var $registButt = $("#registButt");
		var $name = $("#name");
		var $password = $("#password");
		var $confirm = $("#confirm");
		var $phoneNum = $("#phoneNum");
		//span element
		var $nameErr = $("#nameErr");
		var $passwordErr = $("#passwordErr");
		var $confirmErr = $("#confirmErr");
		var $phoneNumErr = $("#phoneNumErr");
		
		/*重置按钮，清除所有输入框的内容*/
		$resetButt.click(function(){
			clearInputValue($name);
			clearInputValue($password);
			clearInputValue($confirm);
			clearInputValue($phoneNum);
			$nameErr.html("");
			$passwordErr.html("");
			$confirmErr.html("");
			$phoneNumErr.html("");
		});
		
		inputValidate($name,$nameErr);
		inputValidate($password,$passwordErr);
		inputValidate($phoneNum,$phoneNumErr);
		
		$confirm.focus(function(){
			$confirmErr.html("");
		});
	
		$confirm.blur(function(){	
			$confirmErr.html("");
			var $passwordVal = $password.val();
			var $confirmVal = $confirm.val();
			console.info($confirmVal.trim().length);
			if( $confirmVal.trim().length >0 && $passwordVal != $confirmVal){
				$confirmErr.html("the password is not the same");
				$confirmErr.css("color","red");
			}else{
				validate($confirm,$confirmErr)
			}
		});
		
		
	});
	

</script>
</head>
<body>
	<div class="loginHead">
		<p align="center" style="font: 4">welcome to order manager system</p>
	</div>
	<div class="registUser">
		<form action="user/regist.do" method="post" accept-charset="utf-8">
			<table>
				<tr>
					<td>用户名:</td>
					<td>
						<input type="text" name="name" id="name"/>
						<span id="nameErr"></span>
					</td>
				</tr>
				<tr>
					<td>密码:</td>
					<td>
						<input type="password" name="password" id="password"/>
						<span id="passwordErr"></span>
					</td>
				</tr>
				<tr>
					<td>确认密码:</td>
					<td>
						<input type="password" name="confirm" id="confirm"/>
						<span id="confirmErr"></span>
					</td>
				</tr>
				<tr>
					<td>联系方式:</td>
					<td>
						<input type="password" name="phoneNumber" id="phoneNum"/>
						<span id="phoneNumErr"></span>
					</td>
				</tr>
				<tr>
					<td id="registButton" colspan="2">
						<input type="button" value="重置" id="resetButt"/> 
						<input type="submit" value="注册" id="registButt"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
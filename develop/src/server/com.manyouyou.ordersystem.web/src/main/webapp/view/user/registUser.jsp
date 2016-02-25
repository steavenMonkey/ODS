<%@page import="com.manyouyou.ordersystem.commons.ResponseConstant"%>
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
<title>用户注册</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="css/registUser.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">

	var $name;
	var $password;
	var $confirm;
	var $phoneNum;
	
	var $nameErr;
	var $passwordErr;
	var $confirmErr;
	var $phoneNumErr;
	
	$(function(){
		var $resetButt = $("#resetButt");
		var $registButt = $("#registButt");
		$name = $("#name");
		$password = $("#password");
		$confirm = $("#confirm");
		$phoneNum = $("#phoneNum");
		//span element
		$nameErr = $("#nameErr");
		$passwordErr = $("#passwordErr");
		$confirmErr = $("#confirmErr");
		$phoneNumErr = $("#phoneNumErr");
		
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
				$confirmErr.html("两次密码不一致");
				$confirmErr.css("color","red");
			}else{
				validate($confirm,$confirmErr)
			}
		});
		
		function checkOnSubmit(){
			var nameValue = $name.val();
			var pwdValue = $password.val();
			var confirmValue = $confirm.val();
			var phoneNumValue = $phoneNum.val();
			
			if(isNullOrBlank(nameValue)){
				appendErrMsg($nameErr, "用户名不能为空")
				return false;
			}else if(isNullOrBlank(pwdValue)){
				appendErrMsg($passwordErr, "密码不能为空")
				return false;
			}else if(isNullOrBlank(confirmValue)){
				appendErrMsg($confirmErr, "确认密码不能为空");
				return false;
			}else if(isNullOrBlank(phoneNumValue)){
				appendErrMsg($phoneNumErr, "联系方式不能为空");
				return false
			}else{
				return true;
			}
		}
		
	});
	

</script>
</head>
<body>
	<div class="loginHead">
		<p align="center" style="font: 4">welcome to order manager system</p>
	</div>
	<div class="registUser">
		<form action="user/regist.do" method="post" accept-charset="utf-8" onsubmit="return checkOnSubmit()">
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
						<input name="phoneNumber" id="phoneNum"/>
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
	<div class="registErrDiv">
		<span>
			<%=request.getAttribute(ResponseConstant.RSP_ATTR_LOGIN_ERROR)==null ? "":request.getAttribute(ResponseConstant.RSP_ATTR_REGIST_ERROR) %>
		</span>
	</div>
</body>
</html>
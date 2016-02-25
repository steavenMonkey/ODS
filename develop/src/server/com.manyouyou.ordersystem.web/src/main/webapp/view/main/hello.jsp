<%@page import="com.manyouyou.ordersystem.commons.ResponseConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${name }
${name2 }

<%
	String msg = (String)request.getAttribute(ResponseConstant.RSP_PAGE_LOGIN);
	out.print(msg);
	
%>
	<span>
		<%=request.getAttribute(ResponseConstant.RSP_ATTR_LOGIN_ERROR) %>
	</span>
</body>
</html>
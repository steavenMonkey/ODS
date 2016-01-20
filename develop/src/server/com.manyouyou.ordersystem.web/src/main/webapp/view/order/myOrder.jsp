<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link href="css/myOrder.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="<%=path %>/js/jquery-1.11.3.js"></script>
	<script type="text/javascript">
		$(function() {
			var $firstpage = $("#firstpage");
			var $order = $("#order");
			var $product = $("#product");
			var $logout = $("#logout");
			var $myorder = $("#myorder");
			var $orderquery = $("#orderquery");
			var $neworder = $("#neworder");
			console.info($firstpage);
			//鼠标划过首页，改变其背景颜色
			$firstpage.hover(function() {
				changeBackgroundColor("firstpage", "#699dff")
			}, function() {
				changeBackgroundColor("firstpage", "#e8ffef")
			});
			//鼠标划过订单管理，改变其背景颜色
			$order.hover(function() {
				changeBackgroundColor("order", "#699dff")
			}, function() {
				changeBackgroundColor("order", "#e8ffef")
			});
			//鼠标划过产品管理，改变其背景颜色
			$product.hover(function() {
				changeBackgroundColor("product", "#699dff")
			}, function() {
				changeBackgroundColor("product", "#e8ffef")
			});
			//鼠标划过注销用户，改变其背景颜色
			$logout.hover(function() {
				changeBackgroundColor("logout", "#699dff")
			}, function() {
				changeBackgroundColor("logout", "#e8ffef")
			});
			//鼠标划过我的订单，改变其背景颜色
			$myorder.hover(function() {
				changeBackgroundColor("myorder", "#699dff")
			}, function() {
				changeBackgroundColor("myorder", "#e8ffef")
			});
			//鼠标划过订单查询，改变其背景颜色
			$orderquery.hover(function() {
				changeBackgroundColor("orderquery", "#699dff")
			}, function() {
				changeBackgroundColor("orderquery", "#e8ffef")
			});
			//鼠标划过新增订单，改变其背景颜色
			$neworder.hover(function() {
				changeBackgroundColor("neworder", "#699dff")
			}, function() {
				changeBackgroundColor("neworder", "#e8ffef")
			});
		});
		
		//公共方法，改变背景颜色
		function changeBackgroundColor(id, color) {
			$("#" + id).css("background-color", color);
		}
	</script>
	
</head>
<body>
<%=path %><br/>
<%=basePath %>
	<!--页面头-->
	<div class="topdiv">
		<table>
			<tr>
				<td colspan="4" id="ftd">welcome ${user.name}</td>
			</tr>
			<tr>
				<td id="firstpage">首页</td>
				<td id="order">订单管理</td>
				<td id="product">产品管理</td>
				<td id="logout">注销用户</td>
			</tr>
		</table>
	</div>
	
	<!--页面左侧导航栏-->
	<div class="leftdiv">
		<table>
			<tr>
				<td id="myorder">我的订单</td> 
			</tr>
			<tr>
				<td id="orderquery">订单查询</td> 
			</tr>
			<tr>
				<td id="neworder">新增订单</td> 
			</tr>
		</table>
	</div>
	<!-- 我的订单页 -->
	<div class="myorderdiv">
		<table cellpadding="0" cellspacing="0">
			<tr>
				<td><input type="checkbox" >全选</td>
				<td>产品</td>
				<td>数量(箱)</td>
				<td>单价(元)</td>
				<td>总价(元)</td>
				<td>客户</td>
				<td>收获地址</td>
				<td>联系方式</td>
				<td>是否发货</td>
				<td>是否付款</td>
				<td>下单日期</td>
				<td>操作</td>
			</tr>
			<tr>
				<td><input type="checkbox" ></td>
				<td>黄橙</td>
				<td>2</td>
				<td>98</td>
				<td>196</td>
				<td>张三</td>
				<td>广州市番禺区落西新城海龙湾B座201</td>
				<td>18521709574</td>
				<td><input type="checkbox" checked="checked" readonly="readonly"></td>
				<td><input type="checkbox" checked="checked" readonly="readonly"></td>
				<td>2015-12-31</td>
				<td>
					<input type="button" value="删除" name="deleteOrder"/>
					<input type="button" value="修改" name="updateOrder"/>
				</td>
			</tr>
		</table>	
	</div>
</body>
</html>
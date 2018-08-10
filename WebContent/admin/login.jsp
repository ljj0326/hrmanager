<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gbk">
		<title>用户登陆</title>
		<link href="css/style.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<form name="loginForm" method="post" action="AdminServlet">
			<table width="300" border="0" align="center" cellpadding="4"
				cellspacing="1" bgcolor="#FF9900">
				<tr>
					<td height="24" colspan="2" align="center" bgcolor="#FFCC66">
						管理员登陆
					</td>
				</tr>
				<tr>
					<td width="77" height="24" align="center" bgcolor="#FFFFFF">
						管理账号
					</td>
					<td width="204" height="24" bgcolor="#FFFFFF">
						<input name="loginId" type="text" class="input1">
					</td>
				</tr>
				<tr>
					<td height="24" align="center" bgcolor="#FFFFFF">
						管理密码
					</td>
					<td height="24" bgcolor="#FFFFFF">
						<input name="loginPwd" type="password"
							class="input1">
					</td>
				</tr>

				<tr>
					<td height="24" colspan="2" align="center" bgcolor="#FFFFFF">
						<input type="submit" name="Submit" value="进入系统" >
						
					</td>
				</tr>
			</table>
		</form>
		<span style="color:red">
		<%
			//获得请求属性数据
			String msg=(String)request.getAttribute("msg");
			if(msg!=null){
		%>
		<%=msg %>
		<% } %>
		</span>
	</body>
</html>
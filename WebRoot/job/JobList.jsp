<%@page import="com.black.HRManager.model.vo.Title"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<head>
		<title>职务数据</title>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=gbk">

	</head>

	<body>

		<!-- 页面内容 -->
		<table border="0" width="950" height="350" bgcolor="#ffffff"
			align="center">
			<tr>
				<td align="center" valign="top">
					<table width="90%" border="0" cellpadding="5" cellspacing="1"
						bgcolor="#CCCCCC">
						<tr>
							<th width="16%" height="24" align="center" bgcolor="#FFCC00">
								职务编号
							</th>
							<th width="21%" height="24" align="center" bgcolor="#FFCC00">
								职务名称
							</th>
							<th width="23%" height="24" align="center" bgcolor="#FFCC00">
								最低工资
							</th>
							<th width="24%" height="24" align="center" bgcolor="#FFCC00">
								最高工资
							</th>
							<th width="16%" height="24" align="center" bgcolor="#FFCC00">
								操作
							</th>
						</tr>

						<!-- 显示职务数据 -->
						<!-- 获得请求的数据 -->
						<% ArrayList<Title> title= (ArrayList<Title>)request.getAttribute("tlist"); %>
							
						<%for(Title tv:title){ %>
						
						
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									<%=tv.getId() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
										<%=tv.getName() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
										<%=tv.getMainsalary() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
										<%=tv.getMaxsalary() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<a href="TitleServlet?opera=selbyid&tid=<%=tv.getId()%>">修改</a>
									<a href="TitleServlet?opera=delete&tid=<%=tv.getId()%>">删除</a>								</td>
							</tr>
							<%} %>
						
					</table>
					<p>
						<a href="job/JobAdd.jsp">增加新职务种类</a></p>
				</td>
			</tr>
		</table>


	</body>
</html>
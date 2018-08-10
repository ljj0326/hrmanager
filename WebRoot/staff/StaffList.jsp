<%@page import="java.util.ArrayList"%>
<%@page import="com.black.HRManager.model.vo.Staff"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<head>
		<title>员工数据</title>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=gbk">

	</head>

	<body>

		<table border="0" width="950" height="350" bgcolor="#ffffff"
			align="center">
			<tr>
				<td align="center" valign="top">
				
					<table width="98%" border="0" cellpadding="5" cellspacing="1"
						bgcolor="#CCCCCC">
						<tr>
							<td width="7%" height="24" bgcolor="#FFCC00">
								员工编号
							</td>
							<td width="11%" height="24" bgcolor="#FFCC00">
								员工姓名
							</td>
							<td width="16%" height="24" bgcolor="#FFCC00">
								邮箱
							</td>
							<td width="16%" height="24" bgcolor="#FFCC00">
								电话
							</td>
							<td width="12%" height="24" bgcolor="#FFCC00">
								入职时间
							</td>
							<td width="9%" height="24" bgcolor="#FFCC00">
								职务
							</td>
							<td width="9%" height="24" bgcolor="#FFCC00">
								工资
							</td>
							<td width="7%" height="24" bgcolor="#FFCC00">
								部门
							</td>
							<td width="13%" height="24" bgcolor="#FFCC00">
								操作
							</td>
						</tr>
						<% ArrayList<Staff> list=(ArrayList<Staff>)request.getAttribute("list"); %>
						     <%for(Staff s:list){ %>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									<%=s.getId() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=s.getName() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=s.getEmail() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=s.getTel() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=s.getStarttime()%>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=s.getTitleid() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=s.getSalary()%>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=s.getDeptid()%>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<a href="StaffServlet?black=selone&ids=<%=s.getId()%>">修改</a>
									<a href="StaffServlet?black=delete&ids=<%=s.getId()%>">删除</a>
								</td>
							</tr>
						
						<%} %>
						
					</table>
					
					<p>
						<a href="staff/StaffAdd.jsp">增加新员工</a>					</p>
				</td>
			</tr>
		</table>

	</body>
</html>
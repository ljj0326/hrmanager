<%@page import="com.black.HRManager.model.vo.Dept"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>增加新部门</title>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=gbk">
	</head>

	<body>

<table border="0" width="950" height="350" bgcolor="#ffffff"
			align="center">
			<tr>
				<td align="center" valign="top">

					<form name="form1" method="post" action="DeptServiet?black=update">
					<%Dept d=(Dept)request.getAttribute("depts"); %>
					<input type="hidden" name="hidden" value="<%=d.getId() %>">
						<table width="500" border="0" cellpadding="5" cellspacing="1"
							bgcolor="#CCCCCC">
							<tr>
								<td height="24" colspan="2" align="center" bgcolor="#FFCC00">
									请填写新部门信息
								</td>
							</tr>
							
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									部门名称
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<input name="department_name" type="text" value="<%=d.getName() %>" id="department_name">
									*
								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									部门地址
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<input name="location_name" type="text" value="<%=d.getAddress() %>" id="location_name">
									*
								</td>
							</tr>
							<tr>
								<td height="24" colspan="2" align="center" bgcolor="#FFFFFF">
									<input type="submit" name="Submit" value="提交" >
									<input type="button" name="Submit2" value="取消" onClick="history.back();">
								</td>
							</tr>
						</table>
					</form>

				</td>
			</tr>
	</table>

	</body>
</html>
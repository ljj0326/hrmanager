<%@page import="com.black.HRManager.model.vo.Title"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>修改职务</title>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=gbk">
	</head>

	<body>

		<!-- 页面内容 -->
		<table border="0" width="950" height="350" bgcolor="#ffffff"
			align="center">
			<tr>
				<td align="center" valign="top">
					<form method="post" action="TitleServlet?opera=update">
					
						<table width="500" border="0" cellpadding="5" cellspacing="1"
							bgcolor="#CCCCCC">
							<%Title t=(Title)request.getAttribute("tdate"); %>
							
							<input type="hidden" name="t_id" value="<%=t.getId()%>" >
							<tr>
								<td height="24" colspan="2" align="center" bgcolor="#FFCC00">
									请修改职务类型信息
								</td>
							</tr>
							
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									职务名称
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<input name="job_title" type="text" id="job_title"
										value= <%=t.getName()%>>
									*
								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									最低工资
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<input name="min_salary" type="text" id="min_salary"
										value=<%=t.getMainsalary()%> >
									*
								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									最高工资
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<input name="max_salary" type="text" id="max_salary"
										value=<%=t.getMaxsalary()%>>
									*
								</td>
							</tr>
							<tr>
								<td height="24" colspan="2" align="center" bgcolor="#FFFFFF">
									<input type="submit" name="Submit" value="更新" ">
									<input type="button" name="Submit2" value="取消"
										onclick="history.back()">
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>


	</body>
</html>
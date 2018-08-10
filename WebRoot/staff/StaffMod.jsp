<%@page import="com.black.HRManager.model.vo.Staff"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<head>
		<title>修改员工</title>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=gbk">
		
		<script type="text/javascript" src="../inc/Calendar1.inc"></script>

		<script type="text/javascript">
	//显示对应职务的最低和最高工资
	function showSal() {
		//获得职务表单元素对象
		var job_id = document.form1.job_id;
		//显示最低工资和最高工资
		if (job_id.value != "") {
			document.form1.min_salary.value = eval("document.form1.min"
					+ job_id.value + ".value");
			document.form1.max_salary.value = eval("document.form1.max"
					+ job_id.value + ".value");
		} else {
			document.form1.min_salary.value = "";
			document.form1.max_salary.value = "";
		}
	}
</script>
	</head>

	<body onLoad="showSal()">

		<table border="0" width="950" height="350" bgcolor="#ffffff"
			align="center">
			<tr>
				<td align="center" valign="top">
					<form name="form1" method="post" action="StaffServlet?black=update">
						<table width="500" border="0" cellpadding="5" cellspacing="1"
							bgcolor="#CCCCCC">
							<% Staff s=(Staff)request.getAttribute("li"); %>
						     <input type="hidden" name="hidden" value="<%=s.getId() %>">
							<tr>
								<td height="24" colspan="2" align="center" bgcolor="#FFCC00">
									请修改员工信息
								</td>
							</tr>
							<tr>
								<td width="120" height="24" bgcolor="#FFFFFF">
									员工姓名
								</td>
								<td width="357" height="24" bgcolor="#FFFFFF">
									<input name="empname" type="text" id="empname" value="<%=s.getName() %>">
									*
								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									邮箱地址
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<input name="email" type="text" id="email" value="<%=s.getEmail() %>">
									*
								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									电话号码
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<input name="phone_number" type="text" id="phone_number" value="<%=s.getTel() %>">
									例如123.456.789
								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									入职日期
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<input name="hire_date" type="text" id="hire_date" value="<%=s.getStarttime()%>"
										onfocus="calendar()">
									yyyy-mm-dd
								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									职务
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<select name="job_id" id="job_id" onChange="<%=s.getTitleid() %>">
										<option value="">
											请选择职务
										</option>

										<!-- 循环输出所有的职务option -->
										
												<option value="3">员工</option>
										
											<option value="2">总经理</option>
										

									</select>

									<!-- 隐藏表单元素：存储每种职务的最低和最高工资 -->
									
										<input type="hidden" name="minWY"
											value="1500" />
										<input type="hidden" name="maxWY"
											value="3000" />
									
										<input type="hidden" name="minFWY"
											value="800" />
										<input type="hidden" name="maxFWY"
											value="2000" />
									
										<input type="hidden" name="minCHSH"
											value="1500" />
										<input type="hidden" name="maxCHSH"
											value="9999" />
									
										<input type="hidden" name="minBAN"
											value="800" />
										<input type="hidden" name="maxBAN"
											value="2400" />
									
										<input type="hidden" name="minJL"
											value="3000" />
										<input type="hidden" name="maxJL"
											value="9999" />
									

									工资范围
									<input name="min_salary" type="text" id="min_salary" size="10"
										readonly>
									~
									<input name="max_salary" type="text" id="max_salary" size="10"
										readonly>
								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									工资
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<input name="salary" type="text" id="salary" value="<%=s.getSalary()%>">
									*
								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									部门
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<select name="department_id" id="department_id">
										<option value="<%=s.getDeptid()%>">
											请选择部门
										</option>

										<!-- 循环输出所有的部门的option -->
										
											<!-- 循环输出所有的部门的option -->
										
											<option value="1">财务步</option>										
										
											<option value="5">吉泽明步</option>										
										
											<option value="4">市步</option>										
										
											<option value="3">绝对技术步</option>										
										
											
										
									</select>
								</td>
							</tr>
							<tr>
								<td height="24" colspan="2" align="center" bgcolor="#FFFFFF">
									<input type="submit" name="Submit" value="更新" >
									<input type="button" name="Submit2" value="取消"
										onclick="history.back()">
									<input name="employee_id" type="hidden" id="employee_id"
										value="100">
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>

	</body>
</html>
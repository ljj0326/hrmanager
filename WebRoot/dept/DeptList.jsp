<%@page import="com.black.HRManager.model.vo.Dept"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<head>
		<title>部门数据</title>
	
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=gbk">
      <script type="text/javascript" language="javascript" >
  
	  
     </script>
	</head>

	<body> 

		<!-- 页面内容 -->
			<table border="0" width="950" height="350" bgcolor="#ffffff" align="center">
			<tr>
				<td align="center" valign="top">
					<table id="ta" width="90%" border="0" cellpadding="5" cellspacing="1"
						bgcolor="#CCCCCC">
						<tr>
							<th width="17%" bgcolor="#FFCC00">
								部门编号
							</th>
							<th width="25%" bgcolor="#FFCC00">
								部门名称
							</th>
							<th width="37%" bgcolor="#FFCC00">
								部门地址
							</th>
							<th width="21%" bgcolor="#FFCC00">
								操作
							</th>
						</tr>

						<!-- 循环输出部门记录 -->
						
			
					
						<% ArrayList<Dept> list =(ArrayList<Dept>)request.getAttribute("select"); %>
						<%for(Dept d:list){ %>
						<tr>
						
						
                                 <td bgcolor="#FFFFFF">
									<%=d.getId() %>
								</td>
								<td bgcolor="#FFFFFF">
									<%=d.getName() %>
								</td>
                                <td bgcolor="#FFFFFF">
									<%=d.getAddress() %>
								</td>
						
						
							<td bgcolor="#FFFFFF">
									<a href="DeptServiet?black=moon&ids=<%=d.getId() %>">修改</a>
									<a href="DeptServiet?black=delete&ids=<%=d.getId() %>">删除</a>	
											</td>
						</tr>
						<%} %>

					</table>
					<p>
						<a href="dept/DeptAdd.jsp">增加新部门</a>
					</p>
				</td>
			</tr>
	</table>

	</body>
</html>


package com.black.HRManager.Servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.black.HRManager.model.dao.StaffDao;
import com.black.HRManager.model.vo.Staff;

/**
 * 用于连接用户界面和用户数据库的中介类Servlet
 * Servlet implementation class StaffServlet
 */
public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		
		//获得请求类型的标签
		String black=request.getParameter("black");
		//实力数据库操作类
		StaffDao sd= new StaffDao();
		
		//删除数据
		if(black!=null&&black.equals("delete"))
		{
			//获得要是删除的id
		 int id= Integer.parseInt( request.getParameter("ids"));
		 //调用方法删除数据
		   sd.delStaff(id);
		 
		}
		//更新数据
		if(black!=null&&black.equals("update"))
		{
			//定义用户对存储数据
			Staff s=new Staff();
			s.setId(Integer.parseInt(request.getParameter("hidden")));
			s.setName(request.getParameter("empname"));
			s.setEmail(request.getParameter("email"));
			s.setTel(request.getParameter("phone_number"));
	     	//	s.setStarttime(Timestamp.valueOf(request.getParameter("hire_date")));
			s.setStarttime(new Timestamp(new  GregorianCalendar().getTimeInMillis()));
			//s.setStarttime(Timestamp.valueOf(""));
			s.setTitleid(Integer.parseInt(request.getParameter("job_id")));
		    s.setSalary(Double.parseDouble(request.getParameter("salary")));
		    s.setDeptid(Integer.parseInt( request.getParameter("department_id")));
		    
		    //更新数据
		    sd.updaStaff(s);
		}
		
		//查询一行
		if(black!=null&&black.equals("selone"))
			
		{
			System.out.println("6789");
			//获得要修改的id
			 int id= Integer.parseInt(request.getParameter("ids"));
			
			//调用方法获得数据库数据
			Staff s=	sd.selOneStaff(id);
			//把获得的数据放到属性里
			request.setAttribute("li", s);
			if(s==null)
			{
			 System.out.println("===============================");
			}
			
			//发送请求，跳转到用户界面
			request.getRequestDispatcher("staff/StaffMod.jsp").forward(request, response);
		}
		
		
		//增加数据
		if(black!=null&&black.equals("insert"))
		{
			// System.out.println(new  GregorianCalendar().getTimeInMillis());
			//定义用户对存储数据
			Staff s=new Staff();
			s.setName(request.getParameter("empname"));
			s.setEmail(request.getParameter("email"));
			s.setTel(request.getParameter("phone_number"));
	     	//	s.setStarttime(Timestamp.valueOf(request.getParameter("hire_date")));
			s.setStarttime(new Timestamp(new  GregorianCalendar().getTimeInMillis()));
			//s.setStarttime(Timestamp.valueOf(""));
			s.setTitleid(Integer.parseInt(request.getParameter("job_id")));
		    s.setSalary(Double.parseDouble(request.getParameter("salary")));
		    s.setDeptid(Integer.parseInt( request.getParameter("department_id")));
		    //调用方法插入数据
		  sd.insStaff(s);
		}
		
		//查询全部数据
		if(!black.equals("selone"))
		{
			//调用方法获得数据库数据
			ArrayList<Staff> list=	sd.selAll();
			//把获得的数据放到属性里
			request.setAttribute("list", list);
			
			//发送请求，跳转到用户界面
			request.getRequestDispatcher("staff/StaffList.jsp").forward(request, response);
		}
		
	}

}

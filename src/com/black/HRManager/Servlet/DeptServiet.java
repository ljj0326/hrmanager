package com.black.HRManager.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.black.HRManager.model.dao.DeptDao;
import com.black.HRManager.model.vo.Dept;

/**
 * Servlet implementation class DeptServiet
 */
public class DeptServiet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   //设置编码格式
		request.setCharacterEncoding("utf-8");
		
		 //实力化对象
		DeptDao dd=new DeptDao();
		//获得请求里的标签
	String black=	request.getParameter("black");
	
	//修改数据
	if(black!=null&&black.equals("update"))
	{       Dept d=new Dept();
		 int id=Integer.parseInt(request.getParameter("hidden"));
		 d.setId(id);
		 d.setName(request.getParameter("department_name"));
			d.setAddress(request.getParameter("location_name"));
			dd.updateDept(d);
	}
	//查询一条数据
	if(black!=null&&black.equals("moon"))
	{
		//获得id
	  int id=Integer.parseInt(request.getParameter("ids"));
	  //定义对象接收数据
	Dept d=  dd.selOneDept(id);
	//添加属性
	request.setAttribute("depts", d);
	//请求
	request.getRequestDispatcher("dept/DeptMod.jsp").forward(request, response);
	}
	//增加数据
	if(black!=null&&black.equals("insert"))
	{
		//定义部门对象存储数据
		Dept d=new Dept();
//		d.setId(Integer.parseInt(request.getParameter("department_id")));
		d.setName(request.getParameter("department_name"));
		d.setAddress(request.getParameter("location_name"));
		//调用方法往数据库中添加数据
		int s=dd.inserDept(d);
		 if(s==1)
   	  {
   		  System.out.println("添加成功");
   	  }
	}
	
	
	    //删除数据
	      if(black!=null&&black.equals("delete"))
	      { 
	    	  //获得id
	    	 int id= Integer.parseInt(request.getParameter("ids"));
	    	int s= dd.deleteOne(id);
	    	  if(s==1)
	    	  {
	    		  System.out.println("添加成功");
	    	  }
	      }
	
	      if(!black.equals("moon"))
	      {
	    
		//获取数据库中的数据
		ArrayList<Dept> list=dd.selectAll();
		if(list!=null)
		{
			//添加属性
			request.setAttribute("select", list);
			//跳转到部门界面
			request.getRequestDispatcher("dept/DeptList.jsp").forward(request, response);
		}
	      }
		
		
	}

}

package com.yy.HRManager.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yy.HRManager.model.dao.AdminDao;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		//获取前台提交过来的数据
		String uname=request.getParameter("loginId");
		String passw=request.getParameter("loginPwd");
		//输出
		System.out.println(uname+"---"+passw);
		//取数据库查询数据
	   boolean flag=new AdminDao().selLogin(uname, passw);
	   //登录成功的判断
	   if(flag){
		   request.getRequestDispatcher("index.jsp").forward(request, response);
	   }else{
		   //设置数据
		   request.setAttribute("msg","账号或者密码有误");
		   //跳转到主页面
		   request.getRequestDispatcher("admin/login.jsp").forward(request, response);
	   }
	}

}

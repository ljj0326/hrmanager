package com.black.HRManager.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.black.HRManager.model.dao.AdminDao;

/**
 * 
 * 管理员相关的servlet
 * Servlet implementation class AdminServiet
 */
public class AdminServiet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		//获得前台提交的数据
		String uname=request.getParameter("loginId");
		String poss=request.getParameter("loginPwd");
		
		//去数据库查询数据并判断
		if(new AdminDao().selLogin(uname, poss))
		{
			//跳转主界面
			request.getRequestDispatcher("Index.jsp").forward(request, response);
		}else
		{
			//添加数据
			request.setAttribute("msg", "账号密码有误");
			  
			//跳转登陆界面
			request.getRequestDispatcher("admin/login.jsp").forward(request, response);
		}
		
	}

}

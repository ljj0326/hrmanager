package com.black.HRManager.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.black.HRManager.model.dao.ImplTitleDao;
import com.black.HRManager.model.vo.Title;

/**
 * 专门用来对职位相关信息的操作
 *      前后台传递数据
 * Servlet implementation class TitleServlet
 */
public class TitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
		request.setCharacterEncoding("utf-8");
		
		//删除数据
		//获得操作的数据
	String opera=	request.getParameter("opera");
	if(opera!=null&& opera.equals("delete"))
	{
		//获取需要删除的数据的id
	    int tid=Integer.parseInt(request.getParameter("tid"));
	  int id=  new ImplTitleDao().delTitles(tid);
	 if(id>0)
	 {
		 System.out.println("删除成功");
	 }
	    
	}	
	
	//添加数据的操作
	if(opera!=null&&opera.equals("insert"))
	{
		//获得数据
		String name=request.getParameter("job_title");
		double maxsalary=Double.parseDouble( request.getParameter("max_salary"));
		double minsalary=Double.parseDouble( request.getParameter("min_salary"));
		//将数据打包成对象
		Title t=new Title();
		t.setName(name);
		t.setMaxsalary(maxsalary);
		t.setMainsalary(minsalary);
		int id=  new ImplTitleDao().insTitle(t);
		if(id>=0)
		{
			System.out.println("添加成功");
		}else
		{
			System.out.println("添加失败");
		}
		
	}
	//修改数据
	if(opera!=null&&opera.equals("update"))
	{
		//获得hidden的值
		int id= Integer.parseInt(request.getParameter("t_id"));
		
		String name=request.getParameter("job_title");
		double maxsalary=Double.parseDouble( request.getParameter("max_salary"));
		double minsalary=Double.parseDouble(request.getParameter("min_salary"));
		Title ts=new Title();
		ts.setId(id);
		ts.setName(name);
		ts.setMainsalary(minsalary);
		ts.setMaxsalary(maxsalary);
		int a=new ImplTitleDao().updateTitle(ts);
		System.out.println(id);
		
	}
	
	   if(!opera.equals("selbyid"))
	   
	  {
	
		//获取数据库中的数据
		ArrayList<Title> title=new ImplTitleDao().selAllTitles();
		//将数据封装到请求属性
		request.setAttribute("tlist", title);
		//请求转发到职位显示页面
		request.getRequestDispatcher("job/JobList.jsp").forward(request, response);
	   }
	  
		//查询一个数据到数据库跳转到修改界面
		if(opera!=null&&opera.equals("selbyid"))
		{
			//获得编号
		int id=Integer.parseInt(request.getParameter("tid"));
		//调用方法获得返回结果
	      Title t= new ImplTitleDao().selOneTitleById(id);
	      //调用方法将数据传到前台
	      request.setAttribute("tdate", t);
	      //请求转发
	      request.getRequestDispatcher("job/JobMod.jsp").forward(request, response);

		}
		
		
		
	
	}

}

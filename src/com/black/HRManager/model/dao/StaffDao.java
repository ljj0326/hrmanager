package com.black.HRManager.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.black.HRManager.model.dao.implDao.infStaffDao;
import com.black.HRManager.model.vo.Staff;
import com.black.HRManager.model.vo.Title;
import com.black.HRManager.util.JDBCUtil;

/**
 * 操控用户数据的类
 * @author Administrator
 *
 */
public class StaffDao implements infStaffDao {
   //定义对象
	Connection con;
     ResultSet rs;
     PreparedStatement ps;
	
	//查看全部数据
	@Override
	public ArrayList<Staff> selAll() {
		//定义集合来存储对象数据
		ArrayList<Staff> list=new ArrayList<Staff>();
	
	 try {
			//获得连接对象
		 con=	JDBCUtil.getConnection();
		 //编辑sql语句
		 String sql="select * from hrm_emp";
		 //获得预编语句对象
		ps= con.prepareStatement(sql);
		//发送语句并执行
		rs=ps.executeQuery();
		//获取数据
		while(rs.next())
		{
			//实力化用户对象用来存储数据
			Staff s=new Staff();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setEmail(rs.getString(3));
			s.setTel(rs.getString(4));
			s.setStarttime(rs.getTimestamp(5));
			s.setTitleid(rs.getInt(6));
			s.setSalary(rs.getDouble(7));
			s.setDeptid(rs.getInt(8));
			list.add(s);
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		//关流
		JDBCUtil.close(con, ps, rs);
	}
     return list;
	}

	//添加数据
	@Override
	public int insStaff(Staff s) {
		int a=0;
	    try {
	    	//获得连接对象
			con=JDBCUtil.getConnection();
			//sql语句
			String sql="insert into hrm_emp values(sep_user.nextval,?,?,?,?,?,?,?) ";
			//连接对象获得预编译语言
			ps=	con.prepareStatement(sql);
			//设置参数
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getTel());
			ps.setTimestamp(4, s.getStarttime());
			ps.setInt(5, s.getTitleid());
			ps.setDouble(6, s.getSalary());
			ps.setInt(7, s.getDeptid());
			 //发送语句执行语句返回结果
			    a= ps.executeUpdate();
			  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关流
			JDBCUtil.close(con, ps, rs);
		}
	   
 return a;
	}

	//删除数据
	@Override
	public int delStaff(int id) {
		int s=0;
	    try {
	    	//获得连接对象
			con=JDBCUtil.getConnection();
			//sql语句
			String sql="delete from hrm_emp where e_id=?";
			//连接对象获得预编译语言
			ps=	con.prepareStatement(sql);
			//设置参数
			ps.setInt(1, id);
			 //发送语句执行语句返回结果
			    s= ps.executeUpdate();
			   return s;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关流
			JDBCUtil.close(con, ps, rs);
		}
	   
 return s;
	}

	//查询一行数据
	@Override
	public Staff selOneStaff(int id) {
		//定义集合来存储对象数据
			
		try {
			// 获得连接对象
			con=	JDBCUtil.getConnection();
			//编写sql语句
			String sql="select * from hrm_emp where e_id=?";
			//获得预编译语句对象
			ps=con.prepareStatement(sql);
			//设置参数
			ps.setInt(1, id);
			//发送数据并执行
		  rs=	ps.executeQuery();
		  //循环获得数据
		  while(rs.next())
		  {
			//实力化用户对象用来存储数据
				Staff s=new Staff();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setTel(rs.getString(4));
				s.setStarttime(rs.getTimestamp(5));
				s.setTitleid(rs.getInt(6));
				s.setSalary(rs.getDouble(7));
				s.setDeptid(rs.getInt(8));
				System.out.println("查询成功");
				return s;
             
		  }
		  
		  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关流
			JDBCUtil.close(con, ps, rs);
		}
		 return null;
	}

	//更改信息
	@Override
	public int updaStaff(Staff s) {
		int sd=0;
	    try {
	    	//获得连接对象
			con=JDBCUtil.getConnection();
			//sql语句
			String sql="update hrm_emp set e_name=?,e_mail=?,e_tel=?,e_starttime=?,e_titleid=?,e_salary=?,e_deptid=? where e_id=?";
			//连接对象获得预编译语言
			ps=	con.prepareStatement(sql);
			//设置参数
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getTel());
			ps.setTimestamp(4, s.getStarttime());
			ps.setInt(5, s.getTitleid());
			ps.setDouble(6, s.getSalary());
			ps.setInt(7, s.getDeptid());
			ps.setInt(8, s.getId());
			 //发送语句执行语句返回结果
			    sd= ps.executeUpdate();
			   return sd;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关流
			JDBCUtil.close(con, ps, rs);
		}
	   
 return sd;
	}

}

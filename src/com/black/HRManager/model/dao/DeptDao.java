package com.black.HRManager.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.black.HRManager.model.dao.implDao.infDeptDao;
import com.black.HRManager.model.vo.Dept;

import com.black.HRManager.util.JDBCUtil;

/**
 * 部门增删改查的方法
 * @author Administrator
 *
 */
public class DeptDao implements infDeptDao{
    //定义变量
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	//查看全部的数据
	@Override
	public ArrayList<Dept> selectAll() {
		//定义一个集合存储所有的信息
				ArrayList<Dept> list=new ArrayList<Dept>();
		 try {
				//获得连接对象
				con=JDBCUtil.getConnection();
				//sql语句
				String sql="select * from hrm_dept";
				//连接对象获得预编译语言
			    ps=	con.prepareStatement(sql);
			    //发送语句执行语句返回结果
			    rs=ps.executeQuery();
			    //循环获取数据
			    while(rs.next())
			    {
			    	//实例化对象存储数据
			    	Dept d=new Dept();
			   d.setId(rs.getInt(1));
			   d.setName(rs.getString(2));
			   d.setAddress(rs.getString(3));
			    //把该对象存储到集合中
			    list.add(d);
			    }
			    return list;
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				//关流
				JDBCUtil.close(con, ps, rs);
			}
			return list;
	}
	//删除数据
	@Override
	public int deleteOne(int id) {
		int s=0;
	    try {
	    	//获得连接对象
			con=JDBCUtil.getConnection();
			//sql语句
			String sql="delete from hrm_dept where d_id=?";
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
	
	//添加数据
	@Override
	public int inserDept(Dept d) {
		int s=0;
	    try {
	    	//获得连接对象
			con=JDBCUtil.getConnection();
			//sql语句
			String sql="insert into hrm_dept values(sep_dept.nextval,?,?) ";
			//连接对象获得预编译语言
			ps=	con.prepareStatement(sql);
			//设置参数
			ps.setString(1, d.getName());
			ps.setString(2, d.getAddress());
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
	//查询一条数据
	@Override
	public Dept selOneDept(int id) {
		try {
			// 获得连接对象
			con=	JDBCUtil.getConnection();
			//编写sql语句
			String sql="select * from hrm_dept where d_id=?";
			//获得预编译语句对象
			ps=con.prepareStatement(sql);
			//设置参数
			ps.setInt(1, id);
			//发送数据并执行
		  rs=	ps.executeQuery();
		  //循环获得数据
		  while(rs.next())
		  {
			  //获得职位对象存储数据
			  Dept d=new Dept();
			d.setId(rs.getInt(1));
			d.setName(rs.getString(2));
			d.setAddress(rs.getString(3));
			  return d;
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
	//更改数据
	@Override
	public int updateDept(Dept d) {
		int s=0;
	    try {
	    	//获得连接对象
			con=JDBCUtil.getConnection();
			//sql语句
			String sql="update hrm_dept set d_name=?,d_addr=? where d_id=?";
			//连接对象获得预编译语言
			ps=	con.prepareStatement(sql);
			//设置参数
			ps.setString(1, d.getName());
			ps.setString(2, d.getAddress());
			ps.setInt(3, d.getId());
			
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

	
	
	
}

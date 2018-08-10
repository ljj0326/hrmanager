package com.black.HRManager.model.dao;

import java.sql.*;
import java.util.ArrayList;

import com.black.HRManager.model.dao.implDao.infTitleDao;
import com.black.HRManager.model.vo.Title;
import com.black.HRManager.util.JDBCUtil;

public class ImplTitleDao implements infTitleDao {
	//定义对象
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    //查询所有数据
	@Override
	public ArrayList<Title> selAllTitles() {
	//定义一个集合存储所有的信息
		ArrayList<Title> list=new ArrayList<Title>();
 try {
		//获得连接对象
		con=JDBCUtil.getConnection();
		//sql语句
		String sql="select * from hrm_title";
		//连接对象获得预编译语言
	    ps=	con.prepareStatement(sql);
	    //发送语句执行语句返回结果
	    rs=ps.executeQuery();
	    //循环获取数据
	    while(rs.next())
	    {
	    	//实例化对象存储数据
	    	Title title=new Title();
	    title.setId(rs.getInt(1));
	    title.setName(rs.getString(2));
	    title.setMaxsalary(rs.getDouble(3));
	    title.setMainsalary(rs.getDouble(4));
	    //把该对象存储到集合中
	    list.add(title);
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
	public int delTitles(int id) {
		int s=0;
			    try {
			    	//获得连接对象
					con=JDBCUtil.getConnection();
					//sql语句
					String sql="delete from hrm_title where t_id=?";
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
	public int insTitle(Title t) {
		int s=0;
	    try {
	    	//获得连接对象
			con=JDBCUtil.getConnection();
			//sql语句
			String sql="insert into hrm_title values(sep_title.nextval,?,?,?) ";
			//连接对象获得预编译语言
			ps=	con.prepareStatement(sql);
			//设置参数
			ps.setString(1, t.getName());
			ps.setDouble(2, t.getMaxsalary());
			ps.setDouble(3, t.getMainsalary());
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

	//查询一条信息通过id
	@Override
	public Title selOneTitleById(int id) {
		
	try {
		// 获得连接对象
		con=	JDBCUtil.getConnection();
		//编写sql语句
		String sql="select * from hrm_title where t_id=?";
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
		  Title t=new Title();
		  t.setId(rs.getInt(1));
		  t.setName(rs.getString(2));
		  t.setMaxsalary(rs.getDouble(3));
		  t.setMainsalary(rs.getDouble(4));
		  return t;
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
	public int updateTitle(Title t) {
		int s=0;
	    try {
	    	//获得连接对象
			con=JDBCUtil.getConnection();
			//sql语句
			String sql="update hrm_title set t_name=?,t_maxsalary=?,t_minsalary=? where t_id=?";
			//连接对象获得预编译语言
			ps=	con.prepareStatement(sql);
			//设置参数
			ps.setString(1, t.getName());
			ps.setDouble(2, t.getMaxsalary());
			ps.setDouble(3, t.getMainsalary());
			ps.setInt(4, t.getId());
			System.out.println(t.getId());
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

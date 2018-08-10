package com.black.HRManager.model.dao;

import java.sql.*;

import com.black.HRManager.util.JDBCUtil;


/**
 * 对应管理员操作的类
 * 1.登陆的操作
 * @author Administrator
 *
 */
public class AdminDao {
	//定义变量
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	 public boolean selLogin(String uname,String poss)
	 {
		 //导入驱动包
		 
		try {

			//获得连接对象
		 conn=JDBCUtil.getConnection();
		  //编辑sql语句
		 String sql="select * from hrm_admin where a_name=? and a_passw=?";
		 //获得预编辑语句对象
		 ps= conn.prepareStatement(sql);
		 //设置参数
		 ps.setString(1, uname);
		 ps.setString(2, poss);
		
		 //发送语句执行语句返回结果
		rs= ps.executeQuery();
		 return rs.next();
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn, ps, rs);
		}
		
		 return false;
	 }
	
}

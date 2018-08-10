package com.yy.HRManager.model.dao;

import java.sql.*;

import com.yy.HRManager.util.JDBCUtil;
/**
 * 管理员数据操作类
 * 	1.登陆操作
 * @author Administrator
 *
 */
public class AdminDao {
	//定义变量
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		boolean flag=false;
		//登陆操作
		public boolean selLogin(String uname,String passw){
			//导入驱动
			try {
				//获得连接对象
				con=JDBCUtil.getConnection();
				
				//定义sql语句
				String sql="select * from hrm_admin where a_name=? and a_passw=?";
				//获得预编译语句对象
				pst=con.prepareStatement(sql);
				//设置参数
				pst.setString(1, uname);
				pst.setString(2, passw);
				//发送语句执行语句返回结果
				rs=pst.executeQuery();
				//获得结果
				flag=rs.next();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				//关闭流
				JDBCUtil.close(con, pst, rs);
			}
			
			return flag;
			
		}
}

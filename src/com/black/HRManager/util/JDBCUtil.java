package com.black.HRManager.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 建立数据库工厂
 * 加载数据库
 * 获得连接
 * 关闭连接
 * @author Administrator
 *
 */
public class JDBCUtil {
private static	Connection conn=null;
private static String url="jdbc:oracle:thin:@//localhost:1521/xe";
private static String name="scott";
private static String poss="black";
private static String classname="oracle.jdbc.driver.OracleDriver";
	
//定义静态块加载驱动
	static{
		//异常处理
		try {
			//加载驱动
			Class.forName(classname);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//获得连接对象
	public static Connection getConnection(){
		 try {
			conn=	DriverManager.getConnection(url,name ,poss);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  return conn;
	}
	//关流
	
	public static void close(Connection con,PreparedStatement ps,ResultSet rs)
	{
	try {
		if(con!=null)
		{
		con.close();
		}
		if(ps!=null)
		{
			ps.close();
		}
		if(rs!=null)
		{
			rs.close();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}

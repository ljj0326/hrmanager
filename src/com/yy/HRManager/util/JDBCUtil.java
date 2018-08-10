package com.yy.HRManager.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 建立数据库工厂
 * 	加载驱动
 * 	获得连接
 * 关闭连接
 * @author Administrator
 *
 */
public class JDBCUtil {
	private static Connection con=null;
	private static String  url="jdbc:oracle:thin:@//localhost:1521/xe";
	private static String  uname="myhrm";
	private static String passw="aaaa";
	private static String  classname ="oracle.jdbc.driver.OracleDriver";
	
	//设置静态块加载驱动
	static{
		try {
			Class.forName(classname);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获得连接对象
	public static Connection getConnection(){
		try {
			//获得连接对象
			con=DriverManager.getConnection(url,uname,passw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回对象
		return con;
	}
	
	//关闭流
	public static void close(Connection con,PreparedStatement pst,ResultSet rs){
		try {
			if(con!=null){
				con.close();
			}
			if(pst!=null){
				pst.close();
			}
			if(rs!=null){
				rs.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

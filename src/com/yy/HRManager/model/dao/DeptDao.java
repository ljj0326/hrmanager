package com.yy.HRManager.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.yy.HRManager.model.vo.DeptVo;
import com.yy.HRManager.util.JDBCUtil;

/**
 * 部门数据操作类
 * 	添加部门的操作
 * @author Administrator
 *
 */
public class DeptDao {
	//定义变量
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	//添加部门的方法
	public void addDept(DeptVo deptv){
		String d_name=deptv.getD_name();//部门名称
		String d_addr=deptv.getD_addr();//部门地址
		//导入驱动
		//获得连接对象
		con=JDBCUtil.getConnection();
		//定义sql语句
		String sql="insert into hrm_dept values(seq_dept.nextval,?,?,?)";
		
	}

}

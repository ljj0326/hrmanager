package com.black.HRManager.model.dao.implDao;

import java.util.ArrayList;

import com.black.HRManager.model.vo.Staff;

/**
 * 用户数据库的抽象类
 * @author Administrator
 *
 */
public interface infStaffDao {
   //查询全部数据
   public ArrayList<Staff> selAll();
   //添加数据
   public int insStaff(Staff s);
   //删除数据
   public int delStaff(int id);
   //查询一行数据
   public Staff selOneStaff(int id);
   //更改信息
   public int updaStaff(Staff s);
   
}

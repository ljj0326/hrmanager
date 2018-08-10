package com.black.HRManager.model.dao.implDao;

import java.util.ArrayList;

import com.black.HRManager.model.vo.Dept;

/**
 *部门的数据操作
 * @author Administrator
 *
 */
public interface infDeptDao {
   //查询全部数据
	public ArrayList<Dept> selectAll(); 
	//删除数据
	public int deleteOne(int id);
	//添加数据
	public int inserDept(Dept d);
	//查询一条数据
	public Dept selOneDept(int id);
	//更改数据
	public int updateDept(Dept d);
}

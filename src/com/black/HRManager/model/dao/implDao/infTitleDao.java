package com.black.HRManager.model.dao.implDao;

import java.util.ArrayList;

import com.black.HRManager.model.vo.Title;

/**
 * 用于定义职位相关数据库的操作方法
 * @author Administrator
 *
 */
public interface infTitleDao {

	//查询所有的数据
	public ArrayList<Title> selAllTitles();
	//删除数据
	public int delTitles(int id);
	//添加数据
	public int insTitle(Title t );
	//查询一条信息通过id
	public Title selOneTitleById(int id);
	//更改信息
	public int updateTitle(Title t);
}

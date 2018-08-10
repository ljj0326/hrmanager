package com.yy.HRManager.model.vo;
/**
 * 部门类
 * @author Administrator
 *
 */
public class DeptVo {
	//定义变量
	private int d_id;//部门编号
	private String d_name;//部门名称
	private String d_addr;//部门地址
	
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getD_addr() {
		return d_addr;
	}
	public void setD_addr(String d_addr) {
		this.d_addr = d_addr;
	}

}

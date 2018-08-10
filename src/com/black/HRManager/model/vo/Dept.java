package com.black.HRManager.model.vo;
/**
 * 部门的数据存储类
 * @author Administrator
 *
 */
public class Dept {
  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
private int id;//编号
  private String name;//部门名称
  private String address;//部门地址
}

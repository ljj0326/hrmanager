package com.black.HRManager.model.vo;
/**
 * 此类用于描述职位属性的所有信息
 * @author Administrator
 *
 */
public class Title {
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
	public double getMainsalary() {
		return mainsalary;
	}
	public void setMainsalary(double mainsalary) {
		this.mainsalary = mainsalary;
	}
	public double getMaxsalary() {
		return maxsalary;
	}
	public void setMaxsalary(double maxsalary) {
		this.maxsalary = maxsalary;
	}
private int id;//职位id
  private String name;//职位名称
  private double mainsalary;//最低工资
  private double maxsalary;//最高工资
}

package com.wipro.model;

public class Student 
{
	private Integer stid;
	private String stname;
	public Integer getStid() {
		return stid;
	}
	public void setStid(Integer stid) {
		this.stid = stid;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public Student(Integer stid, String stname) {
		super();
		this.stid = stid;
		this.stname = stname;
	}
	public Student()
	{
		
	}
	@Override
	public String toString() {
		return "stid=" + stid + ", stname=" + stname;
	}
	

}

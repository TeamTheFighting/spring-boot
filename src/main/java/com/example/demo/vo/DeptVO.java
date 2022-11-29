package com.example.demo.vo;

public class DeptVO extends BaseVO{
	
	private String dname; //부서 이름
	private String loc; //부서 위치
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}

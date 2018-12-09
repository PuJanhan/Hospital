package cn.njupt.hospital.user.entity;

import java.sql.Timestamp;
import java.util.Date;

public class TimeList {
	private Integer pid;
	private String dname;
	private Timestamp assigntime;
	public TimeList(Integer pid, String dname, Timestamp assigntime) {
		super();
		this.pid = pid;
		this.dname = dname;
		this.assigntime = assigntime;
	}
	public TimeList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Timestamp getAssigntime() {
		return assigntime;
	}
	public void setAssigntime(Timestamp assigntime) {
		this.assigntime = assigntime;
	}
	@Override
	public String toString() {
		return "TimeList [pid=" + pid + ", dname=" + dname + ", assigntime=" + assigntime + "]";
	}
	
	

}

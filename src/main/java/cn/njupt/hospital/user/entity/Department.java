package cn.njupt.hospital.user.entity;

import java.io.Serializable;

public class Department implements Serializable {
	private String cid;
	private String cname;
	public Department(String cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Department [cid=" + cid + ", cname=" + cname + "]";
	}
	

}

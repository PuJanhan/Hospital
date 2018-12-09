package cn.njupt.hospital.user.entity;

import java.sql.Timestamp;

public class Appointment {
	private Integer aid;
	private Timestamp  atime;
	private String usersname;
	private String docname;
	private String state;
	public Appointment(Integer aid, Timestamp atime, String usersname, String docname, String state) {
		super();
		this.aid = aid;
		this.atime = atime;
		this.usersname = usersname;
		this.docname = docname;
		this.state = state;
	}
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Timestamp getAtime() {
		return atime;
	}
	public void setAtime(Timestamp atime) {
		this.atime = atime;
	}
	public String getUsersname() {
		return usersname;
	}
	public void setUsersname(String usersname) {
		this.usersname = usersname;
	}
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Appointment [aid=" + aid + ", atime=" + atime + ", usersname=" + usersname + ", docname=" + docname
				+ ", state=" + state + "]";
	}
	
	
	

}

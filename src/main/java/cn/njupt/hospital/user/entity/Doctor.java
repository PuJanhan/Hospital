package cn.njupt.hospital.user.entity;

public class Doctor {
     private String bid;
     private String bpassword;
     private Department department;
     private String bname;
     private String image;
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBpassword() {
		return bpassword;
	}
	public void setBpassword(String bpassword) {
		this.bpassword = bpassword;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Doctor(String bid, String bpassword, Department department, String bname, String image) {
		super();
		this.bid = bid;
		this.bpassword = bpassword;
		this.department = department;
		this.bname = bname;
		this.image = image;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Doctor [bid=" + bid + ", bpassword=" + bpassword + ", department=" + department + ", bname=" + bname
				+ ", image=" + image + "]";
	}
	
     
     
}

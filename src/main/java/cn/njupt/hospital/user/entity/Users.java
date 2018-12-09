package cn.njupt.hospital.user.entity;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;
/**
 * 文件说明：用户表
 * @author Administrator
 *
 */
public class Users implements Serializable{
    /**
	 * 
	 */
	
	private String id;
    private String sname;
    private Integer age;
    private String gender;
    private String idnumber;
    private String telnumber;
    private String spassword;
    private String  imagePath;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getTelnumber() {
		return telnumber;
	}
	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Users(String id, String sname, Integer age, String gender, String idnumber, String telnumber,
			String spassword, String imagePath) {
		super();
		this.id = id;
		this.sname = sname;
		this.age = age;
		this.gender = gender;
		this.idnumber = idnumber;
		this.telnumber = telnumber;
		this.spassword = spassword;
		this.imagePath = imagePath;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", sname=" + sname + ", age=" + age + ", gender=" + gender + ", idnumber=" + idnumber
				+ ", telnumber=" + telnumber + ", spassword=" + spassword + ", imagePath=" + imagePath + "]";
	}
	
    
	
    
    
	
	
    
    
    
}
    
   
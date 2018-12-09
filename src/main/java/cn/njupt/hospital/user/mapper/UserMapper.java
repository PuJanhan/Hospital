package cn.njupt.hospital.user.mapper;

import java.util.List;

import cn.njupt.hospital.user.entity.Appointment;
import cn.njupt.hospital.user.entity.Department;
import cn.njupt.hospital.user.entity.Doctor;
import cn.njupt.hospital.user.entity.TimeList;
import cn.njupt.hospital.user.entity.Users;

public interface UserMapper {
   //遵循四个原则
   //只需要写接口   接口中方法名==User.xml中id名
	public Users findUserByage(Integer a);
	
	//public Users findUserbyQueryvo(Queryvo  qo);
	
    //用户名查找
	public Users findUserBysname(String sname);
	
    //身份证号查找
	public Users findUserByidnumber(String idnumber);
    
	
	//手机号查找
	public Users findUserBytelnumber(String telnumber);
    
	public void adduser(Users user);

	public List<Department> findAll_Department();

	public List<Doctor> findAll_doctor();
	
	public List<Doctor> finddoctorbycid(String cid);

	public Doctor docInfor(String bid);

	public List<TimeList> findTime(String bname);

	public void insertappoint(Appointment appoint);

	public List<Appointment> findappoint(String usersname);

	//public Users findUserbyQueryvo(Queryvo vo);

	//public Users findUserByage(Integer i);
}

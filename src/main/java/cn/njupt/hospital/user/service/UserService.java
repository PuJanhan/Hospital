package cn.njupt.hospital.user.service;

import java.util.List;

import cn.njupt.hospital.exception.MessageException;
import cn.njupt.hospital.user.entity.Appointment;
import cn.njupt.hospital.user.entity.Department;
import cn.njupt.hospital.user.entity.Doctor;
import cn.njupt.hospital.user.entity.TimeList;
import cn.njupt.hospital.user.entity.Users;

public interface UserService {

	public void regist(Users user) throws MessageException;
	
	public Users login(String username,String password)throws MessageException;

	public List<Department> findAll_Department();

	public List<Doctor> findAll_doctor();
	
	public List<Doctor> finddoctorbycid(String cid);

	public Doctor docInfor(String bid);

	public List<TimeList> findTime(String bid);

	public void insertappoint(Appointment appoint);

	public List<Appointment> findappoint(String usersname);

}

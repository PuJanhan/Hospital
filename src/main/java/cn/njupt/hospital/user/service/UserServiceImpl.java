package cn.njupt.hospital.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.njupt.hospital.exception.MessageException;
import cn.njupt.hospital.user.entity.Appointment;
import cn.njupt.hospital.user.entity.Department;
import cn.njupt.hospital.user.entity.Doctor;
import cn.njupt.hospital.user.entity.TimeList;
import cn.njupt.hospital.user.entity.Users;
import cn.njupt.hospital.user.mapper.UserMapper;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserMapper usermapper;
	

	/**
	 * 注册功能
	 * @param user
	 */
	public void regist(Users user) throws MessageException {
	     Users find_user = usermapper.findUserBysname(user.getSname());
	     if(find_user!=null){
	    	 throw new MessageException("用户名已注册");
	     }
	     
	     find_user = usermapper.findUserByidnumber(user.getIdnumber());
	     if(find_user!=null){
	    	 throw new MessageException("身份证号已被注册");
	     }
	     
	     find_user = usermapper.findUserBytelnumber(user.getTelnumber());
	     if(find_user!=null){
	    	 throw new MessageException("手机号已被注册");
	     }
	     
	     usermapper.adduser(user);
		
	}
	/**
	 * 登录功能
	 */
	public Users login(String username,String password) throws MessageException{
		Users user = usermapper.findUserBysname(username);
		
		if(user==null)
		 throw new MessageException("用户名不存在");
		else if(!user.getSpassword().equals(password)){
			throw new MessageException("密码不正确");
		}
		
	      return user;
	}
	@Override
	public List<Department> findAll_Department() {
		return usermapper.findAll_Department();
	}
	@Override
	public List<Doctor> findAll_doctor() {
		return usermapper.findAll_doctor();
	}
	@Override
	public List<Doctor> finddoctorbycid(String cid) {
		return usermapper.finddoctorbycid(cid);
	}
	@Override
	public Doctor docInfor(String bid) {
		// TODO Auto-generated method stub
		return usermapper.docInfor(bid);
	}
	@Override
	public List<TimeList> findTime(String bid) {
		// TODO Auto-generated method stub
		return usermapper.findTime(bid);
	}
	@Override
	public void insertappoint(Appointment appoint) {
		// TODO Auto-generated method stub
		usermapper.insertappoint(appoint);
	}
	@Override
	public List<Appointment> findappoint(String usersname) {
		return usermapper.findappoint(usersname);
	}
	
}

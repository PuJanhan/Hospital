package cn.njupt.hospital.junit;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import cn.njupt.hospital.user.entity.Appointment;
import cn.njupt.hospital.user.entity.Department;
import cn.njupt.hospital.user.entity.Doctor;
import cn.njupt.hospital.user.entity.TimeList;
import cn.njupt.hospital.user.entity.Users;
import cn.njupt.hospital.user.mapper.UserMapper;

public class Testdemo {

	
	@Test
	public void mybatisTest() throws IOException{
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		 UserMapper userMapper = context.getBean(UserMapper.class);

			//User user = userMapper.queryUserById(1);
			 Users i = userMapper.findUserByage(10);
			 System.out.println(i);

	}

	@Test
	public void mybatisTestsname() throws IOException{
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		 UserMapper userMapper = context.getBean(UserMapper.class);

			//User user = userMapper.queryUserById(1);
			 Users i = userMapper.findUserBysname("pujia");
			 System.out.println(i);

	}
	@Test
	public void mybatisTestidnumber() throws IOException{
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		 UserMapper userMapper = context.getBean(UserMapper.class);

			//User user = userMapper.queryUserById(1);
			 Users i = userMapper.findUserByidnumber("321322199710090901");
			 System.out.println(i);

	}
	@Test
	public void adduser() throws IOException{
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		 UserMapper userMapper = context.getBean(UserMapper.class);

			//User user = userMapper.queryUserById(1);
		 Users user = new Users();
		 user.setAge(111);
		 user.setGender("男");
		 user.setId("321322199910090758");
		 user.setTelnumber("18851511010");
		 user.setSname("pudds");
		 user.setSpassword("111000111");
		   userMapper.adduser(user);
			 //System.out.println(i);

	}
	@Test
	public void finddepartment() throws IOException{
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		 UserMapper userMapper = context.getBean(UserMapper.class);

			//User user = userMapper.queryUserById(1);
		 List<Department> list = userMapper.findAll_Department();
		 for(Department d:list){
			 System.out.println(d);
		 }

	}
	@Test
	public void finddoctor() throws IOException{
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		 UserMapper userMapper = context.getBean(UserMapper.class);

			//User user = userMapper.queryUserById(1);
		 List<Doctor> list = userMapper.findAll_doctor();
		 for(Doctor d:list){
			 System.out.println(d);
		 }

	}
	@Test
	public void finddoctorbycid() throws IOException{
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		 UserMapper userMapper = context.getBean(UserMapper.class);

			//User user = userMapper.queryUserById(1);
		 List<Doctor> list = userMapper.finddoctorbycid("1");
		 for(Doctor d:list){
			 System.out.println(d);
		 }

	}
	@Test
	public void findTime() throws IOException{
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		 UserMapper userMapper = context.getBean(UserMapper.class);

			//User user = userMapper.queryUserById(1);
		 List<TimeList> list = userMapper.findTime("张三");
		 for(TimeList d:list){
			 System.out.println(d);
		 }

	}
	@Test
	
	public void findappoint() throws IOException{
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		 UserMapper userMapper = context.getBean(UserMapper.class);

			//User user = userMapper.queryUserById(1);
		List<Appointment> list = userMapper.findappoint("模电");
		for(Appointment a : list){
			System.out.println(a);
		}
		
		
		

	}
}

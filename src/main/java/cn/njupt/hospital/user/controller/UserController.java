package cn.njupt.hospital.user.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import cn.njupt.hospital.exception.MessageException;
import cn.njupt.hospital.user.entity.Appointment;
import cn.njupt.hospital.user.entity.Users;
import cn.njupt.hospital.user.service.UserService;

@Controller

public class UserController { 
	
	
	    @Autowired
	    private UserService userService;
	    
	    
		@RequestMapping(value = "/item.action")
		public String item(){
			return "item";
		}
		@RequestMapping(value = "/body.action")
		public String body(){
			return "body";
		}
		
		//主页面
		@RequestMapping(value = "/main.action")
		public String main(){
			return "a";
		}
		
		//退出功能
		@RequestMapping(value = "/quit.action")
		public String quit(HttpSession session){
			session.invalidate();
			return "main";
			
		}
		
		//登陆界面
		
		@RequestMapping(value="/login.action",method = RequestMethod.GET)
		
		public String login(){
			//return "forward:/login";
			return "login";
		}
		
		@RequestMapping(value = "/login.action",method = RequestMethod.POST)
		public String login(String username,String password,HttpServletRequest request,HttpSession session){
		
			try {
				Users user = userService.login(username,password);
				session.setAttribute("session_user", user);
				
				
			} catch (MessageException e) {
			    request.setAttribute("msg", e.getMessage());
			    //request.setAttribute("msg", "chuosdf");
			    request.setAttribute("username",username);
			    request.setAttribute("password", password);
			    return "login";
			    //return "forward:/login.action";
			}
			
			return "a";
		}
		
		
		@RequestMapping(value = "/regist.action",method = RequestMethod.GET)
		public String regist(String username,String password,HttpSession session){
		
			
			return "regist";
		}
		
		//注册界面
		@RequestMapping(value = "/regist.action",method = RequestMethod.POST)
		public String regist(Users form,HttpServletRequest request,HttpServletResponse response,MultipartFile file) throws Exception, IOException{
			
			Map<String,String> erros = new HashMap<String,String>();
		    String sname = form.getSname();
		    String spassword = form.getSpassword();
		    Integer age = form.getAge();
		    String gender  = form.getGender();
		    String idnumber = form.getIdnumber();
		    String telnumber = form.getTelnumber();
		    
		  
		    
		    //处理图片
		    //保存数据库路径
		    String sqlPath = null;
		   
		    
		    
		    
		    //通过String localPath = res.getServletContext().getRealPath("/"); 拿到项目跟路径
		    
		    // 获取文件名
			//String oriName = file.getOriginalFilename();
			// 获取图片后缀
			//String extName = oriName.substring(oriName.lastIndexOf("."));
		  
		      //定义文件保存的本地路径
		     String localPath =  "D:\\imags\\";
		    
		    //定义文件名
		    String filename = null;
		    
		    
		    
		    if(sname==null||sname.trim().isEmpty()){
		    	erros.put("sname", "用户名不能为空");
		    }else if(sname.length()<3||sname.length()>10){
		    	erros.put("sname", "用户名必须在3-10之间");
		    }
		    
		    if(spassword==null||spassword.trim().isEmpty()){
		    	erros.put("spassword", "密码不能为空");
		    }else if(spassword.length()<6||spassword.length()>20){
		    	erros.put("spassword", "密码应在6-20之间");
		    }
		    
		    
		    if(age==null){
		    	erros.put("age", "年龄不能为空");
		    }
		    
		    if(gender==null){
		    	erros.put("gender", "性别不能为空");
		    }
		    
		    if(idnumber.length()!=18){
		    	erros.put("idnumber", "身份证号错误");
		    }
		    
		    
		   if(telnumber.length()!=11){
			   erros.put("telnumber", "手机号错误");
		   }
		   
		   if(file.isEmpty()){
			   erros.put("picture","图片不能为空");
		   }else{
			   //生成的uuid 作为文件名称
			   String uuid = UUID.randomUUID().toString().replaceAll("-","");
			   //获得文件类型（如果不是图片，禁止上传）
			   String contentType = file.getContentType();//image/pjpeg
			 
			   
			   //获取后缀名
			   String suffixName = contentType.substring(contentType.indexOf("/")+1);
			   
			   filename = uuid+"."+suffixName;
			   
			   sqlPath  = filename;
			   
			   form.setImagePath(sqlPath);

			   //文件保存路径
			   System.out.println(filename);
			   file.transferTo(new File(localPath+filename));
		   }
		   
		   if(erros.size()>0){
			   request.setAttribute("errors", erros);
			   request.setAttribute("form", form);
			   return "regist";
		   }
		   
		   
		   try {
			 
			 
			 
			 System.out.println(sqlPath);
			 
			userService.regist(form);
		} catch (MessageException e) {
		    request.setAttribute("msg", e.getMessage());
		    request.setAttribute("form", form);
		    return "regist";
		}
		   
		    request.setAttribute("msg", "恭喜您注册成功");
		    return "msg";
			
		   
		}
		
		@RequestMapping(value = "/findAll_Department.action")
		public String findAll_Department(HttpServletRequest request){
			
			request.setAttribute("DepartmentList", userService.findAll_Department());		
			return "left";
		}
		
		@RequestMapping(value = "/findAll_doctor.action")
		public String findAll_doctor(HttpServletRequest request,Model model){
			
			//List<Doctor> doctor = new List<Doctor>();
			//Doctor d = new Doctor();
			//List<Doctor> doc = userService.findAll_doctor();
	      // request.setAttribute("DoctorList", userService.findAll_doctor());
	       model.addAttribute("DoctorList", userService.findAll_doctor());
			
			return "list";
		}
		@RequestMapping(value="/finddoctorbycid.action")
		public String finddoctorbycid(HttpServletRequest request){
			String cid = request.getParameter("cid");
			
			request.setAttribute("DoctorList", userService.finddoctorbycid(cid));
			return "list";
		}
		@RequestMapping(value="/doctorInformation.action")
		public String doctorInformation(HttpServletRequest request){
			String bid = request.getParameter("bid");
			
			request.setAttribute("Doctor", userService.docInfor(bid));
			return "desc";
		}
		@RequestMapping(value="/timeList.action")
		public String timelist(HttpServletRequest request){
			String dname = request.getParameter("bname");
			
			request.setAttribute("timeList", userService.findTime(dname));
			return "time";
		}
		@RequestMapping(value="/mkappiontment.action")
		public String appointment(Appointment appoint){
			appoint.setState("1");
			userService.insertappoint(appoint);
			
			//request.setAttribute("timeList", userService.findTime(dname));
			return "success";
		}
		@RequestMapping(value="/findappoint.action")
		public String findappoint(String usersname,Model model){
			
			
			model.addAttribute("Allappoint", userService.findappoint(usersname));
			//request.setAttribute("timeList", userService.findTime(dname));
			return "appointList";
		}
		
		@RequestMapping(value="/chat.action")
		public String beginchat(String usersname,Model model,HttpServletRequest request){
			
			return "userRegist";
		}

		@RequestMapping(value="/registdemo.action")
		public void registdemo(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception{
			Map<String,String> erros = new HashMap<String,String>();
			//System.out.println("sdfsdfdf");
			erros.put("usernameerro", "用户名错误");
			erros.put("passworderro", "密码错误");
			Gson gson = new Gson();
			String json = gson.toJson(erros);
			
			response.setContentType("text/html" + ";charset=utf-8");
			response.getWriter().write(json);
			response.getWriter().flush();
			
			
			
			
			
		}
		
		
}

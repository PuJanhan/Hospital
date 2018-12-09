package cn.njupt.hospital.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.njupt.hospital.user.service.UserService;

@Controller
public class DoctorController {
	
	
	 @Autowired
	    private UserService userService;
	 
	 

}

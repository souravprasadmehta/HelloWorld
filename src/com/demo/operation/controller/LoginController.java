package com.demo.operation.controller;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.demo.operation.bean.*;
import com.demo.operation.model.*;
import com.demo.operation.dao.*;
import com.demo.operation.service.*;
@Controller
public class LoginController {
	@Autowired
	 LoginService loginService;
	
	 @RequestMapping(value = "/Login", method = RequestMethod.GET)
	 public ModelAndView welcome(@ModelAttribute("loginBean")  LoginBean loginBean) {
	 
	  return new ModelAndView("Login");
	 }
	 
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	 public ModelAndView save( @ModelAttribute("loginBean1") LoginBean loginBean) {
	  Login login = prepareModel(loginBean);
	  loginService.addUser(login);  
	  return new ModelAndView("success");
	 }
	 
	 
	 @RequestMapping(value="/readXml",method=RequestMethod.POST)
	 public ModelAndView upload(@RequestParam CommonsMultipartFile file,HttpSession session){
	 		String path=session.getServletContext().getRealPath("/");
	 		String filename=file.getOriginalFilename();
	 		
	 		System.out.println(path+" "+filename);
	 		try{
	 		byte barr[]=file.getBytes();
	 		
	 		BufferedOutputStream bout=new BufferedOutputStream(
	                  new FileOutputStream(path+"/"+filename));
	 		Object o= bout;
	 		bout.write(barr);
	 		bout.flush();
	 		bout.close();
	 		
	 		}catch(Exception e){System.out.println(e);}
	 		
	 		return new ModelAndView("success");
	 	}

	 
	
	 
	 @RequestMapping(value = "/", method = RequestMethod.GET)
	 public ModelAndView test(@ModelAttribute("loginBean")  LoginBean loginBean) {
	 
		 return new ModelAndView("redirect:/login");
	 }
	 
	 
	 
	 private Login prepareModel(LoginBean loginBean){
	  Login login = new Login();
	  login.setPassword(loginBean.getPassword());
	  login.setUserName(loginBean.getUserName());
	  login.setId(loginBean.getId());
	  loginBean.setId(null);
	  return login;
	 }
	

}

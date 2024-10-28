package com.kewen.teacher.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.kewen.teacher.base.BaseController;
import com.kewen.teacher.po.Manage;
import com.kewen.teacher.po.Teacher;
import com.kewen.teacher.po.Teacherclass;
import com.kewen.teacher.service.ManageService;
import com.kewen.teacher.service.TeacherService;

@Controller
@RequestMapping("/login")
public class LoginController  extends BaseController{
	
	@Autowired
	private ManageService manageService;
	
	@Autowired
	private TeacherService teacherService;
	
	/**
	 * 跳转登陆
	 * @return
	 */
	@RequestMapping("/login")
	public String login(){
		return "login/mLogin";
	}
	
	
	@RequestMapping("/mtuichu")
	public String mtuichu(HttpServletRequest request){
		//request.getSession().invalidate();
		return "login/mLogin";
	}
	@RequestMapping("/welcome")
	private String welcome(){
		return "login/welcome";
	}
	
	@RequestMapping("/toLogin")
	public String toLogin(Manage manage, Integer type,HttpServletRequest request, HttpServletResponse response){
		
		if (type == null){
			return "redirect:/login/mtuichu";	
		}
		
		if (type == 1){
			Manage byEntity = manageService.getByEntity(manage);
			if(byEntity == null){
				return "redirect:/login/mtuichu";	
			}else{
				request.getSession().setAttribute("role", 1);
				request.getSession().setAttribute("username", byEntity.getUserName());
				request.getSession().setAttribute("userId", byEntity.getId());
			}
		}
		if (type == 2){
			Teacher t = new Teacher();
			t.setPassword(manage.getPassWord());
			t.setUsername(manage.getUserName());
			t.setIsDelete(0);
			Teacher byEntity = teacherService.getByEntity(t);
			if(byEntity == null){
				return "redirect:/login/mtuichu";	
			}else{
				request.getSession().setAttribute("role", 2);
				request.getSession().setAttribute("username", byEntity.getUsername());
				request.getSession().setAttribute("userId", byEntity.getId());
			}
		}
		
		
		return "login/mIndex";
	}
	
	/**
	 * 退出
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/tuichu")
	public String tuichu( HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		session.invalidate();
		return "login/login";
	}

	@RequestMapping("/head")
	private String head(){
		return "inc/head";
	}
	
	@RequestMapping("/left")
	private String left(){
		return "inc/left";
	}
	
	
	@RequestMapping(value = "/update")
	public String update(Integer id,Model model,HttpServletRequest request) {
		
		Object attribute = request.getSession().getAttribute("userId");
		
		if (attribute == null){
			return "redirect:/login/mtuichu";	
		}
		
		Integer userId = Integer.valueOf(attribute.toString());
		Teacher byId = teacherService.getById(userId);
		model.addAttribute("obj",byId);
		return "login/update";
	}
	

	@RequestMapping(value = "/toUpdate")
	public String toUpdate(Integer id,String phone,Model model,HttpServletRequest request) {
		
		Object attribute = request.getSession().getAttribute("userId");
		
		if (attribute == null){
			return "redirect:/login/mtuichu";	
		}
		
		Integer userId = Integer.valueOf(attribute.toString());
		Teacher byId = teacherService.getById(userId);
		byId.setPhone(phone);
		teacherService.updateById(byId);
		model.addAttribute("obj",byId);
		return "login/update";
	}
	
	@RequestMapping(value = "/pass")
	public String pass(Integer id,Model model,HttpServletRequest request) {
		
		Object attribute = request.getSession().getAttribute("userId");
		
		if (attribute == null){
			return "redirect:/login/mtuichu";	
		}
		
		Integer userId = Integer.valueOf(attribute.toString());
		Teacher byId = teacherService.getById(userId);
		model.addAttribute("obj",byId);
		return "login/pass";
	}
	
	@RequestMapping("/upass")
	@ResponseBody
	public String upass(HttpServletRequest request,String password){
      Object attribute = request.getSession().getAttribute("userId");
      JSONObject j = new  JSONObject();
	   	if (attribute == null){
	   		j.put("res", 0);
	   		return j.toString();
		}
			Integer userId = Integer.valueOf(attribute.toString());
			Teacher byId = teacherService.getById(userId);
			byId.setPassword(password);
			teacherService.updateById(byId);
			j.put("res", 1);
			return j.toString();
			
	}
	
}

package com.kewen.teacher.controller;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.kewen.teacher.base.BaseController;
import com.kewen.teacher.po.*;
import com.kewen.teacher.utils.Pager;
import java.util.*;

import com.kewen.teacher.po.*;
import com.kewen.teacher.mapper.*;
import com.kewen.teacher.service.*;

/**
 * @ClassName:  
 * @Description: 
 * @author  - - admin
 * @date - 2018年10月23日 19时51分27秒
 */


@Controller
@RequestMapping("/teacherclass")
public class TeacherclassController extends BaseController {
	
	
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private TeacherclassService teacherclassService;
	
	@Autowired
	private TeacherService teacherService;
	
	// --------------------------------------- 华丽分割线 ------------------------------
	
	
	/**
	 * 分页查询 返回list对象(通过对By Sql)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/findBySql")
	public String findBySql(Teacherclass teacherclass, Model model, HttpServletRequest request, HttpServletResponse response) {
		//分页查询
		String sql = "SELECT * FROM teacherclass WHERE teacherId =  "+teacherclass.getTeacherId();
        if(!isEmpty(teacherclass.getTeacherId())){
        	sql += " and teacherId like '%"+teacherclass.getTeacherId()+"%'";
		}
        if(!isEmpty(teacherclass.getBj())){
        	sql += " and bj like '%"+teacherclass.getBj()+"%'";
		}
        if(!isEmpty(teacherclass.getXk())){
        	sql += " and xk like '%"+teacherclass.getXk()+"%'";
		}
        if(!isEmpty(teacherclass.getAddress())){
        	sql += " and address like '%"+teacherclass.getAddress()+"%'";
		}
       sql += " ORDER BY ID DESC ";
		Pager<Teacherclass> pagers = teacherclassService.findBySqlRerturnEntity(sql);
		model.addAttribute("pagers", pagers);
		//存储查询条件
		model.addAttribute("obj", teacherclass);
		return "teacherclass/teacherclass";
	}
	
	@RequestMapping(value = "/findBySqlteacher")
	public String findBySqlteacher(Teacher teacher, Model model, HttpServletRequest request, HttpServletResponse response) {
		//分页查询
		String sql = "SELECT * FROM teacher WHERE isDelete = 0 ";
        if(!isEmpty(teacher.getUsername())){
        	sql += " and username like '%"+teacher.getUsername()+"%'";
		}
        if(!isEmpty(teacher.getSex())){
        	sql += " and sex like '%"+teacher.getSex()+"%'";
		}
        if(!isEmpty(teacher.getPassword())){
        	sql += " and password like '%"+teacher.getPassword()+"%'";
		}
        if(!isEmpty(teacher.getXw())){
        	sql += " and xw like '%"+teacher.getXw()+"%'";
		}
        if(!isEmpty(teacher.getPhone())){
        	sql += " and phone like '%"+teacher.getPhone()+"%'";
		}
        if(!isEmpty(teacher.getIsDelete())){
        	sql += " and isDelete like '%"+teacher.getIsDelete()+"%'";
		}
       sql += " ORDER BY ID DESC ";
		Pager<Teacher> pagers = teacherService.findBySqlRerturnEntity(sql);
		model.addAttribute("pagers", pagers);
		//存储查询条件
		model.addAttribute("obj", teacher);
		return "teacherclass/teacher";
	}
	
	/**
	 * 跳至添加页面
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String add(Integer teacherId,Model model) {
		model.addAttribute("teacherId", teacherId);
		return "teacherclass/add";
	}

	/**
	 * 跳至详情页面
	 * @return
	 */
	@RequestMapping(value = "/view")
	public String view(Integer id,Model model) {
		Teacherclass obj = teacherclassService.load(id);
		model.addAttribute("obj",obj);
		return "teacherclass/view";
	}
	
	/**
	 * 添加执行
	 * @return
	 */
	@RequestMapping(value = "/exAdd")
	public String exAdd(Teacherclass teacherclass, Model model, HttpServletRequest request, HttpServletResponse response) {
		teacherclassService.insert(teacherclass);
		return "redirect:/teacherclass/findBySql.action?teacherId="+teacherclass.getTeacherId();
	}
	
	
	/**
	 * 跳至修改页面
	 * @return
	 */
	@RequestMapping(value = "/update")
	public String update(Integer id,Model model) {
		Teacherclass obj = teacherclassService.load(id);
		model.addAttribute("obj",obj);
		return "teacherclass/update";
	}
	
	/**
	 * 添加修改
	 * @return
	 */
	@RequestMapping(value = "/exUpdate")
	public String exUpdate(Teacherclass teacherclass, Model model, HttpServletRequest request, HttpServletResponse response) {
		Teacherclass byId = teacherclassService.getById(teacherclass.getId());
		teacherclassService.updateById(teacherclass);
		return "redirect:/teacherclass/findBySql.action?teacherId="+byId.getTeacherId();
	}
	
	/**
	 * 删除通过主键
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public String delete(Integer id, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		Teacherclass byId = teacherclassService.getById(id);
		teacherclassService.deleteById(id);
		return "redirect:/teacherclass/findBySql.action?teacherId="+byId.getTeacherId();
	}
	
}

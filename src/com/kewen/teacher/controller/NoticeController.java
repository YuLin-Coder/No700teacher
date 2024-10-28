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
@RequestMapping("/notice")
public class NoticeController extends BaseController {
	
	
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private NoticeService noticeService;
	
	// --------------------------------------- 华丽分割线 ------------------------------
	
	
	/**
	 * 分页查询 返回list对象(通过对By Sql)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/findBySql")
	public String findBySql(Notice notice, Model model, HttpServletRequest request, HttpServletResponse response) {
		//分页查询
		String sql = "SELECT * FROM notice WHERE 1=1 ";
        if(!isEmpty(notice.getTitle())){
        	sql += " and title like '%"+notice.getTitle()+"%'";
		}
        if(!isEmpty(notice.getContent())){
        	sql += " and content like '%"+notice.getContent()+"%'";
		}
       sql += " ORDER BY ID DESC ";
		Pager<Notice> pagers = noticeService.findBySqlRerturnEntity(sql);
		model.addAttribute("pagers", pagers);
		//存储查询条件
		model.addAttribute("obj", notice);
		return "notice/notice";
	}
	
	@RequestMapping(value = "/findBySqlUser")
	public String findBySqlUser(Notice notice, Model model, HttpServletRequest request, HttpServletResponse response) {
		//分页查询
		String sql = "SELECT * FROM notice WHERE 1=1 ";
        if(!isEmpty(notice.getTitle())){
        	sql += " and title like '%"+notice.getTitle()+"%'";
		}
        if(!isEmpty(notice.getContent())){
        	sql += " and content like '%"+notice.getContent()+"%'";
		}
       sql += " ORDER BY ID DESC ";
		Pager<Notice> pagers = noticeService.findBySqlRerturnEntity(sql);
		model.addAttribute("pagers", pagers);
		//存储查询条件
		model.addAttribute("obj", notice);
		return "notice/noticeUser";
	}
	
	/**
	 * 分页查询 返回list对象(通过Map)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/findByMap")
	public String findByMap(Notice notice, Model model, HttpServletRequest request, HttpServletResponse response) {
		//通过map查询
		Map<String,Object> params = new HashMap<String,Object>();
        if(!isEmpty(notice.getTitle())){
        	params.put("title", notice.getTitle());
		}
        if(!isEmpty(notice.getContent())){
        	params.put("content", notice.getContent());
		}
		//分页查询
		Pager<Notice> pagers = noticeService.findByMap(params);
		model.addAttribute("pagers", pagers);
		//存储查询条件
		model.addAttribute("obj", notice);
		return "notice/notice";
	}
	
	/**********************************【增删改】******************************************************/
	
	/**
	 * 跳至添加页面
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String add() {
		return "notice/add";
	}

	/**
	 * 跳至详情页面
	 * @return
	 */
	@RequestMapping(value = "/view")
	public String view(Integer id,Model model) {
		Notice obj = noticeService.load(id);
		model.addAttribute("obj",obj);
		return "notice/view";
	}
	
	/**
	 * 添加执行
	 * @return
	 */
	@RequestMapping(value = "/exAdd")
	public String exAdd(Notice notice, Model model, HttpServletRequest request, HttpServletResponse response) {
		noticeService.insert(notice);
		return "redirect:/notice/findBySql.action";
	}
	
	
	/**
	 * 跳至修改页面
	 * @return
	 */
	@RequestMapping(value = "/update")
	public String update(Integer id,Model model) {
		Notice obj = noticeService.load(id);
		model.addAttribute("obj",obj);
		return "notice/update";
	}
	
	/**
	 * 添加修改
	 * @return
	 */
	@RequestMapping(value = "/exUpdate")
	public String exUpdate(Notice notice, Model model, HttpServletRequest request, HttpServletResponse response) {
		noticeService.updateById(notice);
		return "redirect:/notice/findBySql.action";
	}
	
	/**
	 * 删除通过主键
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public String delete(Integer id, Model model, HttpServletRequest request, HttpServletResponse response) {
		noticeService.deleteById(id);
		return "redirect:/notice/findBySql.action";
	}
	
	
	
}

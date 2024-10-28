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
import com.kewen.teacher.utils.RCSCloudAPITest;

import java.util.*;

import com.kewen.teacher.po.*;
import com.kewen.teacher.mapper.*;
import com.kewen.teacher.service.*;

/**
 * @ClassName:  
 * @Description: 
 * @author  - - admin
 * @date - 2018年10月23日 19时51分28秒
 */


@Controller
@RequestMapping("/xm")
public class XmController extends BaseController {
	
	
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private XmService xmService;
	
	// --------------------------------------- 华丽分割线 ------------------------------
	
	/*********************************查询列表【不分页】***********************************************/
	
	/**
	 * 【不分页 => 查询列表 => 无条件】
	* @Title: listAll 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return 设定文件 
	* @author
	* @return String 返回类型 
	* @throws
	 */
	@RequestMapping(value = "/listAll")
	public String listAll(Xm xm, Model model, HttpServletRequest request, HttpServletResponse response){
		List<Xm> listAll = xmService.listAll();
		model.addAttribute("list", listAll);
		return "xm/xm";
	}
	
	/**
	 *  【不分页=》查询列表=>有条件】
	* @Title: listByEntity 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return 设定文件 
	* @author
	* @return String 返回类型 
	* @throws
	 */
	@RequestMapping(value = "/listByEntity")
	public String listByEntity(Xm xm, Model model, HttpServletRequest request, HttpServletResponse response){
		List<Xm> listAll = xmService.listAllByEntity(xm);
		model.addAttribute("list", listAll);
		return "xm/xm";
	}
	
	/**
	 *  【不分页=》查询列表=>有条件】
	* @Title: listByMap 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return 设定文件 
	* @author 
	* @return String 返回类型 
	* @throws
	 */
	@RequestMapping(value = "/listByMap")
	public String listByMap(Xm xm, Model model, HttpServletRequest request, HttpServletResponse response){
		//通过map查询
		Map<String,Object> params = new HashMap<String,Object>();
	        if(!isEmpty(xm.getName())){
	        	params.put("name", xm.getName());
			}
	        if(!isEmpty(xm.getTeacherId())){
	        	params.put("teacherId", xm.getTeacherId());
			}
	        if(!isEmpty(xm.getContent())){
	        	params.put("content", xm.getContent());
			}
	        if(!isEmpty(xm.getStatus())){
	        	params.put("status", xm.getStatus());
			}
	        if(!isEmpty(xm.getScore())){
	        	params.put("score", xm.getScore());
			}
	    List<Xm> listAll = xmService.listByMap(params);
		model.addAttribute("list", listAll);
		return "xm/xm";
	}
	
	
	/*********************************查询列表【分页】***********************************************/
	
	
	
	/**
	 * 分页查询 返回list对象(通过对象)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/findByObj")
	public String findByObj(Xm xm, Model model, HttpServletRequest request, HttpServletResponse response) {
		//分页查询
		Pager<Xm> pagers = xmService.findByEntity(xm);
		model.addAttribute("pagers", pagers);
		//存储查询条件
		model.addAttribute("obj", xm);
		return "xm/xm";
	}
	
	/**
	 * 分页查询 返回list对象(通过对By Sql)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/spfindBySql1")
	public String findBySql(Xm xm, Model model, HttpServletRequest request, HttpServletResponse response) {
		//分页查询
		/* 0 一待审 1 一审不通 2 一审通过
		 3 二待审 4 二审不通 5 二审通过
	     6 三待审 7 三审不通 8 三审通过
		 9 积分设置完成结束*/
		
		String sql = "SELECT * FROM xm WHERE status = 0";
        if(!isEmpty(xm.getName())){
        	sql += " and name like '%"+xm.getName()+"%'";
		}
        if(!isEmpty(xm.getTeacherId())){
        	sql += " and teacherId like '%"+xm.getTeacherId()+"%'";
		}
        if(!isEmpty(xm.getContent())){
        	sql += " and content like '%"+xm.getContent()+"%'";
		}
        if(!isEmpty(xm.getStatus())){
        	sql += " and status like '%"+xm.getStatus()+"%'";
		}
        if(!isEmpty(xm.getScore())){
        	sql += " and score like '%"+xm.getScore()+"%'";
		}
       sql += " ORDER BY ID DESC ";
		Pager<Xm> pagers = xmService.findBySqlRerturnEntity(sql);
		model.addAttribute("pagers", pagers);
		//存储查询条件
		model.addAttribute("obj", xm);
		return "xm/spxm1";
	}
	
	@RequestMapping(value = "/spfindBySql2")
	public String spfindBySql2(Xm xm, Model model, HttpServletRequest request, HttpServletResponse response) {
		//分页查询
		/* 0 一待审 1 一审不通 2 一审通过
		 3 二待审 4 二审不通 5 二审通过
	     6 三待审 7 三审不通 8 三审通过
		 9 积分设置完成结束*/
		
		String sql = "SELECT * FROM xm WHERE status = 3";
        if(!isEmpty(xm.getName())){
        	sql += " and name like '%"+xm.getName()+"%'";
		}
        if(!isEmpty(xm.getTeacherId())){
        	sql += " and teacherId like '%"+xm.getTeacherId()+"%'";
		}
        if(!isEmpty(xm.getContent())){
        	sql += " and content like '%"+xm.getContent()+"%'";
		}
        if(!isEmpty(xm.getStatus())){
        	sql += " and status like '%"+xm.getStatus()+"%'";
		}
        if(!isEmpty(xm.getScore())){
        	sql += " and score like '%"+xm.getScore()+"%'";
		}
       sql += " ORDER BY ID DESC ";
		Pager<Xm> pagers = xmService.findBySqlRerturnEntity(sql);
		model.addAttribute("pagers", pagers);
		//存储查询条件
		model.addAttribute("obj", xm);
		return "xm/spxm2";
	}
	
	@RequestMapping(value = "/spfindBySql3")
	public String spfindBySql3(Xm xm, Model model, HttpServletRequest request, HttpServletResponse response) {
		//分页查询
		/* 0 一待审 1 一审不通 2 一审通过
		 3 二待审 4 二审不通 5 二审通过
	     6 三待审 7 三审不通 8 三审通过
		 9 积分设置完成结束*/
		
		String sql = "SELECT * FROM xm WHERE status = 6 or status = 8 or status = 9";
        if(!isEmpty(xm.getName())){
        	sql += " and name like '%"+xm.getName()+"%'";
		}
        if(!isEmpty(xm.getTeacherId())){
        	sql += " and teacherId like '%"+xm.getTeacherId()+"%'";
		}
        if(!isEmpty(xm.getContent())){
        	sql += " and content like '%"+xm.getContent()+"%'";
		}
        if(!isEmpty(xm.getStatus())){
        	sql += " and status like '%"+xm.getStatus()+"%'";
		}
        if(!isEmpty(xm.getScore())){
        	sql += " and score like '%"+xm.getScore()+"%'";
		}
       sql += " ORDER BY ID DESC ";
		Pager<Xm> pagers = xmService.findBySqlRerturnEntity(sql);
		model.addAttribute("pagers", pagers);
		//存储查询条件
		model.addAttribute("obj", xm);
		return "xm/spxm3";
	}
	
	
	@RequestMapping(value = "/sp1")
	public String sp1(Xm xm,Integer isTy, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		/* 0 一待审 1 一审不通 2 一审通过
		 3 二待审 4 二审不通 5 二审通过
	     6 三待审 7 三审不通 8 三审通过
		 9 积分设置完成结束*/
		
		if (isTy == 0){
			xm.setStatus(1);
		}else{
			xm.setStatus(2);
		}
		
		xmService.updateById(xm);
		return "redirect:/xm/spfindBySql1.action";
	}
	
	@RequestMapping(value = "/sp2")
	public String sp2(Xm xm,Integer isTy, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		/* 0 一待审 1 一审不通 2 一审通过
		 3 二待审 4 二审不通 5 二审通过
	     6 三待审 7 三审不通 8 三审通过
		 9 积分设置完成结束*/
		
		if (isTy == 0){
			xm.setStatus(4);
		}else{
			xm.setStatus(5);
		}
		
		xmService.updateById(xm);
		return "redirect:/xm/spfindBySql2.action";
	}
	@RequestMapping(value = "/sp3")
	public String sp3(Xm xm,Integer isTy, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		/* 0 一待审 1 一审不通 2 一审通过
		 3 二待审 4 二审不通 5 二审通过
	     6 三待审 7 三审不通 8 三审通过
		 9 积分设置完成结束*/
		
		if (isTy == 0){
			xm.setStatus(7);
		}else{
			xm.setStatus(8);
		}
		
		xmService.updateById(xm);
		return "redirect:/xm/spfindBySql3.action";
	}
	
	/**
	 * 教师  开题审批  只输入项目名称
	 * @param xm
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/findBySql1")
	public String myfindBySql1(Xm xm, Model model, HttpServletRequest request, HttpServletResponse response) {
		

		Object attribute = request.getSession().getAttribute("userId");
		
		if (attribute == null){
			return "redirect:/login/mtuichu";	
		}
		
		Integer userId = Integer.valueOf(attribute.toString());
		
		/* -1 新建
		 * 0 一待审 1 一审不通 2 一审通过
		 3 二待审 4 二审不通 5 二审通过
	     6 三待审 7 三审不通 8 三审通过
		 9 积分设置完成结束*/
		
		//分页查询
		String sql = "SELECT * FROM xm WHERE 1=1 and (status = 0 or status = 1 or status = -1) and teacherId =  "+ userId;
        if(!isEmpty(xm.getName())){
        	sql += " and name like '%"+xm.getName()+"%'";
		}
        if(!isEmpty(xm.getTeacherId())){
        	sql += " and teacherId like '%"+xm.getTeacherId()+"%'";
		}
        if(!isEmpty(xm.getContent())){
        	sql += " and content like '%"+xm.getContent()+"%'";
		}
        if(!isEmpty(xm.getStatus())){
        	sql += " and status like '%"+xm.getStatus()+"%'";
		}
        if(!isEmpty(xm.getScore())){
        	sql += " and score like '%"+xm.getScore()+"%'";
		}
       sql += " ORDER BY ID DESC ";
		Pager<Xm> pagers = xmService.findBySqlRerturnEntity(sql);
		model.addAttribute("pagers", pagers);
		//存储查询条件
		model.addAttribute("obj", xm);
		return "xm/xm1";
	}
	
	@RequestMapping(value = "/findBySql2")
	public String findBySql2(Xm xm, Model model, HttpServletRequest request, HttpServletResponse response) {
		

		Object attribute = request.getSession().getAttribute("userId");
		
		if (attribute == null){
			return "redirect:/login/mtuichu";	
		}
		
		Integer userId = Integer.valueOf(attribute.toString());
		
		/* -1 新建
		 * 0 一待审 1 一审不通 2 一审通过
		 3 二待审 4 二审不通 5 二审通过
	     6 三待审 7 三审不通 8 三审通过
		 9 积分设置完成结束*/
		
		//分页查询
		String sql = "SELECT * FROM xm WHERE 1=1 and (status = 2 or status =3 or status = 4) and teacherId =  "+ userId;
        if(!isEmpty(xm.getName())){
        	sql += " and name like '%"+xm.getName()+"%'";
		}
        if(!isEmpty(xm.getTeacherId())){
        	sql += " and teacherId like '%"+xm.getTeacherId()+"%'";
		}
        if(!isEmpty(xm.getContent())){
        	sql += " and content like '%"+xm.getContent()+"%'";
		}
        if(!isEmpty(xm.getStatus())){
        	sql += " and status like '%"+xm.getStatus()+"%'";
		}
        if(!isEmpty(xm.getScore())){
        	sql += " and score like '%"+xm.getScore()+"%'";
		}
       sql += " ORDER BY ID DESC ";
		Pager<Xm> pagers = xmService.findBySqlRerturnEntity(sql);
		model.addAttribute("pagers", pagers);
		//存储查询条件
		model.addAttribute("obj", xm);
		return "xm/xm2";
	}
	
	
	@RequestMapping(value = "/findBySql3")
	public String findBySql3(Xm xm, Model model, HttpServletRequest request, HttpServletResponse response) {
		

		Object attribute = request.getSession().getAttribute("userId");
		
		if (attribute == null){
			return "redirect:/login/mtuichu";	
		}
		
		Integer userId = Integer.valueOf(attribute.toString());
		
		/* -1 新建
		 * 0 一待审 1 一审不通 2 一审通过
		 3 二待审 4 二审不通 5 二审通过
	     6 三待审 7 三审不通 8 三审通过
		 9 积分设置完成结束*/
		
		//分页查询
		String sql = "SELECT * FROM xm WHERE 1=1 and (status = 5 or status =6 or status = 7 or status = 9 or status = 8) and teacherId =  "+ userId;
        if(!isEmpty(xm.getName())){
        	sql += " and name like '%"+xm.getName()+"%'";
		}
        if(!isEmpty(xm.getTeacherId())){
        	sql += " and teacherId like '%"+xm.getTeacherId()+"%'";
		}
        if(!isEmpty(xm.getContent())){
        	sql += " and content like '%"+xm.getContent()+"%'";
		}
        if(!isEmpty(xm.getStatus())){
        	sql += " and status like '%"+xm.getStatus()+"%'";
		}
        if(!isEmpty(xm.getScore())){
        	sql += " and score like '%"+xm.getScore()+"%'";
		}
       sql += " ORDER BY ID DESC ";
		Pager<Xm> pagers = xmService.findBySqlRerturnEntity(sql);
		model.addAttribute("pagers", pagers);
		//存储查询条件
		model.addAttribute("obj", xm);
		return "xm/xm3";
	}
	
	@RequestMapping(value = "/findBySql4")
	public String findBySql4(Xm xm, Model model, HttpServletRequest request, HttpServletResponse response) {
		

		Object attribute = request.getSession().getAttribute("userId");
		
		if (attribute == null){
			return "redirect:/login/mtuichu";	
		}
		
		Integer userId = Integer.valueOf(attribute.toString());
		
		/* -1 新建
		 * 0 一待审 1 一审不通 2 一审通过
		 3 二待审 4 二审不通 5 二审通过
	     6 三待审 7 三审不通 8 三审通过
		 9 积分设置完成结束*/
		
		//分页查询
		String sql = "SELECT * FROM xm WHERE 1=1 and status = 9 ";
        if(!isEmpty(xm.getName())){
        	sql += " and name like '%"+xm.getName()+"%'";
		}
        if(!isEmpty(xm.getTeacherId())){
        	sql += " and teacherId like '%"+xm.getTeacherId()+"%'";
		}
        if(!isEmpty(xm.getContent())){
        	sql += " and content like '%"+xm.getContent()+"%'";
		}
        if(!isEmpty(xm.getStatus())){
        	sql += " and status like '%"+xm.getStatus()+"%'";
		}
        if(!isEmpty(xm.getScore())){
        	sql += " and score like '%"+xm.getScore()+"%'";
		}
       sql += " ORDER BY score DESC ";
		List<Xm> pagers = xmService.listBySqlReturnEntity(sql);
		model.addAttribute("pagers", pagers);
		//存储查询条件
		model.addAttribute("obj", xm);
		return "xm/xm4";
	}
	/**
	 * 分页查询 返回list对象(通过Map)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/findByMap")
	public String findByMap(Xm xm, Model model, HttpServletRequest request, HttpServletResponse response) {
		//通过map查询
		Map<String,Object> params = new HashMap<String,Object>();
        if(!isEmpty(xm.getName())){
        	params.put("name", xm.getName());
		}
        if(!isEmpty(xm.getTeacherId())){
        	params.put("teacherId", xm.getTeacherId());
		}
        if(!isEmpty(xm.getContent())){
        	params.put("content", xm.getContent());
		}
        if(!isEmpty(xm.getStatus())){
        	params.put("status", xm.getStatus());
		}
        if(!isEmpty(xm.getScore())){
        	params.put("score", xm.getScore());
		}
		//分页查询
		Pager<Xm> pagers = xmService.findByMap(params);
		model.addAttribute("pagers", pagers);
		//存储查询条件
		model.addAttribute("obj", xm);
		return "xm/xm";
	}
	
	/**********************************【增删改】******************************************************/
	
	/**
	 * 跳至添加页面
	 * @return
	 */
	@RequestMapping(value = "/add1")
	public String add() {
		return "xm/add1";
	}

	/**
	 * 跳至详情页面
	 * @return
	 */
	@RequestMapping(value = "/view1")
	public String view(Integer id,Model model) {
		Xm obj = xmService.load(id);
		model.addAttribute("obj",obj);
		return "xm/view1";
	}
	@RequestMapping(value = "/view2")
	public String view2(Integer id,Model model) {
		Xm obj = xmService.load(id);
		model.addAttribute("obj",obj);
		return "xm/view2";
	}
	@RequestMapping(value = "/view3")
	public String view3(Integer id,Model model) {
		Xm obj = xmService.load(id);
		model.addAttribute("obj",obj);
		return "xm/view3";
	}
	@RequestMapping(value = "/view4")
	public String view4(Integer id,Model model) {
		Xm obj = xmService.load(id);
		model.addAttribute("obj",obj);
		return "xm/view4";
	}
	@RequestMapping(value = "/view5")
	public String view5(Integer id,Model model) {
		Xm obj = xmService.load(id);
		model.addAttribute("obj",obj);
		return "xm/view5";
	}
	/**
	 * 添加执行
	 * @return
	 */
	@RequestMapping(value = "/exAdd1")
	public String exAdd(Xm xm, Model model, HttpServletRequest request, HttpServletResponse response) {

		Object attribute = request.getSession().getAttribute("userId");
		
		if (attribute == null){
			return "redirect:/login/mtuichu";	
		}
		
		Integer userId = Integer.valueOf(attribute.toString());
		xm.setStatus(-1);
		xm.setTeacherId(userId);
		xmService.insert(xm);
		return "redirect:/xm/findBySql1.action";
	}
	
	
	@RequestMapping(value = "/sb1")
	public String sb1(Xm xm, Model model, HttpServletRequest request, HttpServletResponse response) {
		/* -1 新建
		 * 0 一待审 1 一审不通 2 一审通过
		 3 二待审 4 二审不通 5 二审通过
	     6 三待审 7 三审不通 8 三审通过
		 9 积分设置完成结束*/
		xm.setStatus(0);
		xmService.updateById(xm);
		return "redirect:/xm/findBySql1.action";
	}
	
	
	@RequestMapping(value = "/sb2")
	public String sb2(Xm xm, Model model, HttpServletRequest request, HttpServletResponse response) {
		/* -1 新建
		 * 0 一待审 1 一审不通 2 一审通过
		 3 二待审 4 二审不通 5 二审通过
	     6 三待审 7 三审不通 8 三审通过
		 9 积分设置完成结束*/
		xm.setStatus(3);
		xmService.updateById(xm);
		return "redirect:/xm/findBySql2.action";
	}
	
	@RequestMapping(value = "/sb3")
	public String sb3(Xm xm, Model model, HttpServletRequest request, HttpServletResponse response) {
		/* -1 新建
		 * 0 一待审 1 一审不通 2 一审通过
		 3 二待审 4 二审不通 5 二审通过
	     6 三待审 7 三审不通 8 三审通过
		 9 积分设置完成结束*/
		xm.setStatus(6);
		xmService.updateById(xm);
		return "redirect:/xm/findBySql3.action";
	}
	
	/**
	 * 跳至修改页面
	 * @return
	 */
	@RequestMapping(value = "/update1")
	public String update(Integer id,Model model) {
		Xm obj = xmService.load(id);
		model.addAttribute("obj",obj);
		return "xm/update1";
	}
	
	@RequestMapping(value = "/update2")
	public String update2(Integer id,Model model) {
		Xm obj = xmService.load(id);
		model.addAttribute("obj",obj);
		return "xm/update2";
	}
	
	/**
	 * 添加修改
	 * @return
	 */
	@RequestMapping(value = "/exUpdate1")
	public String exUpdate(Xm xm, Model model, HttpServletRequest request, HttpServletResponse response) {
		xmService.updateById(xm);
		return "redirect:/xm/findBySql1.action";
	}
	
	@RequestMapping(value = "/exUpdate2")
	public String exUpdate2(Xm xm, Model model, HttpServletRequest request, HttpServletResponse response) {
		xmService.updateById(xm);
		return "redirect:/xm/findBySql2.action";
	}
	@RequestMapping(value = "/exUpdate5")
	public String exUpdate5(Xm xm, Model model, HttpServletRequest request, HttpServletResponse response) {
		xm.setStatus(9);
		Xm byId = xmService.getById(xm.getId());
		String content="@1@="+byId.getTeacher().getUsername();
		content+="||@2@="+"您的申报课题《"+byId.getName()+"》已申报通过";
		
		RCSCloudAPITest.sendTplSms("9fbd7bdd0a2a446eb9d0d7d1d7837eb4", byId.getTeacher().getPhone(), content, null);
		xmService.updateById(xm);
		return "redirect:/xm/spfindBySql3.action";
	}
	/**
	 * 删除通过主键
	 * @return
	 */
	@RequestMapping(value = "/delete1")
	public String delete(Integer id, Model model, HttpServletRequest request, HttpServletResponse response) {
		xmService.deleteById(id);
		return "redirect:/xm/findBySql1.action";
	}
	
	@RequestMapping(value = "/delete2")
	public String delete2(Integer id, Model model, HttpServletRequest request, HttpServletResponse response) {
		xmService.deleteById(id);
		return "redirect:/xm/findBySql2.action";
	}
	@RequestMapping(value = "/delete3")
	public String delete3(Integer id, Model model, HttpServletRequest request, HttpServletResponse response) {
		xmService.deleteById(id);
		return "redirect:/xm/findBySql3.action";
	}
	
}

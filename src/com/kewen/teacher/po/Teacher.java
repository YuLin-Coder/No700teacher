package com.kewen.teacher.po;
import java.util.*;
import java.io.Serializable;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2018年10月23日 19时51分27秒
 */
public class Teacher implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 
	 *  @Fields Id : id
	 * 
	 * */
	private Integer id;
	/** 
	 *  @Fields Username : username
	 * 
	 * */
	private String username;
	/** 
	 *  @Fields Sex : sex
	 * 
	 * */
	private String sex;
	/** 
	 *  @Fields Password : password
	 * 
	 * */
	private String password;
	/** 
	 *  @Fields Xw : 学位
	 * 
	 * */
	private String xw;
	/** 
	 *  @Fields Phone : 手机号
	 * 
	 * */
	private String phone;
	/** 
	 *  @Fields IsDelete : isDelete
	 * 
	 * */
	private Integer isDelete;

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getSex() {
		return this.sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getXw() {
		return this.xw;
	}
	
	public void setXw(String xw) {
		this.xw = xw;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Integer getIsDelete() {
		return this.isDelete;
	}
	
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	
    public Teacher() {
		
	}

	public Teacher(Integer id ,String username ,String sex ,String password ,String xw ,String phone ,Integer isDelete ){
	super();
	this.id=id;
	this.username=username;
	this.sex=sex;
	this.password=password;
	this.xw=xw;
	this.phone=phone;
	this.isDelete=isDelete;
	}
	
	@Override
	public String toString() {
		return "Teacher [id="+ id + ",username="+ username + ",sex="+ sex + ",password="+ password + ",xw="+ xw + ",phone="+ phone + ",isDelete="+ isDelete +  "]";
	}


}


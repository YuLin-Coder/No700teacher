package com.kewen.teacher.po;
import java.util.*;
import java.io.Serializable;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2018年10月23日 19时51分27秒
 */
public class Teacherclass implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 
	 *  @Fields Id : id
	 * 
	 * */
	private Integer id;
	/** 
	 *  @Fields TeacherId : teacherId
	 * 
	 * */
	private Integer teacherId;
	
	private Teacher teacher;
	/** 
	 *  @Fields Bj : 班级
	 * 
	 * */
	private String bj;
	/** 
	 *  @Fields Xk : 学科
	 * 
	 * */
	private String xk;
	/** 
	 *  @Fields Address : 上课地点
	 * 
	 * */
	private String address;

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getTeacherId() {
		return this.teacherId;
	}
	
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	
	public String getBj() {
		return this.bj;
	}
	
	public void setBj(String bj) {
		this.bj = bj;
	}
	
	public String getXk() {
		return this.xk;
	}
	
	public void setXk(String xk) {
		this.xk = xk;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	
    public Teacherclass() {
		
	}

	public Teacherclass(Integer id ,Integer teacherId ,String bj ,String xk ,String address ){
	super();
	this.id=id;
	this.teacherId=teacherId;
	this.bj=bj;
	this.xk=xk;
	this.address=address;
	}
	
	@Override
	public String toString() {
		return "Teacherclass [id="+ id + ",teacherId="+ teacherId + ",bj="+ bj + ",xk="+ xk + ",address="+ address +  "]";
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


}


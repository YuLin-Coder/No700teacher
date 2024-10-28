package com.kewen.teacher.po;
import java.util.*;
import java.io.Serializable;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2018年10月23日 19时51分28秒
 */
public class Xm implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 
	 *  @Fields Id : id
	 * 
	 * */
	private Integer id;
	/** 
	 *  @Fields Name : name
	 * 
	 * */
	private String name;
	/** 
	 *  @Fields TeacherId : teacherId
	 * 
	 * */
	private Integer teacherId;
	
	private Teacher teacher;
	
	/** 
	 *  @Fields Content : content
	 * 
	 * */
	private String content;
	/** 
	 *  @Fields Status :
	 0 一待审 1 一审不通 2 一审通过
	 3 二待审 4 二审不通 5 二审通过
     6 三待审 7 三审不通 8 三审通过
	 9 积分设置完成结束
	 * 
	 * */
	private Integer status;
	/** 
	 *  @Fields Score : 积分
	 * 
	 * */
	private Integer score;

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getTeacherId() {
		return this.teacherId;
	}
	
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getScore() {
		return this.score;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
	
	
    public Xm() {
		
	}

	public Xm(Integer id ,String name ,Integer teacherId ,String content ,Integer status ,Integer score ){
	super();
	this.id=id;
	this.name=name;
	this.teacherId=teacherId;
	this.content=content;
	this.status=status;
	this.score=score;
	}
	
	@Override
	public String toString() {
		return "Xm [id="+ id + ",name="+ name + ",teacherId="+ teacherId + ",content="+ content + ",status="+ status + ",score="+ score +  "]";
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


}


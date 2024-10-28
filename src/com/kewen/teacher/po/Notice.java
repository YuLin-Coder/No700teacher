package com.kewen.teacher.po;
import java.util.*;
import java.io.Serializable;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2018年10月23日 19时51分27秒
 */
public class Notice implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 
	 *  @Fields Id : id
	 * 
	 * */
	private Integer id;
	/** 
	 *  @Fields Title : title
	 * 
	 * */
	private String title;
	/** 
	 *  @Fields Content : content
	 * 
	 * */
	private String content;

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	
    public Notice() {
		
	}

	public Notice(Integer id ,String title ,String content ){
	super();
	this.id=id;
	this.title=title;
	this.content=content;
	}
	
	@Override
	public String toString() {
		return "Notice [id="+ id + ",title="+ title + ",content="+ content +  "]";
	}


}


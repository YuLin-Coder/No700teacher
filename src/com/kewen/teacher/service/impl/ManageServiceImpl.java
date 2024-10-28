/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年12月02日 12时57分57秒
 */
package com.kewen.teacher.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kewen.teacher.base.*;
import com.kewen.teacher.mapper.*;
import com.kewen.teacher.po.*;
import com.kewen.teacher.service.*;

import java.util.*;


@Service
public class ManageServiceImpl extends BaseServiceImpl<Manage> implements ManageService{
	 
	
	@Autowired
	private ManageMapper manageMapper;
	@Override
	public BaseDao<Manage> getBaseDao() {
		return manageMapper;
	}

}

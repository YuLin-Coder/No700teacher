/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2018年10月23日 19时51分28秒
 */
package com.kewen.teacher.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.kewen.teacher.base.*;
import com.kewen.teacher.po.*;
import com.kewen.teacher.service.XmService;
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

@Service
public class XmServiceImpl extends BaseServiceImpl<Xm> implements XmService{
	 
	
	@Autowired
	private XmMapper xmMapper;
	@Override
	public BaseDao<Xm> getBaseDao() {
		return xmMapper;
	}

}

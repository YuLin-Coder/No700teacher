/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2018年10月23日 19时51分27秒
 */
package com.kewen.teacher.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.kewen.teacher.base.*;
import com.kewen.teacher.po.*;
import com.kewen.teacher.service.NoticeService;
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

@Service
public class NoticeServiceImpl extends BaseServiceImpl<Notice> implements NoticeService{
	 
	
	@Autowired
	private NoticeMapper noticeMapper;
	@Override
	public BaseDao<Notice> getBaseDao() {
		return noticeMapper;
	}

}

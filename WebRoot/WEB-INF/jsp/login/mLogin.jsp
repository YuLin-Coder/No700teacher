<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>登录</title>  
     <link type="text/css" rel="stylesheet" href="${ctx}/resource/css/login.css">
    <script type="text/javascript" src="${ctx}/resource/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/login.js"></script>
</head>
<body style="overflow:hidden">
    <div class="pagewrap">
        <div class="main">
            <div class="header"></div>
            <div class="content">
            <div class="con_left"></div>
                <div class="con_right">
                    <div class="con_r_top"> <a href="javascript:;" class="right" style="color: rgb(51, 51, 51);
                     border-bottom-width: 2px; border-bottom-style: solid; border-bottom-color: rgb(46, 85, 142);">基于web的师资管理系统 </a></div>
                    <ul>
                        <li class="con_r_left" style="display: none;">
                            <div class="erweima">
                                <div class="qrcode">
                                    <div id="output" style="width: 100%; position: relative">
                                        <img src="img/2weima.jpg" style="width: 174px; height: 174px"></div>                                    
                                </div>
                             </div>
                           
                        </li>
						
						
                        <li class="con_r_right" style="display: block;">
                           <form name="form1" method="post" action="${ctx}/login/toLogin" autocomplete="off">
                			 <div class="user">
                        <div><span class="user-icon"></span>
                            <input type="text" id="userid" name="userName" placeholder="　输入账号" value="教师01">
					    </div>

                        <div><span class="mima-icon"></span>
                            <input type="password" id="pwd" name="passWord" placeholder="　输入密码" value="111111">
					    </div>
					    
						 <div><span class="mima-icon"></span>
                           <select name="type" style="width: 323px;height: 33px">
							  <option value ="">请选择角色</option>
							  <option value ="1">管理员</option>
							  <option value="2">教师</option>
							</select>
					    </div>
						                                
                   </div><br>
                        <button id="btn_Login" type="submit">登 录</button>
				</form>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
   <title>后台管理中心</title>  
    <script src="${ctx}/resource/js/jquery.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/css/main.css"/>
     <script type="text/javascript" src="${ctx}/resource/ueditor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="${ctx}/resource/ueditor/ueditor.all.min.js"></script>
    <link rel="stylesheet" href="${ctx}/resource/css/reset.css" />
	<link rel="stylesheet" href="${ctx}/resource/css/style.css" />
	<script src="${ctx}/resource/js/Ecalendar.jquery.min.js"></script>
</head>
<body>

 <%@ include file="/common/top.jsp" %>
 
<div class="container clearfix">
     <%@ include file="/common/menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="">首页</a><span class="crumb-step">&gt;</span></div>
        </div>
         <!-- 
    private String username;
	private String sex;
	private String password;
	private String xw;
	private String phone; 
	-->
        <div class="result-wrap">
            <div class="result-content">
                <form action="" method="post" id="myform" name="myform" enctype="multipart/form-data">
                
                 <input type="hidden" id="yuan" value="${obj.password}">
                  
                    <table class="insert-tab" width="100%">
                        <tbody>
                        
                        <tr>
                                <th><i class="require-red">*</i>旧密码：</th>
                                <td>
                                    <input class="common-text required" id="jiu"  size="50" type="text" placeholder="输入旧密码" >
                                </td>
                        </tr>
                        
                         <tr>
                                <th><i class="require-red">*</i>新密码：</th>
                                <td>
                                    <input class="common-text required" id="xin" name="password" size="50" type="text" placeholder="输入新密码" >
                                </td>
                        </tr>
                         <tr>
                                <th><i class="require-red">*</i>确认密码：</th>
                                <td>
                                    <input class="common-text required" id="que" size="50" type="text" placeholder="再次输入密码"  >
                                </td>
                        </tr>
                        
                        
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10 con" value="提交" type="button">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
<script type="text/javascript">
		$(function(){
			
			$(".con").click(function(){
				var yuan = $("#yuan").val();
				var jiu = $("#jiu").val();
				var xin = $("#xin").val();
				var que = $("#que").val();
				if (jiu == null || jiu == ''){
					alert("旧密码不能为空");
					return false;
				}
				if (xin == null || xin == ''){
					alert("新密码不能为空");
					return false;
				}
				if (que == null || que == ''){
					alert("确认密码不能为空");
					return false;
				}
				if(yuan != jiu){
					alert("旧密码输入不正确");
					return false;
				}
				if(yuan == xin){
					alert("新密码和旧密码不能一样");
					return false;
				}
				if(xin != que){
					alert("新密码和确认密码输入不一致");
					return false;
				}
				 $.ajax({  
	                    type : "POST",  //提交方式  
	                    url : "${ctx}/login/upass.do",//路径  
	                    data : {  
	                        "password" : xin  
	                    },//数据，这里使用的是Json格式进行传输  
	                    success : function(result) {//返回数据根据结果进行相应的处理  
	                    	var re = JSON.parse(result)
	                    	if (re.res == 0){
	                    		alert("请登陆");
	                    		top.location.href = "${ctx}/login/login";
	                    	}else{
	                    		alert("修改成功，请重新登陆");
	                    		top.location.href = "${ctx}/login/login";
	                    	}
	                    }  
	                });  
			});
			
		});
	</script>
</html>
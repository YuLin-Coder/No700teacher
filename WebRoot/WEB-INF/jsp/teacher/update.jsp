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
                <form action="${ctx}/teacher/exUpdate" method="post" id="myform" name="myform" enctype="multipart/form-data">
                 
                  
                   <input type="hidden" name="id" value="${obj.id}">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        
                        <tr>
                                <th><i class="require-red">*</i>教师名称：</th>
                                <td>
                                    <input class="common-text required" id="title" name="username" size="50" value="${obj.username}" type="text">
                                </td>
                        </tr>
                        
                          <tr>
                            <th width="120"><i class="require-red">*</i>性别：</th>
                            <td>
                                 <select name="sex" class="input w50">
					               <option value="男" ${obj.sex == '男' ? "selected" : ""}>男</option>
					               <option value="女" ${obj.sex == '女' ? "selected" : ""}>女</option>
					            </select>
                            </td>
                        </tr>
                        
                         <tr>
                                <th><i class="require-red">*</i>学位：</th>
                                <td>
                                    <input type="text" name="xw"  class='ECalendar common-text required' id=""  value="${obj.xw}"/>
                                </td>
                        </tr>
                          <tr>
                                <th><i class="require-red">*</i>手机号：</th>
                                <td>
                                    <input class="common-text required" id="title" name="phone" size="50" value="${obj.phone}" type="text">
                                </td>
                        </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
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
				$("#ECalendar_case1").ECalendar({
						 type:"date",
						 skin:"#233",
						 offset:[0,2]
				});
				$("#ECalendar_case2").ECalendar({
						 type:"time",
						 offset:[0,1]
				});
				$("#ECalendar_case3").ECalendar({
						 type:"date",
						 stamp:false,
						 skin:5,
						 format:"yyyy年mm月dd日",
						 callback:function(v,e)
						 {
							 $("#ECalendar_case3").val(v)
						 }
				});
		})
	</script>
</html>
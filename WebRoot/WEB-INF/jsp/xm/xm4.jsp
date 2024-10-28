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
    
</head>
<body>

 <%@ include file="/common/top.jsp" %>
<div class="container clearfix">
     <%@ include file="/common/menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="">首页</a></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="${ctx}/xm/findBySql4" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="项目名" name="name" value="${obj.name}" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>

        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
           <%--   <div class="result-title">
                    <div class="result-list">
                        <a href="${ctx}/xm/add1"><i class="icon-font"></i>新增</a>
                    </div>
                </div>  --%>
          <!-- 
  	private String name;
	private Integer teacherId;
	private Teacher teacher;
	private String content;
	private Integer status; /* -1 新建
		 * 0 一待审 1 一审不通 2 一审通过
		 3 二待审 4 二审不通 5 二审通过
	     6 三待审 7 三审不通 8 三审通过
		 9 积分设置完成结束*/
	private Integer score;积分
	-->
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>项目排名</th>
                             <th>项目积分</th>
                            <th>项目名称</th>
                            <th>教师名称</th>
                            <th>操作</th>
                        </tr>
                        
                  <c:forEach items="${pagers}" var="data" varStatus="l">
	                  <tr>
	                     <td>${l.index+1}</td>
	                      <td>${data.score}</td>
	                    <td>${data.name}</td>
	                    
	                    <td>${data.teacher.username}</td>
	                   <td>
	                    <a class="link-update" href="${ctx}/xm/view4?id=${data.id}">查看详情</a>
	                    </td>
	                </tr>
                  </c:forEach>
                  
                  
                   <tr>
                    <!-- 分页结束 -->
      			 </tr>
                    </table>
                    
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@include file="/common/taglibs.jsp"%>
 <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>菜单</a>
                    <ul class="sub-menu">
                    
                    <c:if test="${role == 1 }">
                     <li><a href="${ctx}/teacher/findBySql"><i class="icon-font">&#xe005;</i>教师管理</a></li>
                        <li><a href="${ctx}/teacherclass/findBySqlteacher"><i class="icon-font">&#xe005;</i>授课管理</a></li>
                        <li><a href="${ctx}/xm/spfindBySql1"><i class="icon-font">&#xe005;</i>开题审批管理</a></li>
                        <li><a href="${ctx}/xm/spfindBySql2"><i class="icon-font">&#xe005;</i>项目详情审批管理</a></li>
                        <li><a href="${ctx}/xm/spfindBySql3"><i class="icon-font">&#xe005;</i>项目总结管理</a></li>
                        <li><a href="${ctx}/notice/findBySql"><i class="icon-font">&#xe005;</i>公告管理</a></li>
                    </c:if>
                       <c:if test="${role == 2 }">
                        <li><a href="${ctx}/login/update"><i class="icon-font">&#xe005;</i>个人信息</a></li>
                        <li><a href="${ctx}/login/pass"><i class="icon-font">&#xe005;</i>修改密码</a></li>
                        <li><a href="${ctx}/notice/findBySqlUser"><i class="icon-font">&#xe005;</i>公告列表</a></li>
                        <li><a href="${ctx}/xm/findBySql1"><i class="icon-font">&#xe005;</i>开题审批管理</a></li>
                        <li><a href="${ctx}/xm/findBySql2"><i class="icon-font">&#xe005;</i>项目详情审批管理</a></li>
                        <li><a href="${ctx}/xm/findBySql3"><i class="icon-font">&#xe005;</i>项目总结管理</a></li>
                         <li><a href="${ctx}/xm/findBySql4"><i class="icon-font">&#xe005;</i>项目排名</a></li>
                       </c:if>
                       
                    </ul>
                </li>
            </ul>
        </div>
    </div>
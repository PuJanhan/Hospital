<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
    <link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
    
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="all" />
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/demo.css" type="text/css" media="all" />
     
    
</head>

<body>
    <!--导航-->

   
  <nav class="top">
     <a href="<c:url value='/main.action'/>">
        <span class="glyphicon glyphicon-home hospitalColor"></span>
              云医院首页
    </a>
     <span>欢迎来到云医院！  </span>
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">
			<a href="<c:url value='/login.action'/>" target="_parent">登录</a> |&nbsp; 
			<a href="<c:url value='/regist.action'/>" target="_parent">注册</a>		
		</c:when>
		<c:otherwise>
			您好：${sessionScope.session_user.sname }&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="<c:url value='/findappoint.action?usersname=${sessionScope.session_user.sname}'/>" target="body">我的预约</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<!-- <a href="<c:url value='/OrderServlet?method=myOrders'/>" target="body">我的订单</a>&nbsp;&nbsp;|&nbsp;&nbsp; -->
			<a href="<c:url value='/quit.action'/>" target="_parent">退出</a>		
		</c:otherwise>
	</c:choose>



       <span class="pull-right">
            <a href="#nowhere">我的</a>
        </span>
     <img src="${pageContext.request.contextPath}/imag/hospital.jpg" width="1519px" height="126px">
    <!--菜单-->
    <div class="headmenu">

        <span></span><span></span>
        <span><a href="<c:url value='/main.action'/>">预约挂号</a></span>
        <span><a href="<c:url value='/findappoint.action?usersname=${sessionScope.session_user.sname}'/>">我的预约</a></span>
        
        <span><a href="#nowhere">在线支付</a></span>
        <span><a href="<c:url value='/chat.action'/>"> 云诊室 </a></span>
    </div>
</nav>
 </body>
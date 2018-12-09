<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录界面</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
    <link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
    
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="all" />
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/demo.css" type="text/css" media="all" />
     
    
</head>
<body>

 <%@ include file="demo1.jsp"%>
 <!--登陆框-->
     <div class="simpleLogo">
            <img src="http://how2j.cn/tmall/img/site/simpleLogo.png">
       </div>
       
        <img src="http://how2j.cn/tmall/img/site/loginBackground.png" class="loginBackgroundImg" id="loginBackgroundImg">
      
      <div class="loginSmallDiv" id="loginSmallDiv">
            <div class="loginheadtext">填用户登录</div>
            <br/>
     <p style="color: red; font-weight:2000">${msg }</p>
     <form action="${pageContext.request.contextPath }/login.action" method="post" target="_top">
	<input type="hidden" name="method" value="login"/>
	<div class="loginInput">
	 <span class="loginInputlabel">
	      用户名</span>
	<input type="text" name="username" value="${form.username }"/>
	
	</div>
	  <div class="loginInput ">
	<span class="loginInputlabel">密　码</span>
	<input type="password" name="password" value="${form.password }"/><br/>
	<div style="margin-top:60px">
                <input type="submit" value="登录" class="btn btn-block loginButton">
            </div>
	</div>
</form>

            <div >
                <a class="pull-right loginInputa" href="<c:url value='/regist.action'/>">免费注册</a>
            </div>
    </div>




    <%@ include file="demo2.jsp"%> 
</body>
</html>
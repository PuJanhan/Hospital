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
 
  <%--
  1. 显示errors --> 字段错误
  2. 显示异常错误
  3. 回显
   --%>
    <%@ include file="demo1.jsp"%>
    <div class="simpleLogo">
            <img src="http://how2j.cn/tmall/img/site/simpleLogo.png">
        </div>
        <img src="http://how2j.cn/tmall/img/site/loginBackground.png" class="loginBackgroundImg" id="loginBackgroundImg">
     
 <div class="registerSmallDiv" id="registerSmallDiv">
            <div class="loginheadtext">填写注册信息</div>
<p style="color: red; font-weight: 900">${msg }</p>

<form action="${pageContext.request.contextPath }/regist.action" method="post" enctype="multipart/form-data">

   <div class="loginInput">
                <span class="loginInputlabel">
                    用户名
                </span>
                <input type="text" placeholder="用户名" name="sname" value="${form.sname }"><!--输入框-->
                <span style="color: red; font-weight: 900">${errors.sname }</span>
            </div>
             <div class="loginInput ">
                <span class="loginInputlabel">
                    密码
                </span>
                <input type="password" placeholder="密码" name="spassword" value="${form.spassword }">
                <span style="color: red; font-weight: 900">${errors.spassword }</span>
            </div>
	<div class="loginInput">
                <span class="loginInputlabel">
                    年龄
                </span>
                <input type="text" placeholder="年龄" name="age" value="${form.age }"><!--输入框-->
                <span style="color: red; font-weight: 900">${errors.age }</span>
            </div>
	<div class="loginInput">
                <span class="loginInputlabel">
                    性别
                </span>
                <input type="text" placeholder="性别" name="gender" value="${form.gender }"><!--输入框-->
                <span style="color: red; font-weight: 900">${errors.gender }</span>
            </div>

            
         <div class="loginInput">
           <span class="loginInputlabel">
            身份证号</span>
           <input type="text" name="idnumber" placeholder="身份证号" value="${form.idnumber}"/>
	<span style="color: red; font-weight: 900">${errors.idnumber }</span>
	</div>
	
	<div class="loginInput">
	<span class="loginInputlabel">
	手机号</span>
	<input type="text" placeholder="手机号"name="telnumber" value="${form.telnumber }"/>
	<span style="color: red; font-weight: 900">${errors.telnumber }</span>
	</div>
      
       <span class="loginInputlabel">图片 </span>
        <input type="file" name="file">
	
	<div style="margin-top:60px">
                <input type="submit" value="点击注册" class="btn btn-block loginButton">
            </div>
</form>
</div>
  </body>
</html>

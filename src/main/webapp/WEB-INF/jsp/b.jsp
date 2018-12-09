<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
    <title>注册</title>
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
    <div id="loginDiv">
        <div class="simpleLogo">
            <img src="http://how2j.cn/tmall/img/site/simpleLogo.png">
        </div>
        <img src="http://how2j.cn/tmall/img/site/loginBackground.png" class="loginBackgroundImg" id="loginBackgroundImg">

        <div class="registerSmallDiv" id="registerSmallDiv">

            <div class="loginheadtext">填写注册信息</div>

            <div class="loginInput">
                <span class="loginInputlabel">
                    用户名
                </span>
                <input type="text" placeholder="用户名" name="zcname" id="zcname"><!--输入框-->
            </div>

            <div class="loginInput ">
                <span class="loginInputlabel">
                    密码
                </span>
                <input type="password" placeholder="密码" name="zcpassword" id="zcpassword">
            </div>

            <div class="loginInput">
                <span class="loginInputlabel">
                    年龄
                </span>
                <input type="text" placeholder="年龄" name="zcold" id="zcold"><!--输入框-->
            </div>

            <div class="loginInput">
                <span class="loginInputlabel">
                    性别
                </span>
                <input type="text" placeholder="性别" name="zcgender" id="zcgender"><!--输入框-->
            </div>

            <div class="loginInput">
                <span class="loginInputlabel">
                    身份证号
                </span>
                <input type="text" placeholder="身份证号" name="zcid" id="zcid"><!--输入框-->
            </div>

            <div class="loginInput">
                <span class="loginInputlabel">
                    手机号
                </span>
                <input type="text" placeholder="手机号" name="zctel" id="zctel"><!--输入框-->
            </div>
                 <div class="loginInput">
                <span class="loginInputlabel">
                    上传头像
                </span>
                <input type="file" name="file">
            </div>

            <div style="margin-top:60px">
                <input type="submit" value="注册" class="btn btn-block loginButton">
            </div>
        </div>
    </div>
<%@ include file="demo2.jsp"%>
</body>
</html>
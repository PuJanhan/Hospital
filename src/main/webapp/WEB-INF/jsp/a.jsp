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

    
     
  
    
    <%@ include file="demo1.jsp"%> 


    <!--首页主体-->



    <iframe src="<c:url value='/findAll_Department.action'/>" name="left" frameborder="0"  width="200" height="1000" scrolling="no"></iframe>
    <iframe name="right" frameborder="0"  width="1135" height="1000"scrolling="no"></iframe>


     <%@ include file="demo2.jsp"%> 

   

</body>
</html>
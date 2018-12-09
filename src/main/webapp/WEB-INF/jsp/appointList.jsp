<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预约列表</title>
</head>
<body>


<c:forEach items="${Allappoint}" var="appoint">

   ${appoint.usersname} 预约 ${appoint.docname } 时间为:<fmt:formatDate value="${appoint.atime }" pattern="yyyy-MM-dd HH:mm:ss"/>
   
   <a href="<c:url value='/chat.action?usersname=${appoint.usersname}'/>">开始就诊</a>
   <br/>

</c:forEach>
</body>
</html>
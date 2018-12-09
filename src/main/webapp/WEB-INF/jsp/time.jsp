<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach items="${timeList}" var="time">
<div>
	<a href="<c:url value='/finddoctorbycid.action?cid=${department.cid}'/>">${time.dname }</a>
	<a href="<c:url value='/finddoctorbycid.action?cid=${department.cid}'/>">${time.assigntime}</a>
	<a href="<c:url value='/mkappiontment.action?usersid=${sessionScope.session_user.id }&docid=${time.pid }&assigntime=${time.assigntime}'/>">确定</a>
</div>
</c:forEach>

<c:forEach items="${timeList}" var="time">
<form action="${pageContext.request.contextPath }/mkappiontment.action">
<input type="hidden" name="usersname" value="${sessionScope.session_user.sname}"/>
<input type="hidden" name = "docname" value="${time.dname}"/>
<input type="text"   name="atime" value="<fmt:formatDate value="${time.assigntime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
<input type="submit" value="确定"/>

</form>

</c:forEach>
</body>
</html>
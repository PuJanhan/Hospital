<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form id ="LoginForm" action="">
 UserName : <input type="text" name="username">
 <br/>
 
 <div id="nmessage"></div>
 <br/>
 
 password : <input type="password" name="password">
 <br/>
 
 <div id="pmessage"></div>>
 <br/>
 
 <input type="button" id="submit1" name="tijiao" value="登录">
 
 <input type="button" id="submit2" name="tijiao" value="登录">
 
 <div id="error_msg"></div>
 <br/>
</form>
 
<script type="text/javascript">


$("#submit1").click(function(){
	
	var username = $(":text").val();
	var password = $(":password").val();
	
	
	
	$.ajax({
		
		type : "post",
	    url  : "${pageContext.request.contextPath}/registdemo.action",
	    dataType: 'json',
	    contentType : "application/json;charset=utf-8",
	    async: false,
	    data : '{"username":username,"password":password}',
	    success : function(backData,textStataus,ajax){
	    	
	    	$("#username").val("");
	    	$("#password").val("");
	    	alert(backData.usernameerro);
	    	alert(backData.passworderro);
	    	
	    	$("#nmessage").html(backData.usernameerro);
	    	$("#pmessage").html(backData.passworderro);
	    	
	    	
	    	
	    }
	    
		
		
		
	});
	
	
	
	
});


</script>




</body>
</html>
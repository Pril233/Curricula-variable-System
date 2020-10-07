<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="org.System.entity.*"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js" type="text/javascript"></script>
<meta charset="utf-8">
<title>Insert title here</title>
<link  type="text/css" rel="stylesheet" href = "css/SystemOfStudent.css"/>
<%
	Teacher teacher =(Teacher) session.getAttribute("teacher");
	
%>
</head>
<body>




 <div id="header">
<pre><h1>欢迎您!<%=teacher.getTname() %></h1></pre>
</div>

<div id="container">
<div id="nav"> 
	
	
<div id="div1">信息查询</div>
<div id="nav1">
	<ul >
		<li>
		<a href="http://localhost:8080/Curricula-variable_System/web/queryCourse/query.jsp" target="Frame">课程信息查询</a>
		</li>
		<li>
		<a href="">学生信息查询</a>
		</li>
		
	</ul>
</div>





		

	
<div id="div2">评分</div>
<div id="nav2">
	<ul>
		<li>
		<a href="http://localhost:8080/Curricula-variable_System/web/Score.IN" target="Frame" >课程评分</a>
		</li>
		

	</ul>
</div>	



<div id="div3">个人管理</div>
<div id="nav3">
	<ul>
		<li>
		<a href="" >个人及授课信息</a>
		</li>
		<li>
		<a href="">修改密码</a>
		</li>
		<li>
		<a href="">安全退出</a>
		</li>
	
	</ul>
</div>	











</div>  

<div id="section">
<iframe name="Frame" width=100% height=100% src="http://localhost:8080/Curricula-variable_System/Department/index.jsp"></iframe>

</div>
</div>

 <div id="footer">
https://www.zqu.edu.cn/
</div> 
 
<script type="text/javascript">
$("#nav1,#nav2,#nav3,#nav4").hide();

$("#div1").click(function(){
	$("#nav1").slideToggle();
	$("#nav2,#nav3,#nav4").slideUp();
	 
})

$("#div2").click(function(){
	$("#nav2").slideToggle();
	$("#nav1,#nav3,#nav4").slideUp();
})

$("#div3").click(function(){
	$("#nav3").slideToggle();
	$("#nav1,#nav2,#nav4").slideUp();
})




</script>
</body>
</html>
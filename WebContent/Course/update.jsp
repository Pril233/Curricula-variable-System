<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@page import="org.System.entity.*"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function check(){
		var cname = $("#cname").val();
		var ccredit = $("#ccredit").val();
		
		if(!(cname.length>1 && cname.length<11)){
			alert("请输入2~10位长度的课程名称");
			return false;
		}
		
		if(!(ccredit>1 && ccredit<6)){
			alert("学分范围为2~5分,请重新输入！");
			return false;
		}
		
		return true;
	}


</script>
<title>updateCourse</title>
</head>
<%
int cno = Integer.parseInt( request.getParameter("cno"));
List<Course> Courses = (List)request.getAttribute("Courses");
%>
<body>
<form action="updateCourseBycno.Go?cno=<%=cno %>" method="post" onsubmit="return check()">
	<p>请填写需要更改的课程的信息</p>
	课程Cno<input type="text" name="cno" id="cno" value=<%=cno %> disabled=true/><br/>
	课程名称<input type="text" name="cname" id="cname"/><br/>
	先行课Cpno
	
	<select name="cpno">
	<option  value="0">无</option>
	<%
	for(Course course:Courses){
		%>
		<option  value=<%=course.getCno() %> id="cpno"><%=course.getCno()+":"+course.getCname() %></option>	
		<%
	}
	%>
	</select><br/>
	
	课程学分<input type="text" name="ccredit" id="ccredit"/><br/>
	
	<input type="submit" value="提交"/><br/>
	<a href="queryCourseBypage.Go?currentPage=1"><input type="button" value="取消"/></a>


</form>
</body>
</html>
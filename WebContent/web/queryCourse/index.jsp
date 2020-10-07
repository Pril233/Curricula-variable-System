<%@page import="org.System.entity.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>CourseIndex</title>
<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
<script>
	function check(){
		var key = $("#key").val();
		var keyword = $("#keyword").val();
	
		
	if(key=="cno"){
		if(!(0<keyword)){
			alert("请输入正整数!");
			return false;
		}
	}
	
	}
	
	$(document).ready(function(){   
		 $("td:eq(4)",$("tr")).hide();   
		 $("th:eq(4)",$("tr")).hide(); 
	});
	

</script>
</head>

<body>
<%
int currentPage = -1;
int MaxPage=-1;
if(request.getParameter("pageIndex")!=null){
	currentPage = Integer.parseInt( request.getParameter("pageIndex"));
	MaxPage = (int)request.getAttribute("MaxPage");
	System.out.println("当前页数:"+currentPage);
}

%>






<%
List<Course> Courses = (List<Course>)request.getAttribute("Courses");
	if(Courses!=null){
		%>
		<table border="1px">
		<tr>
		<th>CNO</th>
		<th>CNAME</th>
		<th>CPNO</th>
		<th>CCREDIT</th>
		<th>操作</th>
		</tr>
		
		<% 
		for(Course course:Courses){
		%>
		<tr>
			<td><%=course.getCno() %></td>
			<td><%=course.getCname() %></td>
			<%
			if(course.getCpno()==0){
			%>
			<td>无</td>
			<% 
			}
			else{
			%>
			
			<td><%=course.getCpno() %></td>
			<%
			}
			%>
			<td><%=course.getCcredit() %></td>
			<td><a href="queryAllCourse.Go?cno=<%=course.getCno() %>">修改</a>&nbsp;&nbsp;
			<a href="deleteCourseBycno.Go?cno=<%=course.getCno() %>">删除</a></td>
		</tr>
		<%
		}
	}
		
		
	
%>		
</table>

<input type="button" value="上一页" onclick="location.href='queryCourseBypage.Go?currentPage=<%=currentPage-1 %>'"/>&nbsp;&nbsp; 

<input type="button" value="下一页" onclick="location.href='queryCourseBypage.Go?currentPage=<%=currentPage+1 %>'"/><br/>

<input type="button" value="返回" onclick="location.href='http://localhost:8080/Curricula-variable_System/web/queryCourse/query.jsp'"/>

<p>当前页数:<%=currentPage %>/<%=MaxPage %>   </p>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="org.System.entity.*"%>
    <%@page import="java.util.List"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Score</title>
</head>
<body>
<%
	Teacher teacher = (Teacher)session.getAttribute("teacher");
	List<TeaCourse> TeaCourses = (List<TeaCourse>)request.getAttribute("TeaCourses");
%>
<table border="1px" id="tb">
	<thead>	
		<tr>
		<th>CNO</th>
		<th>CNAME</th>
		<th>SNO</th>
		<th>SNAME</th>
		<th>GRADE</th>
		<th>操作</th>
		</tr>
	</thead>
	<% 
	for(TeaCourse teacourse:TeaCourses){
		%>
		<tbody>
				<tr>
				<td><%=teacourse.getCno() %></td>
				<td><%=teacourse.getCname() %></td>
				<td><%=teacourse.getSno() %></td>
				<td><%=teacourse.getSname()  %></td>
				<td><%=teacourse.getGrade()  %></td>
				<td><a href="javascript:location.href=encodeURI('Score/score.jsp?cno=<%=teacourse.getCno()%>&cname=<%=teacourse.getCname()%>&sno=<%=teacourse.getSno()%>&sname=<%=teacourse.getSname()%>')">评分</a></td>
				</tr>

		<% 
	}
%>
</tbody>
</table>
		





</body>
</html>
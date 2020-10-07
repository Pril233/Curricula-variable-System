<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="org.System.entity.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
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
<input type="button" value="查询全部" onclick="location.href='queryTeacherByPage.GO?currentPage=1'"/></br>
<%
	List<Teacher> Teachers = (List<Teacher>)request.getAttribute("Teachers");
	if(Teachers!=null){
		%>
		<table border="1px">
		<tr>
		<th>TNO</th>
		<th>TNAME</th>
		<th>TSEX</th>
		<th>TAGE</th>
		<th>TEB</th>
		<th>TPT</th>
		<th>CNO1</th>
		<th>CNO2</th>
		<th>CNO3</th>
		<th>操作</th>
		</tr>
		<%
		for(Teacher teacher:Teachers){
		%>
		<tr>
			<td><%=teacher.getTno() %></td>
			<td><%=teacher.getTname() %></td>
			<td><%=teacher.getTsex() %></td>
			<td><%=teacher.getTage() %></td>
			<td><%=teacher.getTeb() %></td>
			<td><%=teacher.getTpt() %></td>
			<td><%=teacher.getCno1() %></td>
			<td><%=teacher.getCno2() %></td>
			<td><%=teacher.getCno3() %></td>
			<td><a href="getCourses.GO?tno=<%=teacher.getTno()%>">修改</a>&nbsp; &nbsp;
			<a href="deleteTeacherBytno.GO?tno=<%=teacher.getTno() %>">删除</a></td>
			
		</tr>
		
		<% 	
		}
		
	}

%>
</table>
<input type="button" value="上一页" onclick="location.href='queryTeacherByPage.GO?currentPage=<%=currentPage-1 %>'"/>&nbsp;&nbsp; 

<input type="button" value="下一页" onclick="location.href='queryTeacherByPage.GO?currentPage=<%=currentPage+1 %>'"/>

<input type="button" value="添加" onclick="location.href='getCourses.GO?tno=0'"/>

<p>当前页数:<%=currentPage %>/<%=MaxPage %>   </p>

</body>
</html>
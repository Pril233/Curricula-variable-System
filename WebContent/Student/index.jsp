<%@page import="org.System.entity.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
<script>
	function check(){
		var key = $("#key").val();
		var keyword = $("#keyword").val();
	
		
	if(key=="sno"){
		if(!(0<keyword)){
			alert("请输入正整数!");
			return false;
		}
	}
	
	}
	

</script>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%

String result = (String)request.getAttribute("result");
if(result!=null){
	if(result.equals("addYES"))
		out.print("增加成功!");
	else if(result.equals("updateYES"))
		out.print("修改成功!");
	else
		out.print("操作失败!");
}

int currentPage = -1;
int MaxPage=-1;

if(request.getParameter("pageIndex")!=null){
	currentPage = Integer.parseInt( request.getParameter("pageIndex"));
	MaxPage = (int)request.getAttribute("MaxPage");
	System.out.println("当前页数:"+currentPage);
	
	
}


%>

<input type="button" value="查询全部" onclick="location.href='queryStudentBypage.Do?currentPage=1'"/></br> 

查找方式:
<form action="queryStudentByKey.Do" method="post" onsubmit="return check()">
<select name="key" id="key" >
<option value="sno">Sno</option>
<option value="sname">Sname</option>

</select>&nbsp;
</br>
关键字:</br>
<input type="text" name="keyword" id="keyword">
<input type="submit" value="查询">
</form>

<%List<Student> Students = (List<Student>)request.getAttribute("Students");
	if(Students!=null){
		%>
		<table border="1px">
		<tr>
		<th>SNO</th>
		<th>SNAME</th>
		<th>SSEX</th>
		<th>SAGE</th>
		<th>SDEPT</th>
		<th>操作</th>
		</tr>
		<% 
		for(Student student:Students){
		%>
		<tr>
			<td><%=student.getSno() %></td>
			<td><%=student.getSname() %></td>
			<td><%=student.getSsex() %></td>
			<td><%=student.getSage() %></td>
			<td><%=student.getSdept() %></td>
			<td><a href="getDepartmentNames.Do?sno=<%=student.getSno()%>">修改</a>&nbsp; &nbsp;
			<a href="deleteStudentBysno.Do?sno=<%=student.getSno()%>">删除</a></td>
			
		</tr>
		<%	
		}
	}

%>
</table>

<input type="button" value="上一页" onclick="location.href='queryStudentBypage.Do?currentPage=<%=currentPage-1 %>'"/>&nbsp;&nbsp; 

<input type="button" value="下一页" onclick="location.href='queryStudentBypage.Do?currentPage=<%=currentPage+1 %>'"/>

<input type="button" value="添加" onclick="location.href='getDepartmentNames.Do?sno=0'"/>

<p>当前页数:<%=currentPage %>/<%=MaxPage %>   </p>






</body>
</html>
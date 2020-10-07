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
		var queryString = $("#keyword").val();
		if(!(0<queryString)){
			alert("请输入要查询的关键词!");
			return false;
		}
	}
	

</script>

<meta charset="utf-8">
<title>index</title>
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


%>

<input name = "queryAllDepart" type = "button" value="查询全部" onclick="location.href='queryDepart.do'"/></br>

查找方式:
<form action="queryDepartBydno.do" method="post" onsubmit="return check()">
<select name="method" >
<option value="DNO">DepartmentNO</option>
<option value="Deptname">DepartmentName</option>
<option value="Deptmanager">DepartmentManager</option>
</select>&nbsp;
</br>
关键字:</br>
<input type="text" name="keyword" id="keyword">
<input type="submit" value="查询">
</form>



<table border="1px">
	<tr>
		<th>DepartmentNO</th>
		<th>DepartmentName</th>
		<th>DepartmentManager</th>
		<th>操作</th>
	</tr>



<%
	List<Department> Departments = (List<Department>)request.getAttribute("Departments");
	if(Departments!=null){
	for(Department department:Departments){
	
%>
	<tr>
		<td><%=department.getDno() %></td>
		<td><%=department.getDname() %></td>
		<td><%=department.getDmanager() %></td>
		<td><a href="update.jsp?deptno=<%=department.getDno() %>">修改</a>&nbsp; &nbsp;
			<a href="deleteDepart.do?deptno=<%=department.getDno() %>">删除</a>
		
		</td>
	</tr>
	
	<%
	}
	}
	
	%>
	</table>
		
	
</body>
</html>
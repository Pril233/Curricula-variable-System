<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function check(){
		var stuname = $("#stuname").val();
		var stuage = $("#stuage").val();
		var studept = $("#studept").val();
		
		if(!(stuname.length>1 && stuname.length<6)){
			alert("请输入2-5位长度的学生名称");
			return false;
		}
	 	
			if(!(stuage>11 && stuage<31)){
				alert("年龄限制为12到30岁,请重新输入");
				return false;
			}	
	
		

		return true;
		
	}
	
	$(document).ready(function(){
	});








</script>
<title>updateStudent</title>
</head>
<%
	
	int updatesno = Integer.parseInt( request.getParameter("sno"));

	
	List DepartmentNames = (List)request.getAttribute("DepartmentNames");

%>
<body>
<form action="updateStudent.Do?updatesno=<%=updatesno %>" method="post" onsubmit="return check()">
	<p>请填写需要更改的学生的信息</p>
	学生Sno<input type="text" name="sno" id="stusno" value=<%=updatesno %> disabled=true/><br/>
	学生名称<input type="text" name="sname" id="stuname"/><br/>
	学生性别
	<input type="radio"  name="ssex" value="男">男
	<input type="radio"  name="ssex" value="女">女
	<br/>
	学生年龄<input type="text" name="sage" id="stuage"/><br/>
	
	学生所属院系<br/>
				<select name="sdept">
					<%
						for(int i=0;i<DepartmentNames.size();i++){
							
					%>		
						<option value=<%=DepartmentNames.get(i) %>><%=DepartmentNames.get(i) %></option>
							
					<%		
						}

					%>
				
				</select>
				<br/>
	
	<input type="submit" value="提交"/><br/>
	<a href="queryStudentBypage.Do?currentPage=1"><input type="button" value="取消"/></a>

</form>

</body>
</html>
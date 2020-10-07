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
		var stusno = $("#stusno").val();
		var stuname = $("#stuname").val();
		var stuage = $("#stuage").val();
		
		 if(!(stusno>0 && stusno<1000001)){
			alert("请输入1~100000数字作为学号");
			return false;
		} 

		
		 if(!(stuname.length>1 && stuname.length<6)){
			alert("请输入2-5位长度的学生名称");
			return false;
		}
		
		if(!(stuage>11 && stuage<101)){
			alert("请输入12~100之间的年龄");
			return false;
		} 
		
		return true;
		
	}
	
	$(document).ready(function(){
	});
	
	

</script>
<title>addStudent</title>
</head>
<% 
	int scount = (int)request.getAttribute("scount");
	scount = scount + 1;
	List DepartmentNames = (List)request.getAttribute("DepartmentNames");

%>
<body>
<form action="addStudent.Do" method="post" onsubmit="return check()">
	<p>请填写需要增加的学生的信息</p>
	学生Sno<input type="text" name="sno" id="stusno"  value=<%=scount%>/><br/>
	学生名称<input type="text" name="sname" id="stuname" /><br/>
	
	<input type="radio"  name="ssex" value="男">男
	<input type="radio"  name="ssex" value="女">女
	<br/>
	学生年龄<input type="text" name="sage" id="stuage" /><br/>
	
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
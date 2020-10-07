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
		var tname = $("#tname").val();
		var tage = $("#tage").val();
		
		
		if(!(tname.length>1 && tname.length<6)){
			alert("请输入2-5位长度的教师名称");
			return false;
		}
	 	
			if(!(tage>19 && tage<101)){
				alert("年龄限制为20到100岁,请重新输入");
				return false;
			}	
	
		

		return true;
		
	}
	
	$(document).ready(function(){
	});








</script>
<title>update</title>
</head>
<%
	int tno = Integer.parseInt(request.getParameter("tno"));
	List<Course> Courses = (List<Course>)request.getAttribute("Courses");
	

%>
<body>
<form action="updateTeacher.GO?tno=<%=tno %>" method="post" onsubmit="return check()">
<p>请填写需要更改的教师的信息</p>
教师Tno<input type="text" name="tno" id="tno" value=<%=tno %> disabled=true/><br/>
教师名称<input type="text" name="tname" id="tname"/><br/>
教师性别
	<input type="radio"  name="tsex" value="男"  checked >男
	<input type="radio"  name="tsex" value="女">女
	<br/>
教师年龄<input type="text" name="tage" id="tage"/><br/>
教师学历
	<input type="radio"  name="teb" value="学士"   checked>学士
	<input type="radio"  name="teb" value="硕士">硕士
	<input type="radio"  name="teb" value="博士">博士
	<br/>
教师职称
	<input type="radio"  name="tpt" value="助教"   checked>助教
	<input type="radio"  name="tpt" value="讲师">讲师
	<input type="radio"  name="tpt" value="副教授">副教授
	<input type="radio"  name="tpt" value="教授">教授
	<br/>
主讲课程一
	<select name="cno1">
	<option value="0">无</option>
	<%
		for(int i=0;i<Courses.size();i++){
	%>
			<option value=<%=Courses.get(i).getCno() %>><%=Courses.get(i).getCno()+":"+ Courses.get(i).getCname() %></option>
		
	<% 	
		}
	
	%>
	</select><br/>
主讲课程二
	<select name="cno2">
 	<option value="0">无</option>
	<%
		for(int i=0;i<Courses.size();i++){
	%>
			<option value=<%=Courses.get(i).getCno() %>><%=Courses.get(i).getCno()+":"+ Courses.get(i).getCname() %></option>
		
	<% 	
		}
	
	%>
	</select><br/>
主讲课程三
	<select name="cno3">
	<option value="0">无</option>
	<%
		for(int i=0;i<Courses.size();i++){
	%>
			<option value=<%=Courses.get(i).getCno() %>><%=Courses.get(i).getCno()+":"+ Courses.get(i).getCname() %></option>
		
	<% 	
		}
	
	%>
	</select><br>




<input type="submit" value="提交"/><br/>
<a href="queryTeacherByPage.GO?currentPage=1"><input type="button" value="取消"/></a>
</form>
</body>
</html>
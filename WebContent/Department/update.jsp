<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
<script>
	function check(){
	
		
		var deptname = $("#deptname").val();
		var deptmanager = $("#deptmanager").val();
		
	
		
		if(!(deptname.length>1 && deptname.length<11)){
			alert("请输入2-10位长度的院系名称");
			return false;
		}
		
		if(!(deptmanager.length>1 && deptmanager.length<6)){
			alert("请输入2-5位长度的院长名称");
			return false;
		}
	
		return true;
	}
	
	

</script>
<title>updateDepart</title>
</head>
<%int updatedDno = Integer.parseInt( request.getParameter("deptno"));
System.out.println(updatedDno);%>

<body>
<form action="updateDepart.do?updatedDno=<%=updatedDno%>" method="post" onsubmit="return check()">
	<p>请填写需要更改的院系的信息</p>
	院系NO<input type="text"  name="deptno" id="deptno" value=<%=updatedDno %> disabled=true/><br/>
	院系名称<input type="text"  name="deptname" id="deptname"/><br/>
	院系主任<input type="text"  name="deptmanager" id="deptmanager"/><br/>
	<input type="submit" value="提交"  /><br/>
	<a href="queryDepart.do"><input type="button" value='取消'></a>
</form>

</body>
</html>
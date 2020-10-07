<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.System.entity.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Score</title>
</head>
<body>
<%
	int cno = Integer.parseInt(request.getParameter("cno"));
	String cname = (String)request.getParameter("cname");
	int sno = Integer.parseInt(request.getParameter("sno"));
	String sname = (String)request.getParameter("sname");
	
%>

<form action="Score.In" method="post" onsubmit="return check()">
	<p>请填写需要更改的课程的信息</p>
	CNO<input type="text" name="cno" id="cno" value=<%=cno %> readOnly/><br/>
	CNAME<input type="text" name="cname" id="cname" value=<%=cname %> readOnly><br/>
	SNO<input type="text" name="sno" id="sno" value=<%=sno%> readOnly/><br/>
	SNAME<input type="text" name="sname" id="sname" value=<%=sname %> readOnly/><br/>
	GRADE<input type="text" name="grade" id="grade"/><br/>
	
	<input type="submit" value="提交"/><br/>
	<a href="http://localhost:8080/Curricula-variable_System/web/Score.IN"><input type="button" value="取消"/></a>
</form>
</body>
</html>
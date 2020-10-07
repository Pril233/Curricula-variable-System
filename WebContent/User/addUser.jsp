<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="addUserServlet" onsubmit="return check()" method="get">
	<p>请填写需要添加的用户的信息</p>
	
	用户名称<input type="text"  name="username" id="username"/><br/>
	用户密码<input type="password"  name="passwrod" id="password"/><br/>
	确定用户密码<input type="password"  name="passwrod" id="password"/><br/>
	选择用户类型:</br>
	<input type="radio" name="usertype" value="教师">教师
	<input type="radio" name="usertype" value="学生">学生
	<input type="radio" name="usertype" value="管理员">管理员
	


	选择用户性别：</br>
	<input type="radio"  name="gender" value="男">男
	<input type="radio"  name="gender" value="女">女
	 
	
	<input type="submit" value="提交"  /><br/>
</form>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>增加学生</title>
</head>
<body>

	<form action="Add.action" method="post">
		姓&emsp;&emsp;名：<input type="text" name="name" /> <br> <br>
		年&emsp;&emsp;龄：<input type="text" name="age" /> <br> <br>
		学&emsp;&emsp;号：<input type="text" name="sno" /> <br> <br>
		性&emsp;&emsp;别:<input type="text" name="sex" /> <br> <br>
		手机号码:<input type="text" name="Tel" /> <br> <br>
		&emsp;&emsp;&emsp; <input type="submit" name="Add" value="增加学生" />
	</form>
	
</body>
</html>

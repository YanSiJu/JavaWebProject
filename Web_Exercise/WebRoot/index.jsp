<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>学生信息管理</title>






</head>

<body>

	<ul> <li><a href="AddStu.jsp" target="_blank">增加学生
	</a></li>
		<li><a href="Query.action" target="_blank">查看学生信息</a></li>
		<li><a href="DelStu.jsp" target="_blank">删除学生</a></li>
		<li>修改学生信息</li>
	</ul>
	
</body>
</html>

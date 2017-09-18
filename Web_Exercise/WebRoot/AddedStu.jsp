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

<title>增加的学生信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


</head>

<body>

	<br>
	<br> <br>姓&emsp;&emsp;名：<%=request.getParameter("name")%>
	<br>年&emsp;&emsp;龄：<%=request.getParameter("age")%>
	<br>
	<br>性&emsp;&emsp;别:<%=request.getParameter("sex")%>
	<br>
	<br>手机号码:<%=request.getParameter("Tel")%>
	<br>
	<br>学&emsp;&emsp;号：<%=request.getParameter("sno")%>

</body>
</html>

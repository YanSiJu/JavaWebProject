<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.qzdatasoft.javaweb.Jdbc_Connect"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'ShowInfo.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>

	<%
		Connection conn;
		conn = Jdbc_Connect.Connect();
		PreparedStatement ps = conn.prepareStatement("Select * from StudentInfo");
		ResultSet rs = ps.executeQuery();
		
		
	%>
	
	<table border="8">

		<tr>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>学号</th>
			<th>电话号码</th>
		</tr>

		<%
			

			while (rs.next()) {

			
		%>

		<tr>
			<th><%=rs.getString("name")%></th>
			<th><%=rs.getString("Sex")%></th>
			<th><%=rs.getInt("age")%></th>
			<th><%=rs.getString("Sno")%></th>
			<th><%=rs.getString("Tel")%></th>

		</tr>

		<%
			}
		%>

	</table>
</body>
</html>

package com.qzdatasoft.javaweb;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class StudentManagement {

	private static List<StudentInfo> students = new ArrayList<StudentInfo>();
	private Connection conn;
	private Statement stmt;
	private HttpServletRequest request;
	// private ServletContext context;

	public StudentManagement() {

		if (StudentManagement.students == null) {

			StudentManagement.students = new ArrayList<StudentInfo>();

		}

		this.request = ServletActionContext.getRequest();
		// this.context = (ServletContext) ServletActionContext.getContext();

		try {

			this.conn = Jdbc_Connect.Connect();
			this.stmt = conn.createStatement();

			String sql = "CREATE TABLE StudentInfo " + "(Sno varchar(14) not NULL, " + "name varchar(15),"
					+ "Sex varchar(18)," + "age INTEGER," + "Tel varchar(13)," + "PRIMARY KEY (Sno))";
			Jdbc_Connect.createTable(stmt, sql, "StudentInfo");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String addStu() {

		System.out.println("\n  Add Stu!!! \n  students:" + StudentManagement.students.hashCode() + "\n");

		String name = request.getParameter("name");
		Integer age = Integer.valueOf(request.getParameter("age"));
		String sex = request.getParameter("sex");
		String sno = request.getParameter("sno");
		String Tel = request.getParameter("Tel");

		StudentManagement.students.add(new StudentInfo(name, age, sno, sex, Tel));

		try {

			this.stmt.executeUpdate("Insert into StudentInfo values('" + sno + "','" + name + "','" + sex + "','" + age
					+ "','" + Tel + "')");
			System.out.println("\n插入数据成功！！\n");
		} catch (SQLException e) { // TODO Auto-generated catch block
			System.out.println("\n插入数据失败！！\n");
			e.printStackTrace();
		}

		return "success";

	}

	public String DelStu() {

		String sno = request.getParameter("sno");
		String sql = "Delete from StudentInfo Where Sno = ?";
		
		
		int result = Jdbc_Connect.DeleteData(conn, sql, sno); 
		if(result == 1){
			
			return "success";
			
		}else{
			
			return "failed"; // 删除学生信息失败，请核对您输入的信息并重新输入!!	
		}
		
		/*
		
		Iterator<StudentInfo> iter = StudentManagement.students.listIterator();
		while (iter.hasNext()) {

			StudentInfo stu = iter.next();
			String S = stu.getSno();
			if (S != null && S.equalsIgnoreCase(sno)) {
				//StudentManagement.students.remove(stu);
			}

		}
		*/

		

	}

	public static List<StudentInfo> getStudents() {
		return StudentManagement.students;
	}

	public void setStudents(List<StudentInfo> students) {
		StudentManagement.students = students;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}

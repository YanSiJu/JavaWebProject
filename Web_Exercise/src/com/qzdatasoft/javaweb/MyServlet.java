package com.qzdatasoft.javaweb;

import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.SQLException;
//import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	private StudentManagement studentsManage;
	// private

	public MyServlet() {

		super();
		// TODO Auto-generated constructor stub
		System.out.println("\n\nServlet's  Constructor\n\n");

	}

	@Override
	public void init() {

		this.studentsManage = new StudentManagement();
		System.out.println("Servlet  Init....\n  stuManage:" + this.studentsManage + "\n\n");

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served AT:
		// ").append(request.getContextPath());

		PrintWriter out = response.getWriter();
		out.println("<title> �鿴ѧ����Ϣ </title>");
		/*
		try {
			this.studentsManage.getStmt().execute("select *from StudentInfo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		/*
		 * Iterator<StudentInfo> iter =
		 * this.studentsManage.getStudents().iterator(); while (iter.hasNext())
		 * {
		 * 
		 * StudentInfo stu = iter.next();
		 * 
		 * out.println("<br>��&emsp;&emsp;����" + stu.getName() + "<br>");
		 * out.println("��&emsp;&emsp;��:" + stu.getSex() + "<br>");
		 * out.println("��&emsp;&emsp;�䣺" + stu.getAge() + "<br>");
		 * out.println("ѧ&emsp;&emsp;�ţ�" + stu.getSno() + "<br>");
		 * out.println("�ֻ�����:" + stu.getTel() + "<br>");
		 * 
		 * }
		 */
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		PrintWriter out = response.getWriter();

		// out.println("<br><br>method:"+request.getMethod());

		if ("����ѧ��".equalsIgnoreCase(request.getParameter("Add"))) { //

			out.println("<br>param:" + request.getParameter("Add"));
			String name = request.getParameter("name");
			Integer age = Integer.valueOf(request.getParameter("age"));

			String sex = request.getParameter("sex");
			String sno = request.getParameter("sno");
			String Tel = request.getParameter("Tel");

			out.println("<br>��&emsp;&emsp;����" + name + "<br>");
			out.println("��&emsp;&emsp;��:" + sex + "<br>");
			out.println("��&emsp;&emsp;�䣺" + age + "<br>");
			out.println("ѧ&emsp;&emsp;�ţ�" + sno + "<br>");
			out.println("�ֻ�����:" + Tel + "<br>");
			// this.studentsManage.addStu(name, sex, age, sno, Tel);
			out.println("<br>���ѧ����Ϣ�ɹ�!!");

		} else if ("ɾ��ѧ��".equalsIgnoreCase(request.getParameter("Delete"))) { //

			String sno = request.getParameter("sno");
			out.println("<br>param:" + request.getParameter("Delete"));
			out.println("<br>ѧ&emsp;&emsp;�ţ�" + sno + "<br>");

			// out.println("<br>" + this.studentsManage.DelStu(sno));

		}

		out.flush();
		out.close();
	}

}

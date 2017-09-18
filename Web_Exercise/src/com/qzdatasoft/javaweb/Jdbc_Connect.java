package com.qzdatasoft.javaweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Jdbc_Connect {

	public static Connection Connect() {

		try {

			Connection conn = null;
			// Statement stmt = null;

			// 调用Class.forName()方法加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载MySQL驱动！");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
			// stmt = conn.createStatement(); // 创建Statement对象

			System.out.println("成功连接到数据库!!\nConn:" + conn);
			return conn;

		} catch (Exception e) {
			System.out.println("\n连接失败!!\n");
			e.printStackTrace();
			return null;
		}
	}

	// true:不存在
	public static boolean validateTableExist(Statement stmt, String tableName) {
		// 定义一个变量标示
		boolean flag = true;
		// 一个查询该表所有的语句。
		String sql = "SELECT COUNT(*) FROM " + tableName;
		// 获取连接

		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
			flag = false;

		} catch (Exception e) {
			// 该表不存在，则 会跳入catch中
			System.out.println("\n正在创建表....\n");

		} finally {
			// 关闭所有连接
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return flag;
	}

	public static int DeleteData(Connection conn, String sql, String sno) {

		PreparedStatement ps = null;
		int result;
		try {

			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			result = ps.executeUpdate();
			return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return 0;
			
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public static void createTable(Statement stmt, String sql, String tableName) {

		System.out.println("\nCreate table!!");
		try {
			// DatabaseMetaData metaData = stmt.getConnection().getMetaData();
			if (Jdbc_Connect.validateTableExist(stmt, tableName)) {

				stmt.executeUpdate(sql);
				System.out.println("\n  已创建表!!\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

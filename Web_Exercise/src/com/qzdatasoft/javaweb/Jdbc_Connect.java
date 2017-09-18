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

			// ����Class.forName()����������������
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("�ɹ�����MySQL������");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
			// stmt = conn.createStatement(); // ����Statement����

			System.out.println("�ɹ����ӵ����ݿ�!!\nConn:" + conn);
			return conn;

		} catch (Exception e) {
			System.out.println("\n����ʧ��!!\n");
			e.printStackTrace();
			return null;
		}
	}

	// true:������
	public static boolean validateTableExist(Statement stmt, String tableName) {
		// ����һ��������ʾ
		boolean flag = true;
		// һ����ѯ�ñ����е���䡣
		String sql = "SELECT COUNT(*) FROM " + tableName;
		// ��ȡ����

		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
			flag = false;

		} catch (Exception e) {
			// �ñ����ڣ��� ������catch��
			System.out.println("\n���ڴ�����....\n");

		} finally {
			// �ر���������
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
				System.out.println("\n  �Ѵ�����!!\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

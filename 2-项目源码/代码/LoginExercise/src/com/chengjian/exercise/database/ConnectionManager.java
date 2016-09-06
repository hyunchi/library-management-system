package com.chengjian.exercise.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	// ����1����ȡһ����Ч�����ݿ����Ӷ���
	public Connection openConnection() {
		try {
			// ������������
			Class.forName("com.mysql.jdbc.Driver");
			// �������ݿ����Ӳ���
			String account = "root";
			String password = "1";
			String url = "jdbc:mysql://127.0.0.1:3306/mydb";
			// ʹ��DriverManager��ȡһ����Ч����
			Connection connection = DriverManager.getConnection(url, account,
					password);
			System.out.println("��Ϣ���ɹ���ȡһ����Ч�����ݿ����Ӷ��󡭡�");
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// ����2���ر�һ����Ч�����ݿ����Ӷ���
	public void closeConnection(final Connection connection) {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("��Ϣ�������ر�һ����Ч�����ݿ����Ӷ��󡭡�");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

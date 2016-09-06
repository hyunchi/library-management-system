package com.chengjian.exercise.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chengjian.exercise.database.ConnectionManager;
import com.chengjian.exercise.database.SQLManager;
import com.chengjian.exercise.database.TransactionManager;

public class Test2 {

	public static void main(String[] args) {
		// ��ѯ����
		// ����1����ȡһ����Ч�����ݿ�����
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();

		// ����2������SQL�������ݲ���
		String strSQL = "select * from userinfor order by uid ";
		Object[] params = new Object[] {};

		// ����3������SQL���
		SQLManager sqlManager = new SQLManager();
		ResultSet rs = sqlManager.executeRead(connection, strSQL, params);

		try {
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t"
						+ rs.getString(3) + "\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ����4���ر�һ����Ч�����ݿ�����
		connectionManager.closeConnection(connection);

	}

}

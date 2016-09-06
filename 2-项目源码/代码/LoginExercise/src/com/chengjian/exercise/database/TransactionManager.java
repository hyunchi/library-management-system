package com.chengjian.exercise.database;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {

	// ����1����������
	public void beginTransaction(final Connection connection) {
		if (connection != null) {
			try {
				connection.setAutoCommit(false);
				System.out.println("��Ϣ���������񡭡�");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// ����2���ύ����
	public void commitTransaction(final Connection connection) {
		if (connection != null) {
			try {
				connection.commit();
				System.out.println("��Ϣ���ύ���񡭡�");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// ����3���ع�����
	public void rollbackTransaction(final Connection connection) {
		if (connection != null) {
			try {
				connection.rollback();
				System.out.println("��Ϣ���ع����񡭡�");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

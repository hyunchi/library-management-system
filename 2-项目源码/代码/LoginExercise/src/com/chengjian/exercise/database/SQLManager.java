package com.chengjian.exercise.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLManager {

	// ����1������ִ�����ݿ��д��������ɾ�ģ�
	// insert into ������ values(null, ��, ��, ....);
	public int executeWrite(final Connection connection, final String strSQL,
			final Object... params) {
		try {
			System.out.println("SQL:> " + strSQL);
			PreparedStatement pstmt = connection.prepareStatement(strSQL);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			int affectedRows = pstmt.executeUpdate();
			return affectedRows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

	}

	// ����2������ִ�����ݿ�Ķ���������ѯ��
	public ResultSet executeRead(final Connection connection,
			final String strSQL, final Object... params) {
		try {
			System.out.println("SQL:> " + strSQL);
			PreparedStatement pstmt = connection.prepareStatement(strSQL);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			ResultSet rs = pstmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}

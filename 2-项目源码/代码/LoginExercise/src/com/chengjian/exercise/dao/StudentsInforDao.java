package com.chengjian.exercise.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.chengjian.exercise.database.ConnectionManager;
import com.chengjian.exercise.database.SQLManager;
import com.chengjian.exercise.database.TransactionManager;
import com.chengjian.exercise.login.FrmBookQuery;

public class StudentsInforDao {
	public void selectAll(final DefaultTableModel dm){
		// ����1����ȡһ����Ч�����ݿ�����
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();

		// ����2������SQL�������ݲ���
		String strSQL = "select * from studentsinfor order by stuid";
		Object[] params = new Object[] {};

		// ����3������SQL���
		SQLManager sqlManager = new SQLManager();
		ResultSet rs = sqlManager.executeRead(connection, strSQL, params);

		try {
			while (rs.next()) {
				Vector rowData=new Vector();
				rowData.add(rs.getInt(1));
				rowData.add(rs.getString(2));
				rowData.add(rs.getString(3));
				rowData.add(rs.getInt(4));
				rowData.add(rs.getString(5));
				rowData.add(rs.getInt(6));
				rowData.add(rs.getInt(7));
				dm.addRow(rowData);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ����4���ر�һ����Ч�����ݿ�����
		connectionManager.closeConnection(connection);

	}
	//��ѯ
		public void selectOther(final DefaultTableModel dm,final String strSQL,final Object...params){
			// ����1����ȡһ����Ч�����ݿ�����
			ConnectionManager connectionManager = new ConnectionManager();
			Connection connection = connectionManager.openConnection();
			
			FrmBookQuery frm=new FrmBookQuery();
			String a=frm.getTxtQuery();
			// ����3������SQL���
			SQLManager sqlManager = new SQLManager();
			ResultSet rs = sqlManager.executeRead(connection, strSQL, params);

			try {
				while (rs.next()) {
					Vector rowData=new Vector();
					rowData.add(rs.getInt(1));
					rowData.add(rs.getString(2));
					rowData.add(rs.getString(3));
					rowData.add(rs.getInt(4));
					rowData.add(rs.getString(5));
					rowData.add(rs.getInt(6));
					rowData.add(rs.getInt(7));
					dm.addRow(rowData);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// ����4���ر�һ����Ч�����ݿ�����
			connectionManager.closeConnection(connection);

		}
	public int insert(final String strSQL,final Object...params){
		// ����1����ȡһ����Ч�����ݿ�����
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();

		// ����2������һ��������ֻ��д������ʱ��ʹ������
		TransactionManager transactionManager = new TransactionManager();
		transactionManager.beginTransaction(connection);

		// ����3������SQL���
		SQLManager sqlManager = new SQLManager();
		int res = sqlManager.executeWrite(connection, strSQL, params);

		// ����4���������ݿ�ִ�н���ύ��ع�����
		if (res > 0) {
			transactionManager.commitTransaction(connection);
		} else {
			transactionManager.rollbackTransaction(connection);
		}
	
		// ����5���ر�һ����Ч�����ݿ�����
		connectionManager.closeConnection(connection);
		return res;
	
}
	

}

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

public class BookInforDao {
	public void selectAll(final DefaultTableModel dm){
			// ����1����ȡһ����Ч�����ݿ�����
			ConnectionManager connectionManager = new ConnectionManager();
			Connection connection = connectionManager.openConnection();

			// ����2������SQL�������ݲ���
			String strSQL = "select * from bookinfor order by id";
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
					rowData.add(rs.getString(4));
					rowData.add(rs.getString(5));
					rowData.add(rs.getInt(6));
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
				rowData.add(rs.getString(4));
				rowData.add(rs.getString(5));
				rowData.add(rs.getInt(6));
				dm.addRow(rowData);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ����4���ر�һ����Ч�����ݿ�����
		connectionManager.closeConnection(connection);

	}
		//��ɶ�Bookinfor���ݱ����Ӳ���
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
		//�޸�1����
		public String[] update(final String strSQL,final Object...params){
			String []uper=new String[5]; 
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
					//Vector rowData=new Vector();
					uper[0]=rs.getString(2);
					uper[1]=rs.getString(3);
					uper[2]=rs.getString(4);
					uper[3]=rs.getString(5);
					uper[4]=rs.getString(6);
					//dm.addRow(rowData);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// ����4���ر�һ����Ч�����ݿ�����
			connectionManager.closeConnection(connection);
			return uper;
		}
		//��ɶ�Bookinfor���ݱ��update2����
		public int xiugai(final String strSQL,final Object...params){
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
		
		//ɾ������
		public int delete(final String strSQL,final Object...params){
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

	public boolean delete(final int bid) {
		// ����1����ȡһ����Ч�����ݿ�����
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();

		// ����2������һ��������ֻ��д������ʱ��ʹ������
		TransactionManager transactionManager = new TransactionManager();
		transactionManager.beginTransaction(connection);

		// ����3������SQL���
		SQLManager sqlManager = new SQLManager();
		String strSQL="delete from bookinfor where id=?";
		Object[] params=new Object[]{bid};
		int res = sqlManager.executeWrite(connection, strSQL, params);

		// ����4���������ݿ�ִ�н���ύ��ع�����
		if (res > 0) {
			transactionManager.commitTransaction(connection);
			connectionManager.closeConnection(connection);
			return true;
		} else {
			transactionManager.rollbackTransaction(connection);
			connectionManager.closeConnection(connection);
			return false;
		}
	}
}

package com.chengjian.exercise.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chengjian.exercise.database.ConnectionManager;
import com.chengjian.exercise.database.SQLManager;
import com.chengjian.exercise.database.TransactionManager;

public class UserInforDao {
	public String Power(final String account){
		String getPower=null;
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();
		
		String strSQL = "select * from userinfor where account=?";
		Object[] params = new Object[]{account};
		
		SQLManager sqlManager = new SQLManager();
		ResultSet rs = sqlManager.executeRead(connection, strSQL, params);
		
		try {
			while(rs.next()){

				if (account.equals(rs.getString(2))){
					getPower = rs.getString(6);

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally{
			connectionManager.closeConnection(connection);
		}
		return getPower ;
	}
	
	//��ɶ�Userinfor���ݱ����Ӳ���
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
	
	public int update(final String strSQL,final Object...params){
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
	
	//��ɶ�Userinfor���ݱ�ĵ�¼��֤����
	public Boolean isLogin(final String account,final String password){
		
		
		// ����1����ȡһ����Ч�����ݿ�����
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();

		// ����2������SQL�������ݲ���
		String strSQL = "select count(*) from userinfor where account=? and pass=?";
		Object[] params = new Object[] {account,password};

		// ����3������SQL���
		SQLManager sqlManager = new SQLManager();
		ResultSet rs = sqlManager.executeRead(connection, strSQL, params);

		try {
			if(rs.next()) {
				int res=rs.getInt(1);
				return res>0?true:false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally{
		// ����4���ر�һ����Ч�����ݿ�����
		connectionManager.closeConnection(connection);
		}
			return null;
	}
	
	}

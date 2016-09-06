package com.chengjian.exercise.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.chengjian.exercise.dao.UserInforDao;

public class FrmUpPassword extends JFrame implements ActionListener {
	private String ccc;
	private JPanel loginPanel,buttonPanel;
	//����GUI���
	private JLabel lblAccount,lblOldPassword,lblPassword,lblEnPassword;
	private JTextField txtAccount;
	private JPasswordField txtOldPassword,txtPassword,txtEnPassword;
	private JButton btnRegister,btnLogin;
	public FrmUpPassword(String ccc) {
		
		super();
		this.ccc=ccc;
		//���ô����С
		this.setSize(new Dimension(350,280));
		//���ô������
		this.setTitle("�޸����봰��");
		//���ô��������ʾ
		this.setLocationRelativeTo(this);
		//���ô�����󻯰�ť
		this.setResizable(false);
		//���ô���رմ��ڽ��̵Ĳ���
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//����Ż���ʹ��UIManager�����ͨ�����ͳһ����
		Font font=new Font("����",Font.PLAIN,12);
		//ͳһ��ǩ����
		UIManager.put("JLabel.font", font);
		//ͳһ��ť����
		UIManager.put("JButton.font",font);
		//���ô����Ĭ����������Ĳ���ģʽΪnull
		this.getContentPane().setLayout(null);
		//ʵ����loginPanel��������������壩
		this.loginPanel=new JPanel();
		this.loginPanel.setLayout(null);
		this.loginPanel.setBounds(new Rectangle(0,0,350,180));
		this.loginPanel.setBackground(Color.white);
		this.getContentPane().add(loginPanel);
		//ʵ����buttonPanel��������������壩
		this.buttonPanel=new JPanel();
		this.buttonPanel.setLayout(null);
		this.buttonPanel.setBounds(new Rectangle(0,180,350,70));
		this.getContentPane().add(buttonPanel);
		//ΪloginPanel����������
//		this.lblAccount=new JLabel("�û�����");
//		this.lblAccount.setBounds(new Rectangle(60, 20, 69,30));
//		this.loginPanel.add(this.lblAccount);
		
		this.lblOldPassword=new JLabel("�����룺");
		this.lblOldPassword.setBounds(new Rectangle(60, 30,69,30));
		this.loginPanel.add(this.lblOldPassword);
		
		this.lblPassword=new JLabel("�����룺");
		this.lblPassword.setBounds(new Rectangle(60, 80,69,30));
		this.loginPanel.add(this.lblPassword);
		
		this.lblEnPassword=new JLabel("ȷ�����룺");
		this.lblEnPassword.setBounds(new Rectangle(60, 130,69,30));
		this.loginPanel.add(this.lblEnPassword);
		
//		this.txtAccount=new JTextField();
//		this.txtAccount.setBounds(new Rectangle(135,20,150,30));
//		this.loginPanel.add(this.txtAccount);
		
		this.txtOldPassword=new JPasswordField();
		this.txtOldPassword.setBounds(new Rectangle(135,30,150,30));
		this.loginPanel.add(this.txtOldPassword);
		
		this.txtPassword=new JPasswordField();
		this.txtPassword.setBounds(new Rectangle(135,80,150,30));
		this.loginPanel.add(this.txtPassword);
		
		this.txtEnPassword=new JPasswordField();
		this.txtEnPassword.setBounds(new Rectangle(135,130,150,30));
		this.loginPanel.add(this.txtEnPassword);
		
		//ΪbuttonPanel����������
		this.btnRegister=new JButton("ȷ��");
		this.btnRegister.setBounds(new Rectangle(55,18,100,30));
		this.btnRegister.addActionListener(this);
		this.buttonPanel.add(this.btnRegister);
		
		this.btnLogin=new JButton("ȡ��");
		this.btnLogin.setBounds(new Rectangle(195,18,100,30));
		this.btnLogin.addActionListener(this);
		this.buttonPanel.add(this.btnLogin);
	
		
	}
	public  String getCcc(){
		return this.ccc;
	}
	
	public void actionPerformed(ActionEvent e) {
		String com=e.getActionCommand();
		if(com.equals("ȡ��")){
			
			this.setVisible(false);
		}
		if(com.equals("ȷ��")){
		
			String acc=this.getCcc();
			System.out.print(ccc);
			String pass=txtPassword.getText().trim();
			//��ͼ�����Dao��ʵ��ҵ�����
		    UserInforDao userInforDao=new UserInforDao();
			String strSQL="update userinfor set pass=? where account=?";
			Object[] params=new Object[]{pass,acc};	
			int res=userInforDao.insert(strSQL, params);
			String message=res>0?"��ϲ���޸ĳɹ���" : "�Բ����޸�ʧ�ܣ�����ϵ����Ա...";
			JOptionPane.showMessageDialog(this, message, "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false);
//			FrmLogin frm1=new FrmLogin();
//			frm1.setVisible(true);
		}
	}
//public static void main(String[] args) {
//	
//	FrmUpPassword frm=new FrmUpPassword();
//	frm.setVisible(true);
//}
	
}

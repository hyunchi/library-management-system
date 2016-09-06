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

/**
 * ���ߣ���׳ 
 * ���ڣ�2015-01-05 13:16 
 * ���ƣ�FrmLogin 
 * ���ܣ�ϵͳ��¼���� ����޸�ʱ�䣺2015-01-05 13:16
 * */
public class FrmLogin extends JFrame implements ActionListener {
	// ��������Panel������
	private JPanel loginPanel, buttonPanel;
	private String account;
	// ����GUI���
	private JLabel lblAccount, lblPassword;
	private JTextField txtAccount;
	private JPasswordField txtPassword;
	private JButton btnRegister, btnLogin;

	public FrmLogin() {
		super();
		// ���ô����С
		this.setSize(new Dimension(350, 200));
		// ���ô������
		this.setTitle("ͼ�����ϵͳv1.0");
		// ���ô��������ʾ
		this.setLocationRelativeTo(this);
		// ���ô�����󻯰�ť
		this.setResizable(false);
		// ���ô���رմ��ڽ��̵Ĳ���
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ����Ż���ʹ��UIManager�����ͨ�����ͳһ����
		Font font = new Font("����", Font.PLAIN, 12);
		// ͳһ��ǩ����
		UIManager.put("JLabel.font", font);
		// ͳһ��ť����
		UIManager.put("JButton.font", font);
		// ���ô����Ĭ����������Ĳ���ģʽΪnull
		this.getContentPane().setLayout(null);
		// ʵ����loginPanel��������������壩
		this.loginPanel = new JPanel();
		this.loginPanel.setLayout(null);
		this.loginPanel.setBounds(new Rectangle(0, 0, 350, 110));
		this.loginPanel.setBackground(Color.white);
		this.getContentPane().add(loginPanel);
		// ʵ����buttonPanel��������������壩
		this.buttonPanel = new JPanel();
		this.buttonPanel.setLayout(null);
		this.buttonPanel.setBounds(new Rectangle(0, 110, 350, 90));
		this.getContentPane().add(buttonPanel);
		// ΪloginPanel����������
		this.lblAccount = new JLabel("��¼�ʺţ�");
		this.lblAccount.setBounds(new Rectangle(60, 20, 69, 30));
		this.loginPanel.add(this.lblAccount);

		this.lblPassword = new JLabel("��¼���룺");
		this.lblPassword.setBounds(new Rectangle(60, 60, 69, 30));
		this.loginPanel.add(this.lblPassword);

		this.txtAccount = new JTextField();
		this.txtAccount.setBounds(new Rectangle(135, 20, 150, 30));
		this.loginPanel.add(this.txtAccount);

		this.txtPassword = new JPasswordField();
		this.txtPassword.setBounds(new Rectangle(135, 60, 150, 30));
		this.loginPanel.add(this.txtPassword);
		// ΪbuttonPanel����������
		this.btnRegister = new JButton("����ע��");
		this.btnRegister.setBounds(new Rectangle(55, 18, 100, 30));
		this.btnRegister.addActionListener(this);
		this.buttonPanel.add(this.btnRegister);

		this.btnLogin = new JButton("���ϵ�¼");
		this.btnLogin.setBounds(new Rectangle(195, 18, 100, 30));
		this.btnLogin.addActionListener(this);
		this.buttonPanel.add(this.btnLogin);

	}
	public void setAccount(String aa){
		this.account=aa;
	}
	
	public String getAccount(){
	
	return this.account;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="����ע��"){
			//�����Ի���MessageDialog
			FrmRegister frm1=new FrmRegister();
			frm1.setVisible(true);
			this.setVisible(false);
			//JOptionPane.showMessageDialog(this, "�������ע�ᰴť", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getActionCommand()=="���ϵ�¼"){
			String account=this.txtAccount.getText().trim();
			String password=this.txtPassword.getText().trim();
			if((account==null||account.length()==0)||(password==null||password.length()==0)){
				JOptionPane.showMessageDialog(this, "�˺Ż����벻��Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
			}
		
			else{
				
				 UserInforDao userInforDao=new UserInforDao();
			
				boolean flag= userInforDao.isLogin(account,password);
				if(flag){
					JOptionPane.showConfirmDialog(this, "��ӭ��½,"+account,"��ʾ",JOptionPane.ERROR_MESSAGE);
					String getpower=userInforDao.Power(account);
					if(getpower.equals("����Ա")){
					MainFrm frmMain = new MainFrm(account);
					frmMain.setVisible(true);
					this.setVisible(false);
					}
					else{
						MainFrmUser frmMain = new MainFrmUser(account);
						frmMain.setVisible(true);
						this.setVisible(false);
					}
				}
				//��ͼ�����Dao��ʵ��ҵ�����
				else{
				JOptionPane.showMessageDialog(this,"�˺��������","�e�`��",JOptionPane.ERROR_MESSAGE);}
				this.txtAccount.setText("");
				this.txtPassword.setText("");
				this.txtAccount.requestFocus();
			}
		}
	}
	public static void main(String[] args) {

		FrmLogin frm = new FrmLogin();
		frm.setVisible(true);
	}
}

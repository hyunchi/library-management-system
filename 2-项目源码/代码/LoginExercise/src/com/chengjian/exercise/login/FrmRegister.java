package com.chengjian.exercise.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.chengjian.exercise.dao.UserInforDao;

public class FrmRegister extends JFrame implements ActionListener {
	//��������
	private JPanel titlePanel,loginPanel,personalPanel,buttonPanel;
	private JLabel lblTitle,lblInformation,lblAccount,lblPassword,
	lblEnsurePassw,lblHint1,lblHint2,lblHint3,lblHint4,lblHint5,
	lblName,lblEmail,lbltype;
	private JComboBox comType;
	private JTextField txtAccount,txtName,txtEmail;
	private JPasswordField txtPassword,txtEnsurePasseord;
	private JButton btnRegister,btnReturn;
	public FrmRegister(){
		this.setSize(new Dimension(600,750));
		this.setTitle("ͼ�����ϵv1.0");
		this.setLocationRelativeTo(this);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Font font=new Font("΢���ź�",Font.PLAIN,12);
		UIManager.put("JLabel.font", font);
		
		
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(Color.white);
		//����titlePanel��������
		this.titlePanel=new JPanel();
		this.titlePanel.setBounds(new Rectangle(30,30,540,110));
		this.titlePanel.setLayout(null);
		this.titlePanel.setBackground(Color.white);
		this.getContentPane().add(this.titlePanel);
		//ΪtitlePanel����������
		this.lblTitle=new JLabel("���û�ע��");
		this.lblTitle.setFont(new Font("����",Font.BOLD,18));
		this.lblTitle.setBounds(new Rectangle(0, 10, 100,40));
		this.titlePanel.add(this.lblTitle);
				
		this.lblInformation=new JLabel("�û�ע����Ҫ��д���˻����˻���Ϣ�Լ�������Ϣ���밴����ʾҪ����ȷ��д��");
		this.lblInformation.setBounds(new Rectangle(0, 50,480,20));
		this.titlePanel.add(this.lblInformation);
		
		//����loginPanel��¼��Ϣ����
		this.loginPanel=new JPanel();
		this.loginPanel.setBounds(new Rectangle(30,140,540,180));
		this.loginPanel.setBorder(BorderFactory.createTitledBorder(null,"�˻���Ϣ",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION));
		this.loginPanel.setLayout(null);
		this.loginPanel.setBackground(Color.white);
		this.getContentPane().add(this.loginPanel);
		
		//ΪloginPanel����������
		this.lblAccount=new JLabel("��¼�ʺţ�");
		this.lblAccount.setBounds(new Rectangle(20, 30, 80,30));
		this.loginPanel.add(this.lblAccount);
		
		this.txtAccount=new JTextField();
		this.txtAccount.setBounds(new Rectangle(100,30,150,30));
		this.loginPanel.add(this.txtAccount);
		
		this.lblHint1=new JLabel("������ĸ���»������");
		this.lblHint1.setBounds(new Rectangle(270, 30, 180,30));
		this.loginPanel.add(this.lblHint1);
		
		this.lblPassword=new JLabel("��¼���룺");
		this.lblPassword.setBounds(new Rectangle(20, 80, 80,30));
		this.loginPanel.add(this.lblPassword);
		
		this.txtPassword=new JPasswordField();
		this.txtPassword.setBounds(new Rectangle(100,80,150,30));
		this.loginPanel.add(this.txtPassword);
		
		this.lblHint2=new JLabel("���벻������λ��������ĸ���»������");
		this.lblHint2.setBounds(new Rectangle(270, 80, 280,30));
		this.loginPanel.add(this.lblHint2);
		
		this.lblEnsurePassw=new JLabel("����ȷ�ϣ�");
		this.lblEnsurePassw.setBounds(new Rectangle(20, 130, 80,30));
		this.loginPanel.add(this.lblEnsurePassw);
		
		this.txtEnsurePasseord=new JPasswordField();
		this.txtEnsurePasseord.setBounds(new Rectangle(100,130,150,30));
		this.loginPanel.add(this.txtEnsurePasseord);
		
		this.lblHint3=new JLabel("�������뱣��һ��");
		this.lblHint3.setBounds(new Rectangle(270, 130, 280,30));
		this.loginPanel.add(this.lblHint3);
		
		
		
		//����personalPanel������Ϣ����
		this.personalPanel=new JPanel();
		this.personalPanel.setBounds(new Rectangle(30,320,540,220));
		this.personalPanel.setBorder(BorderFactory.createTitledBorder(null,"������Ϣ",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION));
		this.personalPanel.setLayout(null);
		this.personalPanel.setBackground(Color.white);
		this.getContentPane().add(this.personalPanel);
		//ΪpersonalPanel����������
		this.lblName=new JLabel("��ʵ������");
		this.lblName.setBounds(new Rectangle(20, 50, 80,30));
		this.personalPanel.add(this.lblName);
				
		this.txtName=new JTextField();
		this.txtName.setBounds(new Rectangle(100,50,150,30));
		this.personalPanel.add(this.txtName);
				
		this.lblHint4=new JLabel("��д��ʵ�ĸ�������");
		this.lblHint4.setBounds(new Rectangle(270, 50, 180,30));
		this.personalPanel.add(this.lblHint4);
		
		this.lblEmail=new JLabel("�������䣺");
		this.lblEmail.setBounds(new Rectangle(20, 100, 80,30));
		this.personalPanel.add(this.lblEmail);
				
		this.txtEmail=new JTextField();
		this.txtEmail.setBounds(new Rectangle(100,100,150,30));
		this.personalPanel.add(this.txtEmail);
				
		this.lblHint5=new JLabel("�밴��������������д��������@���ַ�");
		this.lblHint5.setBounds(new Rectangle(270, 100, 280,30));
		this.personalPanel.add(this.lblHint5);
		
		this.lbltype=new JLabel("��ѡ��ע�����ͣ�");
		this.lbltype.setBounds(new Rectangle(20, 150, 120,30));
		this.personalPanel.add(this.lbltype);
		
		String []tt=new String[]{"��ͨ�û�"};
		this.comType=new JComboBox(tt);
		this.comType.setBounds(new Rectangle(130, 150, 80,30));
		this.personalPanel.add(this.comType);
		
		//����buttonPanel��ť����
		this.buttonPanel=new JPanel();
		this.buttonPanel.setBounds(new Rectangle(30,560,540,90));
		this.buttonPanel.setLayout(null);
		this.buttonPanel.setBackground(Color.white);
		this.getContentPane().add(this.buttonPanel);
		//ΪbuttonPanel����������
		this.btnRegister=new JButton("����ע��");
		this.btnRegister.setBounds(new Rectangle(320,30,100,30));
		this.btnRegister.addActionListener(this);
		this.buttonPanel.add(this.btnRegister);
				
		this.btnReturn=new JButton("����");
		this.btnReturn.setBounds(new Rectangle(430,30,100,30));
		this.btnReturn.addActionListener(this);
		this.buttonPanel.add(this.btnReturn);
	}
	
//	private AbstractButton titlePanel() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String com=e.getActionCommand();
		if(com=="����"){
			this.setVisible(false);
			FrmLogin frm1=new FrmLogin();
			frm1.setVisible(true);
			//�����Ի���MessageDialog
			
			//JOptionPane.showMessageDialog(this, "�������ע�ᰴť", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
		}
		String tpe=(String) this.comType.getSelectedItem();
		String account = this.txtAccount.getText().trim();
		String name = this.txtName.getText().trim();
		String mail = this.txtEmail.getText().trim();
		String password = this.txtPassword.getText().trim();
		String enPassword = this.txtEnsurePasseord.getText().trim();
		 String reg = "[\\w]+@[\\w]+.[\\w]+";
		if(com=="����ע��"){
//			txtAccount,txtName,txtEmail;
//			private JPasswordField txtPassword,txtEnsurePasseord;
			
			
			
			if((account == null|| account.length()==0)||(name == null|| name.length()==0)||
					(mail == null|| mail.length()==0)||(password == null|| password.length()==0)||
					(enPassword == null|| enPassword.length()==0)){
				JOptionPane.showMessageDialog(this, "������Ϣδ��д", "����", JOptionPane.WARNING_MESSAGE);
			}
			else if(password.length()<6){
				JOptionPane.showMessageDialog(this, "���벻��������λ��", "����", JOptionPane.WARNING_MESSAGE);
			}
			else if(!password.equals(enPassword)){
				JOptionPane.showMessageDialog(this, "�������벻һ��", "����", JOptionPane.WARNING_MESSAGE);
			}
			else if(!mail.matches(reg)){
				JOptionPane.showMessageDialog(this, "���������ʽ���Ϸ�", "����", JOptionPane.WARNING_MESSAGE);
			}
			else if(!account.matches("[A-Za-z0-9_]+")){
				JOptionPane.showMessageDialog(this, "������û������Ϸ�", "����", JOptionPane.WARNING_MESSAGE);
			}else{
			
				//��ͼ�����Dao��ʵ��ҵ�����
			    UserInforDao userInforDao=new UserInforDao();
				String strSQL="insert into  userinfor value(null,?,?,?,?,?)";
				Object[] params=new Object[]{account,password,name,mail,tpe};	
				int res=userInforDao.insert(strSQL, params);
				String message=res>0?"��ϲ��ע��ɹ���" : "�Բ���ע��ʧ�ܣ�����ϵ����Ա...";
					JOptionPane.showMessageDialog(this, "ע��ɹ�", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
					this.setVisible(false);
					FrmLogin frm1=new FrmLogin();
					frm1.setVisible(true);
			}	
		}
	}
	
public static void main(String[] args) {
	FrmRegister rr=new FrmRegister();
	rr.setVisible(true);
}

}

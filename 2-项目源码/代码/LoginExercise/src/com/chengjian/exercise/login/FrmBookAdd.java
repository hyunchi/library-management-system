package com.chengjian.exercise.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.chengjian.exercise.dao.BookInforDao;
import com.chengjian.exercise.dao.UserInforDao;

public class FrmBookAdd extends JFrame implements ActionListener {
	private JPanel topPanel,buttonPanel;
	private JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7;
	private JTextField txt1,txt2,txt3,txt4,txt5,txt6;
	private JButton btnEnsure,btnCannel;
	public FrmBookAdd(){
		
		super();
		this.setSize(new Dimension(500,500));
		this.setTitle("����ѧ���û�����");
		this.setLocationRelativeTo(this);
//		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//���ô����Ĭ����������Ĳ���ģʽΪnull
		this.getContentPane().setLayout(null);
		//����Ż���ʹ��UIManager��������Ż�
		Font font = new Font("����", Font.PLAIN, 12);
		UIManager.put("Label.font", font);//ͳһ��ǩ������
		UIManager.put("Button.font", font);//ͳһ��ť������
		
		//ʵ����topPanel��������������壩
		this.topPanel=new JPanel();
		this.topPanel.setLayout(null);
		this.topPanel.setBounds(new Rectangle(20,20,440,420));
		this.topPanel.setBorder(BorderFactory.createTitledBorder(null, "���ͼ��", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION));
		//this.topPanel.setBackground(Color.white);
		this.getContentPane().add(topPanel);
	
		this.lbl7 = new JLabel("��������Ҫ��ӵ�ͼ��:");
		this.lbl7.setBounds(new Rectangle(120,30, 300,30));
		this.lbl7.setFont(new Font("����", Font.BOLD, 16));
		this.topPanel.add(this.lbl7);
		
		this.lbl1 = new JLabel("ID:" );
		this.lbl1.setBounds(new Rectangle(20, 70, 40,40));
		this.topPanel.add(this.lbl1);
		
		this.lbl2 = new JLabel("����:" );
		this.lbl2.setBounds(new Rectangle(250, 70, 60,40));
		this.topPanel.add(this.lbl2);
		
		this.lbl3 = new JLabel("����:");
		this.lbl3.setBounds(new Rectangle(20, 150, 60,40));
		this.topPanel.add(this.lbl3);
		
		this.lbl4 = new JLabel("������:");
		this.lbl4.setBounds(new Rectangle(250, 150, 60,40));
		this.topPanel.add(this.lbl4);
		
		this.lbl5 = new JLabel("ͼ�����:");
		this.lbl5.setBounds(new Rectangle(20, 230, 60,40));
		this.topPanel.add(this.lbl5);
		
		this.lbl6 = new JLabel("ͼ������:");
		this.lbl6.setBounds(new Rectangle(240, 230, 70,40));
		this.topPanel.add(this.lbl6);
		

		
		this.txt1= new JTextField();
		this.txt1.setBounds(new Rectangle(80, 80, 120,30));
		this.topPanel.add(txt1);
		
		this.txt2= new JTextField();
		this.txt2.setBounds(new Rectangle(290, 80, 120,30));
		this.topPanel.add(txt2);
		
		this.txt3 = new JTextField();
		this.txt3.setBounds(new Rectangle(80, 160, 120,30));
		this.topPanel.add(txt3);
		
		this.txt4 = new JTextField();
		this.txt4.setBounds(new Rectangle(290, 160, 120,30));
		this.topPanel.add(txt4);
		
		this.txt5 = new JTextField();
		this.txt5.setBounds(new Rectangle(80, 240, 120,30));
		this.topPanel.add(txt5);
		
		this.txt6 = new JTextField();
		this.txt6.setBounds(new Rectangle(290, 240, 120,30));
		this.topPanel.add(txt6);
		
		this.btnEnsure =new JButton("ȷ��");
		this.btnEnsure.setBounds(new Rectangle(140, 350, 100, 30));
		this.btnEnsure.addActionListener(this);
		this.topPanel.add(this.btnEnsure);

		this.btnCannel =new JButton("ȡ��");
		this.btnCannel.setBounds(new Rectangle(290, 350, 100, 30));
		this.btnCannel.addActionListener(this);
		this.topPanel.add(this.btnCannel);	
	}	
	
	
	public void actionPerformed(ActionEvent e) {
		String scmd=e.getActionCommand();
		if(scmd.equals("ȡ��")){
			this.setVisible(false);
		}
		if(scmd.equals("ȷ��")){
			String a=txt2.getText().trim();
			String b=txt3.getText().trim();
			String c=txt4.getText().trim();
			String d=txt5.getText().trim();
			String f=txt6.getText().trim();
			if((a==null||a.length()==0)||(b==null||b.length()==0)||(c==null||c.length()==0)||(d==null||d.length()==0)||(f==null||f.length()==0)){
				JOptionPane.showMessageDialog(this, "�벹ȫͼ����Ϣ", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
			//��ͼ�����Dao��ʵ��ҵ�����
		    BookInforDao bookInforDao=new BookInforDao();
			String strSQL="insert into  bookinfor value(null,?,?,?,?,?)";
			Object[] params=new Object[]{a,b,c,d,f};	
			int res=bookInforDao.insert(strSQL, params);
			String message=res>0?"��ϲ����ӳɹ���" : "�Բ������ʧ��...";
				JOptionPane.showMessageDialog(this, message, "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
				this.setVisible(false);
//				MainFrm frm=new MainFrm();
//				frm.setVisible(true);
			}
		}

	}
	public static void main(String[] args) {
		FrmBookAdd frm=new FrmBookAdd();
		frm.setVisible(true);
	}

}

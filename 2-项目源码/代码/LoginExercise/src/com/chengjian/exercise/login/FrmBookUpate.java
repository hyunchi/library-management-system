package com.chengjian.exercise.login;

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

public class FrmBookUpate extends JFrame implements ActionListener {

	private JPanel topPanel,buttonPanel;
	private JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7;
	private JTextField txt1,txt2,txt3,txt4,txt5,txt6;
	private JButton btnEnsure,btnCannel,btncha;
	public FrmBookUpate(){
		
		super();
		this.setSize(new Dimension(500,500));
		this.setTitle("�޸�ͼ�鴰��");
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
		this.topPanel.setBorder(BorderFactory.createTitledBorder(null, "�޸�ͼ��", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION));
		//this.topPanel.setBackground(Color.white);
		this.getContentPane().add(topPanel);
	
		this.lbl7 = new JLabel("���ѯҪ�޸ĵ�ͼ��ID:");
		this.lbl7.setBounds(new Rectangle(30,30, 180,30));
		this.lbl7.setFont(new Font("����", Font.BOLD, 14));
		this.topPanel.add(this.lbl7);
		
		this.lbl1 = new JLabel("����:" );
		this.lbl1.setBounds(new Rectangle(20, 70, 40,40));
		this.topPanel.add(this.lbl1);
		
		this.lbl2 = new JLabel("����:" );
		this.lbl2.setBounds(new Rectangle(250, 70, 60,40));
		this.topPanel.add(this.lbl2);
		
		this.lbl3 = new JLabel("������:");
		this.lbl3.setBounds(new Rectangle(20, 150, 70,40));
		this.topPanel.add(this.lbl3);
		
		this.lbl4 = new JLabel("ͼ������:");
		this.lbl4.setBounds(new Rectangle(235, 150, 60,40));
		this.topPanel.add(this.lbl4);
		
		this.lbl5 = new JLabel("ͼ������:");
		this.lbl5.setBounds(new Rectangle(20, 230, 60,40));
		this.topPanel.add(this.lbl5);
		
//		this.lbl6 = new JLabel("ID:");
//		this.lbl6.setBounds(new Rectangle(240, 230, 70,40));
//		this.topPanel.add(this.lbl6);
		

		
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
		this.txt6.setBounds(new Rectangle(210, 30, 120,30));
		this.topPanel.add(txt6);
		
		this.btnEnsure =new JButton("��ѯ");
		this.btnEnsure.setBounds(new Rectangle(340, 30, 90, 30));
		this.btnEnsure.addActionListener(this);
		this.topPanel.add(this.btnEnsure);
		
		this.btnEnsure =new JButton("ȷ��");
		this.btnEnsure.setBounds(new Rectangle(130, 350, 90, 30));
		this.btnEnsure.addActionListener(this);
		this.topPanel.add(this.btnEnsure);

		this.btnCannel =new JButton("ȡ��");
		this.btnCannel.setBounds(new Rectangle(250, 350, 90, 30));
		this.btnCannel.addActionListener(this);
		this.topPanel.add(this.btnCannel);
	
		
		
	}	
	
	
	public void actionPerformed(ActionEvent e) {
		String scmd=e.getActionCommand();
		if(scmd.equals("ȡ��")){
			this.setVisible(false);
		}
		if(scmd.equals("ȷ��")){
			String ass=this.txt6.getText().trim();
			String s=txt1.getText();
			String d=txt2.getText();
			String f=txt3.getText();
			String g=txt4.getText();
			String h=txt5.getText();
			BookInforDao bookInforDao=new BookInforDao();
			String strSQL="update bookinfor set bname=?,bzuozhe=?,bchuban=?,btype=?,bnum=? where id=?";
			Object[] params=new Object[]{s,d,f,g,h,ass};
			int res=bookInforDao.xiugai(strSQL, params);
			String message=res>0?"��ϲ���޸ĳɹ���" : "�Բ����޸�ʧ��...";
				JOptionPane.showMessageDialog(this, message, "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false);
			
		}
		if(scmd.equals("��ѯ")){
			String ass=this.txt6.getText().trim();
			BookInforDao bookInforDao=new BookInforDao();
			String strSQL="select * from bookinfor where id=?";
			Object[] params=new Object[]{ass};
			String []aaa=new String[5];
			aaa=bookInforDao.update(strSQL, params);
			this.txt1.setText(aaa[0]);
			this.txt2.setText(aaa[1]);
			this.txt3.setText(aaa[2]);
			this.txt4.setText(aaa[3]);
			this.txt5.setText(aaa[4]);
			if(aaa[0]==null){
				JOptionPane.showMessageDialog(this, "�Բ�����������ȷ��ͼ��ID", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}
	public static void main(String[] args) {
		FrmBookUpate frm=new FrmBookUpate();
		frm.setVisible(true);
	}

}

package com.chengjian.exercise.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrmUpdate extends JFrame implements ActionListener { 
	private  JPanel topPanel,buttonPanel;
	private JLabel lblName,lblSex,lblNum,lblClass,lblY,lblBz;
	private JTextField txtName,txtSex,txtNum,txtClass,txtY,txtBz;
	private JButton btnEnsure,btnCannel;
	
	public FrmUpdate(){
	super();
  
	this.setSize(new Dimension(320,380));
	this.setTitle("�޸�ѧ���û�����");
	this.setLocationRelativeTo(this);
	this.setResizable(false);
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
	//���ô����Ĭ����������Ĳ���ģʽΪnull
	this.getContentPane().setLayout(null);
	
	//ʵ����topPanel��������������壩
	this.topPanel=new JPanel();
	this.topPanel.setLayout(null);
	this.topPanel.setBounds(new Rectangle(0,0,320,300));
	this.topPanel.setBackground(Color.white);
	this.getContentPane().add(topPanel);
	
	//ʵ����buttonPanel��������������壩
	this.buttonPanel=new JPanel();
	this.buttonPanel.setLayout(null);
	this.buttonPanel.setBounds(new Rectangle(0,300,320,60));
	this.getContentPane().add(buttonPanel);
	//.setBackground(Color.black);
//	private JLabel lblName,lblSex,lblNum,lblClass,lblY,lblBz;
//	private JTextField txtName,txtSex,txtNum,txtClass,txtY,txtBz;
	this.lblName=new JLabel("������");
	this.lblName.setBounds(new Rectangle(50,30, 60,30));
	this.topPanel.add(this.lblName);
	
	this.txtName=new JTextField();
	this.txtName.setBounds(new Rectangle(100,30,140,30));
	this.topPanel.add(this.txtName);
	
	this.lblName=new JLabel("�Ա�");
	this.lblName.setBounds(new Rectangle(50, 80, 60,30));
	this.topPanel.add(this.lblName);
	this.txtSex=new JTextField();
	this.txtSex.setBounds(new Rectangle(100,80,140,30));
	this.topPanel.add(this.txtSex);
	
	this.lblNum=new JLabel("ѧ�ţ�");
	this.lblNum.setBounds(new Rectangle(50, 130, 60,30));
	this.topPanel.add(this.lblNum);
	this.txtNum=new JTextField();
	this.txtNum.setBounds(new Rectangle(100,130,140,30));
	this.topPanel.add(this.txtNum);
	
	
	this.lblClass=new JLabel("�༶��");
	this.lblClass.setBounds(new Rectangle(50, 180, 60,30));
	this.topPanel.add(this.lblClass);
	this.txtClass=new JTextField();
	this.txtClass.setBounds(new Rectangle(100,180,140,30));
	this.topPanel.add(this.txtClass);
	
	this.lblY=new JLabel("�绰��");
	this.lblY.setBounds(new Rectangle(50, 230, 60,30));
	this.topPanel.add(this.lblY);
	this.txtY=new JTextField();
	this.txtY.setBounds(new Rectangle(100,230,140,30));
	this.topPanel.add(this.txtY);
	
	this.btnEnsure=new JButton("ȷ��");
	this.btnEnsure.setBounds(new Rectangle(80,10,70,30));
	//this.btnEnsure.addActionListener(this);
	this.buttonPanel.add(this.btnEnsure);
	
	this.btnCannel=new JButton("ȡ��");
	this.btnCannel.setBounds(new Rectangle(160,10,70,30));
	this.btnCannel.addActionListener(this);
	this.buttonPanel.add(this.btnCannel);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String scmd=e.getActionCommand();
		if(scmd.equals("ȡ��")){
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
	FrmUpdate frm=new FrmUpdate();
	frm.setVisible(true);
		
	}

}

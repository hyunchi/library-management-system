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

public class FrmAbout extends JFrame implements ActionListener {
	private JPanel Panel;
	private JLabel lbl1,lbl2,lbl3,lbl4,lbl5;
	//private JTextField txtQuery;
	private JButton btnEnsure,btnCannel;
	public FrmAbout(){
		
		super();
		this.setSize(new Dimension(320,420));
		this.setTitle("��������");
		this.setLocationRelativeTo(this);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//���ô����Ĭ����������Ĳ���ģʽΪnull
		this.getContentPane().setLayout(null);
		
		//ʵ����Panel��������������壩
		this.Panel=new JPanel();
		this.Panel.setLayout(null);
		this.Panel.setBounds(new Rectangle(0,0,320,420));
		this.Panel.setBackground(Color.white);
		this.getContentPane().add(Panel);
		
		this.lbl1=new JLabel("���ߣ���׳");
		this.lbl1.setBounds(new Rectangle(30, 60, 320,30));
		this.Panel.add(this.lbl1);
		
		this.lbl1=new JLabel("ʹ�ù��ߣ�Java����   Eclipse  MySQL");
		this.lbl1.setBounds(new Rectangle(30, 100, 320,30));
		this.Panel.add(this.lbl1);
		
		this.lbl1=new JLabel("ϵͳ���ƣ�ͼ�����ϵͳ");
		this.lbl1.setBounds(new Rectangle(30, 140, 320,30));
		this.Panel.add(this.lbl1);
		
		this.lbl1=new JLabel("���л�����Jdk1.7����");
		this.lbl1.setBounds(new Rectangle(30, 180, 320,30));
		this.Panel.add(this.lbl1);
		
		this.lbl1=new JLabel("����ʱ�䣺2016-01-13");
		this.lbl1.setBounds(new Rectangle(30, 220, 320,30));
		this.Panel.add(this.lbl1);
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
FrmAbout frm=new FrmAbout();
frm.setVisible(true);

	}

}

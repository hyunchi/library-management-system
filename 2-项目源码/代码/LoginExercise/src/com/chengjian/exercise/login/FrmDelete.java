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

public class FrmDelete extends JFrame implements ActionListener {
	

	private JPanel Panel,buttonPanel;
	private JLabel lblQuery;
	//private JTextField txtQuery;
	private JButton btnEnsure,btnCannel;
	public FrmDelete(){
		
		super();
		this.setSize(new Dimension(320,220));
		this.setTitle("ɾ��ѧ������");
		this.setLocationRelativeTo(this);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//���ô����Ĭ����������Ĳ���ģʽΪnull
		this.getContentPane().setLayout(null);
		
		//ʵ����Panel��������������壩
		this.Panel=new JPanel();
		this.Panel.setLayout(null);
		this.Panel.setBounds(new Rectangle(0,0,320,140));
		this.Panel.setBackground(Color.white);
		this.getContentPane().add(Panel);
		//ʵ����buttonPanel��������������壩
		this.buttonPanel=new JPanel();
		this.buttonPanel.setLayout(null);
		this.buttonPanel.setBounds(new Rectangle(0,140,320,80));
		//this.buttonPanel.setBackground(Color.blue);
		this.getContentPane().add(buttonPanel);
		
		this.lblQuery=new JLabel("��ȷ��Ҫɾ��"+"         "+"��λ�û���");
		this.lblQuery.setBounds(new Rectangle(30, 60, 320,30));
		this.Panel.add(this.lblQuery);
		
		
		this.btnEnsure=new JButton("ȷ��");
		this.btnEnsure.setBounds(new Rectangle(70,10,70,30));
		//this.btnEnsure.addActionListener(this);
		this.buttonPanel.add(this.btnEnsure);
		
		this.btnCannel=new JButton("ȡ��");
		this.btnCannel.setBounds(new Rectangle(170,10,70,30));
		this.btnCannel.addActionListener(this);
		this.buttonPanel.add(this.btnCannel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String scmd=e.getActionCommand();
		if(scmd.equals("ȡ��")){
			this.setVisible(false);
		}

	}
public static void main(String[] args) {
	FrmDelete frm=new FrmDelete();
	frm.setVisible(true);
}
}

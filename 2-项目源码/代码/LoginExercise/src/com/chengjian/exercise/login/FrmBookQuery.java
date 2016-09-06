package com.chengjian.exercise.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.chengjian.exercise.dao.BookInforDao;

public class FrmBookQuery extends JFrame implements ActionListener {

	private JPanel Panel,buttonPanel,Panel2,scorePanel;
	private JScrollPane scoreScrPanel;
	private JLabel lblQuery;
	private JTextField txtQuery;
	private JButton btnEnsure,btnCannel;
	private JTable viewTable;
	private JComboBox combox;
	public FrmBookQuery(){
		
		super();
		this.setSize(new Dimension(600,550));
		this.setTitle("��ѯͼ�鴰��");
		this.setLocationRelativeTo(this);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//���ô����Ĭ����������Ĳ���ģʽΪnull
		this.getContentPane().setLayout(null);
		
		//ʵ����Panel��������������壩
		this.Panel=new JPanel();
		this.Panel.setLayout(null);
		this.Panel.setBounds(new Rectangle(0,0,600,140));
		this.Panel.setBackground(Color.white);
		this.getContentPane().add(Panel);
		//ʵ����Panel��������������壩
		this.Panel2=new JPanel();
		this.Panel2.setLayout(new BorderLayout());
		this.Panel2.setBorder(BorderFactory.createTitledBorder(null,"��ѯ���",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION));
		this.Panel2.setBounds(new Rectangle(10,160,580,360));
		//this.Panel2.setBackground(Color.black);
		this.getContentPane().add(Panel2);
		//ʵ����buttonPanel��������������壩
//		this.buttonPanel=new JPanel();
//		this.buttonPanel.setLayout(null);
//		this.buttonPanel.setBounds(new Rectangle(0,140,600,80));
		//this.buttonPanel.setBackground(Color.blue);
		//this.getContentPane().add(buttonPanel);
		
		this.lblQuery=new JLabel("��ѡ���ѯ��ʽ��");
		this.lblQuery.setBounds(new Rectangle(60, 60, 150,30));
		this.Panel.add(this.lblQuery);
		
		String []str=new String[]{"id","����","����"};
		this.combox=new JComboBox(str);
		this.combox.setBounds(new Rectangle(180,60,60,30));
		this.Panel.add(this.combox);
		
		this.txtQuery=new JTextField();
		this.txtQuery.setBounds(new Rectangle(280,60,150,30));
		this.Panel.add(this.txtQuery);
		
		this.btnEnsure=new JButton("��ѯ");
		this.btnEnsure.setBounds(new Rectangle(455,60,80,30));
		this.btnEnsure.addActionListener(this);
		this.Panel.add(this.btnEnsure);
		
		
//		this.btnCannel=new JButton("ȡ��");
//		this.btnCannel.setBounds(new Rectangle(170,10,70,30));
//		this.btnCannel.addActionListener(this);
//		this.buttonPanel.add(this.btnCannel);
		
	}
	public String getTxtQuery(){
	
	return txtQuery.getText();
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String scmd=e.getActionCommand();
		if(scmd.equals("ȡ��")){
			this.setVisible(false);
		}
		if(scmd.equals("��ѯ")){
			String f=txtQuery.getText().trim();
			//��ȡ�����б��е�ֵ
			String select=(String) this.combox.getSelectedItem();
			if(select.equals("id")){select="id";}
			if(select.equals("����")){select="bzuozhe";}
			if(select.equals("����")){select="bname";}
			//��ͼ�����Dao��ʵ��ҵ�����
		    BookInforDao bookInforDao=new BookInforDao();
			String strSQL="select * from bookinfor where "+select+"=?";
			Object[] params=new Object[]{f};
			//�����ַ�������Ϊ������
			String[] cloumnName=new String[]{"ID","����","����","������","ͼ�����","����"};
			//�������ģ��
			DefaultTableModel dm=new DefaultTableModel(cloumnName,0);
		
			//����������
			this.viewTable=new JTable(dm);
			
			//���ñ���и�
			this.viewTable.setRowHeight(25);
			
			//���ñ������ĸ߶�
			JTableHeader header=this.viewTable.getTableHeader();
			header.setPreferredSize(new Dimension(header.getHeight(),30));
			//�������
			this.viewTable.setEnabled(false);
			
			bookInforDao.selectOther(dm,strSQL, params);
			
			//ʵ�����������
			this.scoreScrPanel=new JScrollPane();
			this.scoreScrPanel.getViewport().add(this.viewTable);
			//������������scorePanel��
			this.scorePanel=new JPanel();
			this.scorePanel.setLayout(new BorderLayout());
			this.scorePanel.add(this.scoreScrPanel);
			this.Panel2.removeAll();
			this.Panel2.add(this.scorePanel,BorderLayout.CENTER);
			//��centerPanel�е����ݽ����ع�
			this.Panel2.revalidate();	
			
//			String message=res>0?"��ϲ����ѯ�ɹ���" : "�Բ����ѯʧ��...";
				//JOptionPane.showMessageDialog(this, message, "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
				//this.setVisible(false);
//				MainFrm frm=new MainFrm();
//				frm.setVisible(true);
		}
	}
public static void main(String[] args) {
	FrmBookQuery frm=new FrmBookQuery();
	frm.setVisible(true);
}
}
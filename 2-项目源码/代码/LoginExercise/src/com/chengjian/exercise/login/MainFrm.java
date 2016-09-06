package com.chengjian.exercise.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.chengjian.exercise.dao.BookInforDao;
import com.chengjian.exercise.dao.StudentsInforDao;

public class MainFrm extends JFrame implements ActionListener {
	private String accou;
	private JPanel topPaenl, centerPanel, southPanel,toolBtnPanel;
	private JToolBar toolBar;
	public JButton btnDelete, btnUpdate, btnAdd, btnQuery, btnStu, btnBook,btnExit,btn1,btnSerch;
	private JLabel lblY, lblClass, lblName, lblTerm, lblimage,lbltishi;
	private JComboBox<String> comY, comName, comClass, comTerm;
	private JTextField txtSerch;
	private JMenuBar menuBar;
	private JMenu menuSys, menPrint, menStuMana, menScoreMana, menHelp, menY;
	public JMenuItem menUpdatepass, menExit, menPrintScore, menPrintstu;
	public JMenuItem men1, men2, men3, men4, men5, men6, men7, men8, men9,
			mena, menb, menc;
	private JPanel studentPanel, scorePanel;
	private JScrollPane studentsScrPanel, scoreScrPanel;
	private JTable studensTable, scoreTable;
	private JMenuItem itemUpdate, itemDel;
	private JPopupMenu jPopupMenu;

	public MainFrm(String account){
		
		super();
		this.accou=account;
		this.setSize(800, 700);
		this.setTitle("ͼ�����ϵͳv1.0");
		this.setLocationRelativeTo(this);
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// �������Ĭ�ϲ�������Ϊ�߽粼��
		this.getContentPane().setLayout(new BorderLayout());

		// ����Ż���ʹ��UIManager�����ͨ�����ͳһ����
		Font font = new Font("����", Font.PLAIN, 12);
		UIManager.put("MenuBar.font", font);
		UIManager.put("Menu.font", font);
		UIManager.put("MenuItem.font", font);

		// ʵ������������
		this.topPaenl = new JPanel();
		this.getContentPane().add(this.topPaenl, BorderLayout.NORTH);
		this.topPaenl.setLayout(new BorderLayout());

		this.centerPanel = new JPanel();
		// this.centerPanel.setBackground(Color.green);
		this.centerPanel.setLayout(new BorderLayout());
		// this.centerPanel.setBackground(new ImageIcon("images/"));
		this.getContentPane().add(this.centerPanel, BorderLayout.CENTER);

		this.lblimage = new JLabel(new ImageIcon("images/tushu.jpg"));
		this.centerPanel.add(this.lblimage, BorderLayout.NORTH);
		// this.southPanel=new JPanel();
		// this.getContentPane().add(this.southPanel,BorderLayout.SOUTH);
		// this.southPanel.setLayout(new BorderLayout());
	//	this.aaa=frmlogin.getAccount();
		this.initMenuBar();
		this.initToolBar();
		this.initPopMenu();
		// this.initStudentsTable();

	}

	// ��ʼ�������˵�
	public void initPopMenu() {
		this.jPopupMenu = new JPopupMenu();

		this.itemUpdate = new JMenuItem("������Ϣ");
		this.itemUpdate.addActionListener(this);
		this.itemDel = new JMenuItem("ɾ����Ϣ");
		this.itemDel.addActionListener(this);

		this.jPopupMenu.add(this.itemUpdate);
		this.jPopupMenu.addSeparator();
		this.jPopupMenu.add(this.itemDel);
	}

	// �Զ��巽����ɶԱ��Ĵ�������λ
	public void initStudentsTable(){
		this.centerPanel.removeAll();
		// �����ַ�������Ϊ������
		String[] cloumnName = new String[] {  "ID", "����", "�Ա�", "��������", "�༶","�绰","������" };
		// �������ģ��
		DefaultTableModel dm = new DefaultTableModel(cloumnName, 0);
		// ����������
		this.studensTable = new JTable(dm);
		StudentsInforDao studentsInforDao=new StudentsInforDao();
		studentsInforDao.selectAll(dm);
		// ���ñ���и�
		this.studensTable.setRowHeight(25);
		DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
		defaultTableCellRenderer.setHorizontalAlignment(JLabel.CENTER);
		this.studensTable.setDefaultRenderer(Object.class,defaultTableCellRenderer);
		// ���ñ������ĸ߶�
		JTableHeader header = this.studensTable.getTableHeader();
		header.setPreferredSize(new Dimension(header.getHeight(), 30));
		// �������
		this.studensTable.setEnabled(false);
		// ʵ�����������
		this.studentsScrPanel = new JScrollPane();
		this.studentsScrPanel.getViewport().add(this.studensTable);
		// ������������studentsPanel��
//		this.studentPanel = new JPanel();
//		this.studentPanel.setLayout(new BorderLayout());
		//this.studentPanel.add(this.studentsScrPanel);
		this.btnAdd = new JButton(new ImageIcon("images/add.png"));// ���
		this.btnAdd.setToolTipText("���");
		this.btnQuery = new JButton(new ImageIcon("images/select.png"));// ��ѯ
		this.btnQuery.setToolTipText("��ѯ");
		this.btnUpdate = new JButton(new ImageIcon("images/update.png"));// �޸�
		this.btnUpdate.setToolTipText("�޸�");
		this.btnDelete = new JButton(new ImageIcon("images/delete.png"));// ɾ��
		this.btnDelete.setToolTipText("ɾ��");
		
		this.toolBtnPanel=new JPanel();
		this.toolBtnPanel.setLayout(new FlowLayout(10));
		//this.toolBtnPanel.add(this.lbltishi);
		this.toolBtnPanel.add(this.btnAdd);
		this.toolBtnPanel.add(this.btnQuery);
		this.toolBtnPanel.add(this.btnUpdate);
		this.toolBtnPanel.add(this.btnDelete);
		
	//	this.toolBtnPanel.add(this.txtSerch);
		//this.toolBtnPanel.add(this.btnSerch);
		
		//this.toolBtnPanel.setBackground(Color.black);
		this.centerPanel.add(this.toolBtnPanel,BorderLayout.NORTH);
		
		this.centerPanel.add(this.studentsScrPanel, BorderLayout.CENTER);
		// ��centerPanel�е����ݽ����ع�
		this.centerPanel.revalidate();

	}

	public void initBookTable() {
		// �����ַ�������Ϊ������
		String[] cloumnName = new String[] { "ID", "����", "����", "������", "ͼ�����","�������" };
		// �������ģ��
		DefaultTableModel dm = new DefaultTableModel(cloumnName, 0);
		// ����������
		this.scoreTable = new JTable(dm) {
			// ���Ի��������Alt+shift+s,v
			public boolean isCellEditable(int row, int column) {
				return false;// ������Ա��Ԫ����в���
			}
		};
		
		// ���ñ���и�
		this.scoreTable.setRowHeight(25);
		DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
		defaultTableCellRenderer.setHorizontalAlignment(JLabel.CENTER);
		this.scoreTable.setDefaultRenderer(Object.class,defaultTableCellRenderer);
		// ��ӶԱ��Ķ�������
		this.scoreTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					// ��ȡ��ǰ�е�����
					String nam = scoreTable.getModel().getValueAt(scoreTable.getSelectedRow(), 1).toString();
					JOptionPane.showMessageDialog(MainFrm.this, "������:" + nam,"��Ϣ", JOptionPane.INFORMATION_MESSAGE);
				}
				// �Ҽ��������
				if (e.getModifiers() == Event.META_MASK) {
					// �ж��Ƿ�ǰ�������ѡ�е���
					if (scoreTable.getSelectedColumnCount() != -1) {
						jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
					}
				}
			}
		});

		// ����Dao����ʵ��dam ��װ
		BookInforDao book = new BookInforDao();
		book.selectAll(dm);
		this.centerPanel.removeAll();
		// ���ñ������ĸ߶�
		JTableHeader header = this.scoreTable.getTableHeader();
		header.setPreferredSize(new Dimension(header.getHeight(), 30));
		// �������
		// this.scoreTable.setEnabled(false);
		// ʵ�����������
		this.scoreScrPanel = new JScrollPane();
		this.scoreScrPanel.getViewport().add(this.scoreTable);
		// ������������scorePanel��
//		this.scorePanel = new JPanel();
//		this.scorePanel.setLayout(new BorderLayout());
		//this.scorePanel.add(this.scoreScrPanel,BorderLayout.NORTH);
		//this.lbltishi=new JLabel("�ɶ�ͼ��������²�����");
		this.btnAdd = new JButton(new ImageIcon("images/add.png"));// ���
		this.btnAdd.setToolTipText("���");
		this.btnQuery = new JButton(new ImageIcon("images/select.png"));// ��ѯ
		this.btnQuery.setToolTipText("��ѯ");
		this.btnUpdate = new JButton(new ImageIcon("images/update.png"));// �޸�
		this.btnUpdate.setToolTipText("�޸�");
		this.btnDelete = new JButton(new ImageIcon("images/delete.png"));// ɾ��
		this.btnDelete.setToolTipText("ɾ��");
//		this.txtSerch=new JTextField();
//		this.btnSerch=new JButton("����");
		
		
		this.toolBtnPanel=new JPanel();
		this.toolBtnPanel.setLayout(new FlowLayout(10));
		//this.toolBtnPanel.add(this.lbltishi);
		this.toolBtnPanel.add(this.btnAdd);
		this.toolBtnPanel.add(this.btnQuery);
		this.toolBtnPanel.add(this.btnUpdate);
		this.toolBtnPanel.add(this.btnDelete);
		
	//	this.toolBtnPanel.add(this.txtSerch);
		//this.toolBtnPanel.add(this.btnSerch);
		
		//this.toolBtnPanel.setBackground(Color.black);
		this.centerPanel.add(this.toolBtnPanel,BorderLayout.NORTH);

		//this.centerPanel.setBackground(Color.black);
		this.centerPanel.add(this.scoreScrPanel, BorderLayout.CENTER);
		// ��centerPanel�е����ݽ����ع�
		this.centerPanel.revalidate();
	}

	/*
	 * public void initBookTableView(){
	 * 
	 * 
	 * //�����ַ�������Ϊ������ String[] cloumnName=new
	 * String[]{"ID","����","����","������","ͼ�����","����"}; //�������ģ�� DefaultTableModel
	 * dm=new DefaultTableModel(cloumnName,1); //���������� this.scoreTable=new
	 * JTable(dm); //���ñ���и� this.scoreTable.setRowHeight(25);
	 * 
	 * //����Dao����ʵ��dam ��װ // BookInforDao book=new BookInforDao(); //
	 * book.selectOther(dm);
	 * 
	 * //���ñ������ĸ߶� JTableHeader header=this.scoreTable.getTableHeader();
	 * header.setPreferredSize(new Dimension(header.getHeight(),30)); //�������
	 * this.scoreTable.setEnabled(false); //ʵ����������� this.scoreScrPanel=new
	 * JScrollPane(); this.scoreScrPanel.getViewport().add(this.scoreTable);
	 * //������������scorePanel�� this.scorePanel=new JPanel();
	 * this.scorePanel.setLayout(new BorderLayout());
	 * this.scorePanel.add(this.scoreScrPanel); this.southPanel.removeAll();
	 * this.southPanel.add(this.scorePanel,BorderLayout.NORTH);
	 * //��centerPanel�е����ݽ����ع� this.southPanel.revalidate(); }
	 */

	// �Զ��巽����ɶԹ������Ĵ�������λ

	// ����ͼ�갴ť��ʾ
//	public void toolView() {
//		
//		this.btnAdd.setVisible(true);
//		this.btnUpdate.setVisible(true);
//		this.btnDelete.setVisible(true);
//		this.btnQuery.setVisible(true);
//	}

	// ��ʾbook��ʱ����ť���¼�����

	// �Զ��巽����ɶԲ˵����Ĵ�������λ
	public void initMenuBar() {
		// ʵ�����˵�����,�����ȼ�
		this.menuBar = new JMenuBar();
		this.menuSys = new JMenu("ϵͳ(S)");
		this.menuSys.setMnemonic('S');
		this.menStuMana = new JMenu("ѧ���û�����(E)");
		this.menStuMana.setMnemonic('E');
		this.menScoreMana = new JMenu("ͼ�����(C)");
		this.menScoreMana.setMnemonic('C');
		this.menY = new JMenu("����");
		// this.menY.setMnemonic('Y');
		this.menY.addActionListener(this);
		this.menHelp = new JMenu("����(H)");
		this.menHelp.setMnemonic('H');

		this.menPrint = new JMenu("��ӡ");
		this.menUpdatepass = new JMenuItem("�޸�����");
		this.menUpdatepass.addActionListener(this);
		this.menUpdatepass.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,InputEvent.CTRL_MASK));

		this.menPrintScore = new JMenuItem("��ӡ�û���Ϣ");
		this.menPrintScore.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,InputEvent.CTRL_MASK));

		this.menPrintstu = new JMenuItem("��ӡͼ����Ϣ");
		this.menPrintstu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,InputEvent.CTRL_MASK));

		this.menExit = new JMenuItem("�˳�ϵͳ");
		this.menExit.addActionListener(this);
		this.menExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));

		this.men1 = new JMenuItem("ȫ���û���Ϣ");
		this.men1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		this.men1.addActionListener(this);
		this.men2 = new JMenuItem("�����û�");
		this.men2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.CTRL_MASK));
		this.men2.addActionListener(this);
		this.men3 = new JMenuItem("ɾ���û�");
		this.men3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,InputEvent.CTRL_MASK));
		this.men3.addActionListener(this);
		this.men4 = new JMenuItem("�޸��û�");
		this.men4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));
		this.men4.addActionListener(this);
		this.men5 = new JMenuItem("��ѯ�û�");
		this.men5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		this.men5.addActionListener(this);

		this.men6 = new JMenuItem("ȫ��ͼ����Ϣ");
		this.men6.addActionListener(this);
		this.men7 = new JMenuItem("����ͼ��");
		this.men7.addActionListener(this);
		this.men8 = new JMenuItem("ɾ��ͼ��");
		this.men8.addActionListener(this);
		this.men9 = new JMenuItem("�޸�ͼ��");
		this.men9.addActionListener(this);
		this.mena = new JMenuItem("��ѯͼ��");
		this.mena.addActionListener(this);
		// ���˵���ӵ���Ӧ��������
		this.menuBar.add(this.menuSys);
		this.menuBar.add(this.menStuMana);
		this.menuBar.add(this.menScoreMana);
		this.menuBar.add(this.menY);
		this.menuBar.add(this.menHelp);

		this.menuSys.add(this.menUpdatepass);
		this.menuSys.addSeparator();
		this.menuSys.add(this.menPrint);
		this.menuSys.addSeparator();
		this.menuSys.add(this.menExit);
		this.menPrint.add(this.menPrintstu);
		this.menPrint.addSeparator();
		this.menPrint.add(this.menPrintScore);

		this.menStuMana.add(this.men1);
		this.menStuMana.addSeparator();
		this.menStuMana.add(this.men2);
		this.menStuMana.add(this.men3);
		this.menStuMana.add(this.men4);
		this.menStuMana.add(this.men5);

		this.menScoreMana.add(this.men6);
		this.menScoreMana.addSeparator();
		this.menScoreMana.add(this.men7);
		this.menScoreMana.add(this.men8);
		this.menScoreMana.add(this.men9);
		this.menScoreMana.add(this.mena);
		this.topPaenl.add(this.menuBar, BorderLayout.NORTH);
	}

	public void initToolBar() {
		// ʵ����JToolBar����
		this.toolBar = new JToolBar();
		// this.toolBar.setLayout(new BorderLayout());
		// ʵ�����������еĸ������
		
		this.btnStu = new JButton(new ImageIcon("images/student.gif"));// ��ʾѧ����
		this.btnStu.setToolTipText("��ʾѧ����");
		this.btnStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//toolView();
				initStudentsTable();
				toolStuView();
			}
		});
		this.btnBook = new JButton(new ImageIcon("images/book.gif"));// ��ʾͼ���
		this.btnBook.setToolTipText("��ʾͼ���");
		this.btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	toolView();
				initBookTable();
				toolBookVieww();
			}
		});
		this.btnExit = new JButton(new ImageIcon("images/exit.gif"));// �˳�
		this.btnExit.setToolTipText("�˳�");
		this.btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��ȡҪɾ������,û��ѡ����-1
				int n = JOptionPane.showConfirmDialog(null, "ȷ���˳�ϵͳ��?","ȷ���Ƿ��˳���", JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

//		this.btnAdd.setVisible(false);
//		this.btnUpdate.setVisible(false);
//		this.btnDelete.setVisible(false);
//		this.btnQuery.setVisible(false);

//		this.lblY = new JLabel("����Ժϵ��");
//		this.lblClass = new JLabel("�༶��");
		this.lblName = new JLabel("������ͼ���ţ�");
		this.txtSerch=new JTextField(45);
		this.btnSerch=new JButton("���");
		
		//this.lblTerm = new JLabel("ѧ�ڣ�");

		//String[] itemY = new String[] { "�����ѧԺ", "����ѧԺ", "��ľѧԺ", "�����ѧԺ" };
		//.comY = new JComboBox(itemY);
//		String[] itemName = new String[] { "��׳", "���˳�", "���ٺ�", "������" };
//		this.comName = new JComboBox(itemName);
//		String[] itemTerm = new String[] { "��һѧ��", "�ڶ�ѧ��", "����ѧ��", "����ѧ��" };
//		this.comTerm = new JComboBox(itemTerm);
//		String[] itemClass = new String[] { "���һ��", "�������", "�������", "����İ�" };
//		this.comClass = new JComboBox(itemClass);

		// �������ӵ�ToolBar��
//		this.toolBar.add(this.btnAdd);
//		this.toolBar.add(this.btnUpdate);
//		this.toolBar.add(this.btnDelete);
//		this.toolBar.add(this.btnQuery);
		this.toolBar.add(this.btnStu);
		this.toolBar.add(this.btnBook);
		this.toolBar.add(this.btnExit);

	//	this.toolBar.add(this.comY);
	//	this.toolBar.add(this.lblClass);
	//	this.toolBar.add(this.comClass);
		this.toolBar.add(this.lblName);
		this.toolBar.add(this.txtSerch);
		this.toolBar.add(this.btnSerch);
		this.btnSerch.addActionListener(this);
	//	this.toolBar.add(this.comTerm);
		// ������������topPanel��
		this.topPaenl.add(this.toolBar, BorderLayout.SOUTH);
		
		this.toolBar.revalidate();
	}

	// Ϊͼ���������Ӽ���
	public void toolBookVieww() {
		this.btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmBookAdd frm4 = new FrmBookAdd();
				frm4.setVisible(true);
			}
		});

		this.btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmBookUpate frm4 = new FrmBookUpate();
				frm4.setVisible(true);
			}
		});

		this.btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmBookQuery frm4 = new FrmBookQuery();
				frm4.setVisible(true);
			}
		});

		this.btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmBookDelete frm4 = new FrmBookDelete();
				frm4.setVisible(true);
			}
		});
	}

	// Ϊѧ������Ӱ�ť����
	public void toolStuView() {
		this.btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmAdd frm4 = new FrmAdd();
				frm4.setVisible(true);
			}
		});

		this.btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmUpdate frm4 = new FrmUpdate();
				frm4.setVisible(true);
			}
		});

		this.btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmQuery frm4 = new FrmQuery();
				frm4.setVisible(true);
			}
		});

		this.btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmDelete frm4 = new FrmDelete();
				frm4.setVisible(true);
			}
		});
	}
//	public void setAaa(FrmLogin frmlogin){
//		this.aaa=frmlogin.getAccount();
//	}
	
//	public String getAaa(){
//	
//	return this.aaa;
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String scmd = e.getActionCommand();
		
//		if (scmd.equals("���")) {
//
//			FrmBookUpate frm5 = new FrmBookUpate();
//			frm5.setVisible(true);
//			String a=this.txtSerch.getText().trim();
//			
//
//		}
		
		if (scmd.equals("�޸�����")) {
			FrmUpPassword frr = new FrmUpPassword(this.accou);
			frr.setVisible(true);

			// JOptionPane.showMessageDialog(this,
			// "���ڿ�����....","��Ϣ",JOptionPane.INFORMATION_MESSAGE);
		}
		if (scmd.equals("ȫ���û���Ϣ")) {
			//this.toolView();
			initStudentsTable();
			this.toolStuView();
		}
		if (scmd.equals("�����û�")) {
			FrmAdd frm1 = new FrmAdd();
			frm1.setVisible(true);

		}
		if (scmd.equals("ɾ���û�")) {
			FrmDelete frm1 = new FrmDelete();
			frm1.setVisible(true);

		}
		if (scmd.equals("��ѯ�û�")) {
			FrmQuery frm2 = new FrmQuery();
			frm2.setVisible(true);

		}
		if (scmd.equals("�޸��û�")) {
			FrmUpdate frm3 = new FrmUpdate();
			frm3.setVisible(true);

		}
		if (scmd.equals("����ͼ��")) {
			FrmBookAdd frm4 = new FrmBookAdd();
			frm4.setVisible(true);

		}
		if (scmd.equals("ɾ��ͼ��")) {
			FrmBookDelete frm1 = new FrmBookDelete();
			frm1.setVisible(true);

		}
		if (scmd.equals("�޸�ͼ��")) {

			FrmBookUpate frm5 = new FrmBookUpate();
			frm5.setVisible(true);

		}
		if (scmd.equals("��ѯͼ��")) {
			FrmBookQuery frm6 = new FrmBookQuery();
			frm6.setVisible(true);

		}
		if (scmd.equals("ȫ��ͼ����Ϣ")){
			//this.toolView();
			initBookTable();
			this.toolBookVieww();
			// initBookTableView();
		}

		if (scmd.equals("�˳�ϵͳ")) {
			if ((JOptionPane.showConfirmDialog(this, "ȷ���˳�ϵͳ��")) == 0) {
				System.exit(0);
			}
		}
		if (scmd.equals("����")) {
			FrmAbout frm6 = new FrmAbout();
			frm6.setVisible(true);
		}
		if(e.getSource() instanceof JMenuItem){
			JMenuItem 	clickedItem=(JMenuItem)e.getSource();
			if(clickedItem==this.itemDel){
				int id=Integer.parseInt(this.scoreTable.getModel().getValueAt(this.scoreTable.getSelectedRow(),0).toString());
				int res=JOptionPane.showConfirmDialog(this,"ȷ��ɾ�����Ϊ"+id+"����Ϣ��");
				if(res==0){
				BookInforDao bookinforDao=new BookInforDao();
				boolean flag=bookinforDao.delete(id);
				if(flag){
					initBookTable();
					JOptionPane.showMessageDialog(this,"ɾ���ɹ�","��Ϣ",JOptionPane.INFORMATION_MESSAGE);
				}else{
					
					JOptionPane.showMessageDialog(this,"ɾ��ʧ��","����",JOptionPane.ERROR_MESSAGE);
				}
					
				}
			}
			
			
		}
	}

//	public static void main(String[] args) {
//
//		MainFrm frm = new MainFrm("sdf");
//		frm.setVisible(true);
//	}

}

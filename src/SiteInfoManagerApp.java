import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class SiteInfoManagerApp extends JFrame {
   
 
   //createInfo
   private JPanel putPanel, basicInfoP, addInfoP, btnP, searchP, arrayP;
   private JTextField siteTF, addrTF, idTF, passTF;
   private JPanel tablePanel = new JPanel(); // ǥ �г�
   private String[] group1 = {"�з�","�Ϲ�", "�б�","����","����"};
   private String[] group2 = {"������","��", "�١�","�١١�","�١١١�","�١١١١�"};
   //private String[] group3 = {"�з�","�Ϲ�", "�б�","����","����"};
   private String[] group4 = {"��ü","�з�", "��ȣ��","����Ʈ�̸�","����Ʈ�ּ�"};
   //private String[] group5 = {"��ü","�з�", "��ȣ��","����Ʈ�̸�","����Ʈ�ּ�"};
   private JComboBox<String> group1Combo;
   private JComboBox<String> group2Combo;
   private JComboBox<String> group3Combo;
   private JComboBox<String> group4Combo;
   private JComboBox<String> group5Combo;
   
   private JTextArea textA;
   private JButton btn1, btn2 ;
   
   //createTab
   private JTextField filterTF;
   private  JCheckBox check;
   private   JButton deleteB;
   private JLabel sitenum;
   
   //ArrayList<HashMap<String,String>> siteInfoList = new ArrayList<HashMap<String,String>>();
   
  // String[] columNames = {"�з� ", "��ȣ��", "����Ʈ �̸�","����Ʈ �ּ�"};

	//Object[][] data = {
			//{"�Ϲ�","��", "�������","sarammani.com"},
			//{"����","", "�������ڴ��б�","www.duksung.ac.kr" }
	//};
   
	/*protected JPanel Dpanel;
	protected SiteDetailInfo detail;
	protected */
	
	
   protected JTable table;
  // protected InfoTableModel model;
  // protected DefaultTableModel dtm = new DefaultTableModel(data, columNames);
   protected DefaultTableModel dtm; // addRow�� ȣ���ϱ� ���� ����
  // JTextField idt = new JTextField(7);

    //privateJTextField pass = new JTextField(7);

   SiteInfoList infoList = new SiteInfoList();

   
   
   SiteInfoManagerApp() {
      super("����'s ���ͳ� ��������");
      
      createMenu(); // �޴�
      createInfo(); // [�Է� / ����]
      JTabbedPane pane = createTabbedPane(); // �� ����
      this.add(pane, BorderLayout.CENTER);
      siteNum(); // ����Ʈ ����
      
      setSize(900, 700);
      setLocation(600,200);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      /*
      setDefaultCloseOperation(JFrame. DO_NOTHING_ON_CLOSE); // X��ư ������ �ƹ� ���� ���� ����
      addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent e) {
              int result = JOptionPane.showConfirmDialog(SiteInfo.this, "���� �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION);
               if (result == JOptionPane.YES_OPTION) {
                  System.exit(0);
               }
               else return;
           }
      });*/
      setVisible(true);
     
       
   }
   private void createMenu() {
	   JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		//JMenu
		JMenu m1 = new JMenu("����(F)");
		JMenu m2 = new JMenu("����(M)");
		JMenu m3 = new JMenu("����(S)");
		
		menubar.add(m1);
		menubar.add(m2);
		menubar.add(m3);
		
		//����
		JMenuItem i1 = new JMenuItem("���� ���Ͽ��� ��������(I)");
		JMenuItem i2 = new JMenuItem("���� ���Ͽ��� ��������(E)");
		JMenuItem i3 = new JMenuItem("����(S)");
		JMenuItem i4 = new JMenuItem("�α׾ƿ�(O)");
		JMenuItem i5 = new JMenuItem("����(X)");
		
		i1.addActionListener(input);
		i1.setEnabled(false);
		//i2.addActionListener(ouput);
		i2.setEnabled(false);
		i3.addActionListener(save);
		//i4.addActionListener(logout);
		i5.addActionListener(exit);
		
		m1.add(i1);
		m1.add(i2);
		m1.add(i3);
		m1.addSeparator();
		m1.add(i4);
		m1.add(i5);
		
		//����
		JMenuItem r1 = new JMenuItem("�����(U)");
		JMenuItem r2 = new JMenuItem("����Ʈ �з�(C)");
		
		//r1.addActionListener(user);
		r1.setEnabled(false);
		r2.addActionListener(site);
		
		m2.add(r1);
		m2.add(r2);
		
		//����
		JMenuItem log = new JMenuItem("�ڵ� �α���(L)");
		JMenuItem view = new JMenuItem("�������� ���� ���� ����ϱ�(V)");
		
		log.addItemListener(autologin);
		//view.addActionListener(remember);
		
		m3.add(log);
		m3.add(view);
      
      //createTitleBorder();
      
      
   }
  
  
   private JPanel createInfo() {
      putPanel = new JPanel(new BorderLayout());
      putPanel.setBorder(new TitledBorder(new LineBorder(Color.black,1),"�Է�/����"));
   
      
      //�⺻����
      basicInfoP = new JPanel();
      basicInfoP.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "�⺻ ����"));
      basicInfoP.setLayout(new GridLayout(4,1));
      
      JPanel siteP = new JPanel(new FlowLayout(FlowLayout.LEFT));
      siteP.add(new JLabel("����Ʈ��"));
      siteTF = new JTextField(14);
      siteP.add(siteTF);
      
      JPanel addrP = new JPanel(new FlowLayout(FlowLayout.LEFT));
      addrP.add(new JLabel("�ּ�(URL) http://", JLabel.LEFT));
      addrTF = new JTextField(10);
      addrP.add(addrTF);

      JPanel idP = new JPanel(new FlowLayout(FlowLayout.LEFT));
      idP.add(new JLabel("��  ��  ��", JLabel.LEFT));
      idTF = new JTextField(7);
      idP.add(idTF);
      
      JPanel passP = new JPanel(new FlowLayout(FlowLayout.LEFT));
      passP.add(new JLabel("��й�ȣ", JLabel.LEFT));
      passTF = new JTextField(7);
      //passTF.setEchoChar('*');
      passP.add(passTF);
      
      Changed();
     
      basicInfoP.add(siteP);
      basicInfoP.add(addrP);
      basicInfoP.add(idP);
      basicInfoP.add(passP);
      
      //�߰�����
      
      addInfoP = new JPanel(new BorderLayout());
      addInfoP.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "�߰� ����"));
      
      JPanel addText = new JPanel(new GridLayout(2,1));
      JPanel addField = new JPanel();
      
      addInfoP.add(addText, BorderLayout.NORTH);
      addInfoP.add(addField, BorderLayout.CENTER);

      //�з�
      JPanel groupP = new JPanel(new FlowLayout(FlowLayout.LEFT));
      groupP.add(new JLabel("��     ��"));
      group1Combo = new JComboBox<String>(group1);
      groupP.add(group1Combo);
      
      //��ȣ��
      JPanel prefP = new JPanel(new FlowLayout(FlowLayout.LEFT));
         prefP.add(new JLabel("��ȣ��"));
         group2Combo = new JComboBox<String>(group2);
         prefP.add(group2Combo);

         //�޸�
         JPanel memoP = new JPanel(new FlowLayout(FlowLayout.LEFT));       
         memoP.add(new JLabel("��  ��"));
         textA = new JTextArea(7,15);
         memoP.add(textA);
    
         addText.add(groupP);
         addText.add(prefP);
         addField.add(memoP);
      
    // return addInfoP;
      
      /*
      detail = new SiteDetailInfo();
      addInfoP.add(detail);
      Dpanel = new JPanle(comp);*/
      //SiteDetailInfo();
      
      //�����ۼ�, �Է� ��ư
      btnP = new JPanel(new FlowLayout(FlowLayout.RIGHT));
      JButton btn1 = new JButton("���� �ۼ�(N)");
      JButton btn2 = new JButton("�Է�(I)");
      btn1.addActionListener(newin);
     // btn2.addActionListener(i);
     
     // btn1.setEnabled(false);
      btn2.setEnabled(false);
      
      btnP.add(btn1);
      btnP.add(btn2);
      
      JPanel pL = new JPanel(new BorderLayout());
      pL.add(basicInfoP, BorderLayout.NORTH);
      pL.add(addInfoP, BorderLayout.SOUTH);
      
      putPanel.add(pL, BorderLayout.NORTH);
      putPanel.add(btnP, BorderLayout.CENTER);
      
      
      this.add(putPanel, BorderLayout.WEST);
      
      return putPanel;
      
   }
   
   //������ �� ȭ�� ����
   private JTabbedPane createTabbedPane() {
      JTabbedPane pane = new JTabbedPane();
      this.add(pane, BorderLayout.CENTER);
      JPanel tabPanel = new JPanel();
      tabPanel.setLayout(new BorderLayout());
      
      
      pane.addTab("����Ʈ ���", tabPanel);
      pane.addTab("�����Ȳ", new JButton("�׽�Ʈ"));
 
      //�˻� ����
      JPanel searchArrayP = new JPanel();
      tabPanel.add(searchArrayP, BorderLayout.NORTH);
      searchArrayP.setLayout(new BorderLayout());
      searchArrayP.setBorder(new TitledBorder(new LineBorder(Color.black,1),"�˻�/����"));
      
      //�˻�
      JPanel searchP = new JPanel();
      
      searchP.setBorder(new TitledBorder(new LineBorder(Color.black,1),"�˻�"));
      group3Combo = new JComboBox<String>(group1);
      
      JLabel filterL = new JLabel("���� : ");
      filterTF = new JTextField(7);
      
      searchP.add(group3Combo);
      searchP.add(filterL);
      searchP.add(filterTF);

      //����
      JPanel arrayP = new JPanel();
      //arrayP.setLayout(new BorderLayout());
      arrayP.setBorder(new TitledBorder(new LineBorder(Color.black,1),"����")); // �׵θ�
     
      JPanel arrayPanel = new JPanel();
      arrayP.add(arrayPanel, BorderLayout.SOUTH);
      //arrayP.add(arrayPanel);
      
      group4Combo = new JComboBox<String>(group4);
      group5Combo = new JComboBox<String>(group4);
          
      btn1 = new JButton("����");
      btn2 = new JButton("�⺻");
    /*
      arrayP.add(group4Combo);
      arrayP.add(group5Combo);
      arrayP.add(btn1);
      arrayP.add(btn2);*/
      
      arrayPanel.add(group4Combo);
      arrayPanel.add(group5Combo);
      arrayPanel.add(btn1);
      arrayPanel.add(btn2);

      searchArrayP.add(searchP,BorderLayout.WEST);
      searchArrayP.add(arrayP,BorderLayout.CENTER);
      
      
      //ǥ
      
      tablePanel.setLayout(new BorderLayout());
      tabPanel.add(tablePanel, BorderLayout.CENTER);
		
	//model = new InfoTableModel();
      dtm = new DefaultTableModel();
      dtm.setColumnIdentifiers(new String[] {"�з� ", "��ȣ��", "����Ʈ �̸�","����Ʈ �ּ�"});
		table = new JTable(dtm);
		table.setRowHeight(30);
		
		table.setAutoCreateRowSorter(true); // �ڵ� �� ����
		
		tablePanel.add(new JScrollPane(table));
		tableRow(); // ǥ ��
      
      //��������
     JPanel viewPanel = new JPanel(new BorderLayout()); // �������� ���� �г�
     tabPanel.add(viewPanel, BorderLayout.SOUTH);
     
    check = new JCheckBox("�������� ����");
     JLabel idl = new JLabel("���̵�");
     JTextField idTF_bottom = new JTextField(7); //#����
     JLabel passl = new JLabel("��й�ȣ");
     JTextField passTF_bottom = new JTextField(7); //# ����
     deleteB = new JButton("����");
     deleteB.setEnabled(false);
     
     JPanel p1 = new JPanel();

     p1.add(check); 
     p1.add(idl);
     p1.add(idTF_bottom);
     p1.add(passl);
     p1.add(passTF_bottom);
     
     viewPanel.add(p1, BorderLayout.CENTER);
     viewPanel.add(deleteB, BorderLayout.EAST);
    
      return pane;
   }
   
   // ǥ �� Ŭ��������
   private void tableRow() {
	   table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		   public void valueChanged(ListSelectionEvent e) {
			   	Vector<SiteInfo> list = new Vector<SiteInfo>();
   				list.addAll(infoList.getSiteInfo());
   			
	   			int Row = table.getSelectedRow(); // ���� �� �� �˾Ƴ���
	   			SiteInfo s = list.get(Row);
	   			
	   			
		   }
	   });
	   
   }
   
   // ����Ʈ ���� ��Ÿ����
   private JPanel siteNum() {
	   JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
	   this.add(p, BorderLayout.SOUTH);
	   
	   p.setBorder(BorderFactory.createLoweredBevelBorder());
	   sitenum = new JLabel(dtm.getRowCount()+"���� ����Ʈ�� ��ϵǾ����ϴ�.");
	   p.add(sitenum);
	   
	   return p;
   }
   
   ActionListener input = new ActionListener() { // ���� ���� ��������
	   
	   Object[][] data = {
				//HashSet<SiteInfo> data = new HashSet<SiteInfo>();
				//data = {
						//{"�Ϲ�","��", "�������","sarammani.com"},
						//{"����","", "�������ڴ��б�","www.duksung.ac.kr" }
				};
	   @Override
	   public void actionPerformed(ActionEvent e) {
		 /*  // ������ ���� ��ġ �� ���ϸ�
		   FileOutputStream fos = new FileOutputStream(new File("C://singgo.xls"));
		   
		   // ������ workbook�� ����ϴ�.
		   HSSFWorkbook wb = new HSSFWorkbook();
	
		   // Sheet�� ������. �̸��� Name
		   HSSFSheet sheet = wb.createSheet("Name");
	
		   // ������ ����� row�� cell�̿���
		   HSSFRow row = null;
		   HSSFCell cell = null;
	
		   // ����� �����͸� ������ ���鼭 ����մϴ�.
		   for(int i=0; i<data.length; i++) {
	
		    // row�� ������
		    row = sheet.createRow(i);
	
		    // �� cell�� �����͸� �Է��Ͽ��ݴϴ�.
		    cell = row.createCell(0);
		    cell.setCellValue(data[i][0]);
		    cell = row.createCell(1);
		    cell.setCellValue(data[i][1]);
	
		   }
		   // file�� ����ϴ�.
		   wb.write(fos);
	
		   // close�� �޸� ������ �����ϱ� ���Ͽ� �ʼ�
		   if(fos != null) {
		    fos.close();
	
		   }*/
	   }
   };
   
   
   
   
   ActionListener save = new ActionListener() { // ���� - ����

      @Override
      public void actionPerformed(ActionEvent e) {
         JFileChooser chooser = new JFileChooser();
         
         int ret = chooser.showSaveDialog(SiteInfoManagerApp.this);
         if (ret == JFileChooser.APPROVE_OPTION) { // ���� ��ư ���� ���
            String fileName = chooser.getSelectedFile().getName(); // ���� �̸�
            JOptionPane.showMessageDialog(SiteInfoManagerApp.this, fileName, "Ȯ��", JOptionPane.INFORMATION_MESSAGE);
         }
         else if (ret == JFileChooser.CANCEL_OPTION) { // ��� ��ư ���� ���
            JOptionPane.showMessageDialog(SiteInfoManagerApp.this, "������ �������� �ʾҽ��ϴ�.", "���", JOptionPane.WARNING_MESSAGE);
            return;
         }
      }
   };
   
   ActionListener exit = new ActionListener() { // ���� - ����

      @Override
      public void actionPerformed(ActionEvent e) {
         int result = JOptionPane.showConfirmDialog(SiteInfoManagerApp.this, "���� �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION);
         if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
         }
         else return;
         
      }
   };
   
   ActionListener site = new ActionListener() { // ���� - ����Ʈ �з�

	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	  //CategoryManageDialog category = new CategoryManageDialog();
	    	  
	         
	      }
   };
   
   ItemListener autologin = new ItemListener() { // ���� - �ڵ� �α���

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED);
				//jt.setEnabled(true);
			//else
				//jt.setEnabled(false);
			
			
		}
		
	};
	
	ActionListener newin = new ActionListener() {
		@Override
	      public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("���� �ۼ�(N)")) { // �����ۼ� ��ư Ŭ���ϸ�
						
						String siteTitle = siteTF.getText().toString();
						String siteUrl = addrTF.getText().toString();
						String siteKind = group1Combo.getSelectedItem().toString();
						String siteFv = group2Combo.getSelectedItem().toString();
						String siteId = idTF.getText().toString();
						String sitePwd = passTF.getText().toString();
						String[] s = {siteKind,siteFv,siteTitle,siteUrl};
						dtm.addRow(s);
						
						//==== [start] ����Ʈ �������� ====
							/*HashMap<String,String> mapInfo = new HashMap<String, String>();
							
							mapInfo.put("siteTitle", siteTitle);
							mapInfo.put("siteUrl", siteUrl);
							mapInfo.put("siteKind", siteKind);
							mapInfo.put("siteFv", siteFv);
							mapInfo.put("siteId", siteId);
							mapInfo.put("sitePwd", sitePwd);
							
							siteInfoList.add(mapInfo);*/
						//==== [END] ����Ʈ �������� ====
							
						
						siteTF.setText("");
						addrTF.setText("");
						idTF.setText("");
						passTF.setText("");
						
						sitenum.setText(dtm.getRowCount()+"���� ����Ʈ�� ��ϵǾ����ϴ�.");
					}
					
					//if(e.getSource().equals(dtm)) { // ǥ�� Ŭ���ϸ�
						
						/*HashMap<String, String> getThisMapInfo = siteInfoList.get(1);

						siteTF.setText(getThisMapInfo.get("siteTitle"));
						addrTF.setText(getThisMapInfo.get("siteUrl"));
						idTF.setText(getThisMapInfo.get("siteId"));
						passTF.setText(getThisMapInfo.get("sitePwd"));
						group1Combo.setSelectedItem(getThisMapInfo.get("siteKind"));
						group1Combo.setSelectedItem(getThisMapInfo.get("siteFv"));
						
						
						
					}*/
				
					
				}
				
	};
	
	
	
	
	private void Changed() {
		if (passTF.getText().length() > 0)
			btn1.setEnabled(true);
	}
   
   public static void main(String[] args) {
      new SiteInfoManagerApp();
      StartLogin startLogin = new StartLogin();
   }

} 
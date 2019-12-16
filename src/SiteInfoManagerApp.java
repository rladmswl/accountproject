import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
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
   private JPanel tablePanel = new JPanel(); // 妊 鳶確
   private String[] group1 = {"歳嫌","析鋼", "俳嘘","舛左","匂登"};
   private String[] group2 = {"耕走舛","』", "』』","』』』","』』』』","』』』』』"};
   //private String[] group3 = {"歳嫌","析鋼", "俳嘘","舛左","匂登"};
   private String[] group4 = {"穿端","歳嫌", "識硲亀","紫戚闘戚硯","紫戚闘爽社"};
   //private String[] group5 = {"穿端","歳嫌", "識硲亀","紫戚闘戚硯","紫戚闘爽社"};
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
   
   ArrayList<HashMap<String,String>> siteInfoList = new ArrayList<HashMap<String,String>>();
   
  // String[] columNames = {"歳嫌 ", "識硲亀", "紫戚闘 戚硯","紫戚闘 爽社"};

	//Object[][] data = {
			//{"析鋼","』", "紫寓幻戚","sarammani.com"},
			//{"企俳","", "幾失食切企俳嘘","www.duksung.ac.kr" }
	//};
   
	/*protected JPanel Dpanel;
	protected SiteDetailInfo detail;
	protected */
	
	
   protected JTable table;
  // protected InfoTableModel model;
  // protected DefaultTableModel dtm = new DefaultTableModel(data, columNames);
   protected DefaultTableModel dtm; // addRow研 硲窒馬奄 是廃 識情
  // JTextField idt = new JTextField(7);

    //privateJTextField pass = new JTextField(7);

   SiteInfoList infoList = new SiteInfoList();

   
   
   SiteInfoManagerApp() {
      super("精走's 昔斗掛 域舛淫軒");
      
      createMenu(); // 五敢
      createInfo(); // [脊径 / 呪舛]
      JTabbedPane pane = createTabbedPane(); // 吐 持失
      this.add(pane, BorderLayout.CENTER);
      siteNum(); // 紫戚闘 鯵呪
      
      setSize(900, 700);
      setLocation(600,200);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      /*
      setDefaultCloseOperation(JFrame. DO_NOTHING_ON_CLOSE); // X獄動 喚君亀 焼巷 疑拙 馬走 省製
      addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent e) {
              int result = JOptionPane.showConfirmDialog(SiteInfo.this, "舛源 曽戟馬獣畏柔艦猿?", "曽戟", JOptionPane.YES_NO_OPTION);
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
		JMenu m1 = new JMenu("督析(F)");
		JMenu m2 = new JMenu("淫軒(M)");
		JMenu m3 = new JMenu("竺舛(S)");
		
		menubar.add(m1);
		menubar.add(m2);
		menubar.add(m3);
		
		//督析
		JMenuItem i1 = new JMenuItem("植漆 督析拭辞 亜閃神奄(I)");
		JMenuItem i2 = new JMenuItem("植漆 督析拭辞 鎧左鎧奄(E)");
		JMenuItem i3 = new JMenuItem("煽舌(S)");
		JMenuItem i4 = new JMenuItem("稽益焼数(O)");
		JMenuItem i5 = new JMenuItem("曽戟(X)");
		
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
		
		//淫軒
		JMenuItem r1 = new JMenuItem("紫遂切(U)");
		JMenuItem r2 = new JMenuItem("紫戚闘 歳嫌(C)");
		
		//r1.addActionListener(user);
		r1.setEnabled(false);
		r2.addActionListener(site);
		
		m2.add(r1);
		m2.add(r2);
		
		//竺舛
		JCheckBoxMenuItem log = new JCheckBoxMenuItem("切疑 稽益昔(L)");
		JMenuItem view = new JMenuItem("域舛舛左 左奄 雌殿 奄常馬奄(V)");
		
		log.addItemListener(autologin);
		//view.addActionListener(remember);
		
		m3.add(log);
		m3.add(view);
      
      //createTitleBorder();
      
      
   }
  
  
   private JPanel createInfo() {
      putPanel = new JPanel(new BorderLayout());
      putPanel.setBorder(new TitledBorder(new LineBorder(Color.black,1),"脊径/呪舛"));
   
      
      //奄沙舛左
      basicInfoP = new JPanel();
      basicInfoP.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "奄沙 舛左"));
      basicInfoP.setLayout(new GridLayout(4,1));
      
      JPanel siteP = new JPanel(new FlowLayout(FlowLayout.LEFT));
      siteP.add(new JLabel("紫戚闘誤"));
      siteTF = new JTextField(14);
      siteP.add(siteTF);
      
      JPanel addrP = new JPanel(new FlowLayout(FlowLayout.LEFT));
      addrP.add(new JLabel("爽社(URL) http://", JLabel.LEFT));
      addrTF = new JTextField(10);
      addrP.add(addrTF);

      JPanel idP = new JPanel(new FlowLayout(FlowLayout.LEFT));
      idP.add(new JLabel("焼  戚  巨", JLabel.LEFT));
      idTF = new JTextField(7);
      idP.add(idTF);
      
      JPanel passP = new JPanel(new FlowLayout(FlowLayout.LEFT));
      passP.add(new JLabel("搾腔腰硲", JLabel.LEFT));
      passTF = new JTextField(7);
      //passTF.setEchoChar('*');
      passP.add(passTF);
      
      Changed();
     
      basicInfoP.add(siteP);
      basicInfoP.add(addrP);
      basicInfoP.add(idP);
      basicInfoP.add(passP);
      
      //蓄亜舛左
      
      addInfoP = new JPanel(new BorderLayout());
      addInfoP.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "蓄亜 舛左"));
      
      JPanel addText = new JPanel(new GridLayout(2,1));
      JPanel addField = new JPanel();
      
      addInfoP.add(addText, BorderLayout.NORTH);
      addInfoP.add(addField, BorderLayout.CENTER);

      //歳嫌
      JPanel groupP = new JPanel(new FlowLayout(FlowLayout.LEFT));
      groupP.add(new JLabel("歳     嫌"));
      group1Combo = new JComboBox<String>(group1);
      groupP.add(group1Combo);
      
      //識硲亀
      JPanel prefP = new JPanel(new FlowLayout(FlowLayout.LEFT));
         prefP.add(new JLabel("識硲亀"));
         group2Combo = new JComboBox<String>(group2);
         prefP.add(group2Combo);

         //五乞
         JPanel memoP = new JPanel(new FlowLayout(FlowLayout.LEFT));       
         memoP.add(new JLabel("五  乞"));
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
      
      //歯稽拙失, 脊径 獄動
      btnP = new JPanel(new FlowLayout(FlowLayout.RIGHT));
      JButton btn1 = new JButton("歯稽 拙失(N)");
      JButton btn2 = new JButton("脊径(I)");
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
   
   //神献楕 吐 鉢檎 姥失
   private JTabbedPane createTabbedPane() {
      JTabbedPane pane = new JTabbedPane();
      this.add(pane, BorderLayout.CENTER);
      JPanel tabPanel = new JPanel();
      tabPanel.setLayout(new BorderLayout());
      
      
      pane.addTab("紫戚闘 鯉系", tabPanel);
      pane.addTab("去系薄伐", new JButton("砺什闘"));
 
      //伊事 舛慶
      JPanel searchArrayP = new JPanel();
      tabPanel.add(searchArrayP, BorderLayout.NORTH);
      searchArrayP.setLayout(new BorderLayout());
      searchArrayP.setBorder(new TitledBorder(new LineBorder(Color.black,1),"伊事/舛慶"));
      
      //伊事
      JPanel searchP = new JPanel();
      
      searchP.setBorder(new TitledBorder(new LineBorder(Color.black,1),"伊事"));
      group3Combo = new JComboBox<String>(group1);
      
      JLabel filterL = new JLabel("琶斗 : ");
      filterTF = new JTextField(7);
      
      searchP.add(group3Combo);
      searchP.add(filterL);
      searchP.add(filterTF);

      //舛慶
      JPanel arrayP = new JPanel();
      //arrayP.setLayout(new BorderLayout());
      arrayP.setBorder(new TitledBorder(new LineBorder(Color.black,1),"舛慶")); // 砺砧軒
     
      JPanel arrayPanel = new JPanel();
      arrayP.add(arrayPanel, BorderLayout.SOUTH);
      //arrayP.add(arrayPanel);
      
      group4Combo = new JComboBox<String>(group4);
      group5Combo = new JComboBox<String>(group4);
          
      btn1 = new JButton("舛慶");
      btn2 = new JButton("奄沙");
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
      
      
      //妊
      
      tablePanel.setLayout(new BorderLayout());
      tabPanel.add(tablePanel, BorderLayout.CENTER);
		
	//model = new InfoTableModel();
      dtm = new DefaultTableModel();
      dtm.setColumnIdentifiers(new String[] {"歳嫌 ", "識硲亀", "紫戚闘 戚硯","紫戚闘 爽社"});
		table = new JTable(dtm);
		table.setRowHeight(30);
		
		table.setAutoCreateRowSorter(true); // 切疑 楳 舛慶
		
		tablePanel.add(new JScrollPane(table));
		//tableRow(); // 妊 楳
      
      //域舛舛左
     JPanel viewPanel = new JPanel(new BorderLayout()); // 域舛舛左 左奄 鳶確
     tabPanel.add(viewPanel, BorderLayout.SOUTH);
     
    check = new JCheckBox("域舛舛左 左奄");
     JLabel idl = new JLabel("焼戚巨");
     JTextField idTF_bottom = new JTextField(7); //#因遂
     JLabel passl = new JLabel("搾腔腰硲");
     JTextField passTF_bottom = new JTextField(7); //# 因遂
     deleteB = new JButton("肢薦");
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
   
   // 妊 楳 適遣梅聖凶
  /* private void tableRow() {
	   table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		   public void valueChanged(ListSelectionEvent e) {
			   	Vector<SiteInfo> list = new Vector<SiteInfo>();
   				list.addAll(infoList.getSiteInfo());
   			
	   			int row = table.getSelectedRow(); // 識澱 吉 伸 硝焼鎧奄
	   			SiteInfo s = list.get(row); //神嫌ばばばばばばばばばばばばばばばばばばばばばばばばばばばばばばばばばば
	   			
	   			siteTF.setText(s.getSiteName());
	   			addrTF.setText(s.getUrl());
	   			idTF.setText(s.getId());
	   			passTF.setText(s.getPw());
			   
			   int Row = table.getSelectedRow(); // 識澱 吉 伸 硝焼鎧奄
			   siteTF = table.getValueAt((Row, 2));
	   			addrTF.setText();
	   			idTF.setText();
	   			passTF.setText();
	   			
	   		 // 歳嫌爪左
	   			String s1 = ((SiteDetailInfo)s).getGroup();
	   			int index1 = 0;
	   			for ( int i1 = 0; i1<group1.length; i1++) {
	   				if(group1[i1].equals(s1)) {
	   					index1 = i1;
	   				}
	   			}
	   			group1Combo.setSelectedIndex(index1);
	   			
	   		 // 識硲亀爪左
	   			String s2 = ((SiteDetailInfo)s).getPrefer();
	   			int index2 = 0;
	   			for ( int i2 = 0; i2<group2.length; i2++) {
	   				if(group1[i2].equals(s2)) {
	   					index2 = i2;
	   				}
	   			}
	   			group2Combo.setSelectedIndex(index2);
	   			
	   			textA.setText(((SiteDetailInfo)s).getMemo());
		   }
	   });
	   
   }*/
   
   // 紫戚闘 鯵呪 蟹展鎧奄
   private JPanel siteNum() {
	   JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
	   this.add(p, BorderLayout.SOUTH);
	   
	   p.setBorder(BorderFactory.createLoweredBevelBorder());
	   sitenum = new JLabel(dtm.getRowCount()+"鯵税 紫戚闘亜 去系鞠醸柔艦陥.");
	   p.add(sitenum);
	   
	   return p;
   }
   
   ActionListener input = new ActionListener() { // 植漆 督析 亜閃神奄
	   
	  /* Object[][] data = {
				//HashSet<SiteInfo> data = new HashSet<SiteInfo>();
				//data = {
						//{"析鋼","』", "紫寓幻戚","sarammani.com"},
						//{"企俳","", "幾失食切企俳嘘","www.duksung.ac.kr" }
				};*/
	   @Override
	   public void actionPerformed(ActionEvent args) {
		   
		   try {
			   OutputStream output = new FileOutputStream("C:\\Users\\82105\\Desktop\\幾失\\2-2\\切郊B.txt");
			   String str = "照括";
			   byte[] by = str.getBytes();
			   output.write(by);
		   }
		   catch (Exception e) {
			   e.getStackTrace();
		   }
		   
		   
		   
		 /*  // 督析聖 幻級 是帖 貢 督析誤
		   FileOutputStream fos = new FileOutputStream(new File("C://eunji.xls"));
		   
		   // 植漆聖 workbook聖 幻旧艦陥.
		   HSSFWorkbook wb = new HSSFWorkbook();
	
		   // Sheet研 幻級嬢推. 戚硯精 Name
		   HSSFSheet sheet = wb.createSheet("Name");
	
		   // 蒋生稽 紫遂拝 row人 cell戚拭推
		   HSSFRow row = null;
		   HSSFCell cell = null;
	
		   // 煽舌吃 汽戚斗研 欠覗研 宜檎辞 奄系杯艦陥.
		   for(int i=0; i<data.length; i++) {
	
		    // row研 幻級嬢推
		    row = sheet.createRow(i);
	
		    // 唖 cell拭 汽戚斗研 脊径馬食掃艦陥.
		    cell = row.createCell(0);
		    cell.setCellValue(data[i][0]);
		    cell = row.createCell(1);
		    cell.setCellValue(data[i][1]);
	
		   }
		   // file聖 幻旧艦陥.
		   wb.write(fos);
	
		   // close澗 五乞軒 刊呪研 号走馬奄 是馬食 琶呪
		   if(fos != null) {
		    fos.close();
	
		   }*/
	   }
   };
   
   ActionListener save = new ActionListener() { // 督析 - 煽舌

      @Override
      public void actionPerformed(ActionEvent e) {
         JFileChooser chooser = new JFileChooser();
         
         int ret = chooser.showSaveDialog(SiteInfoManagerApp.this);
         if (ret == JFileChooser.APPROVE_OPTION) { // 煽舌 獄動 刊献 井酔
            String fileName = chooser.getSelectedFile().getName(); // 督析 戚硯
            JOptionPane.showMessageDialog(SiteInfoManagerApp.this, fileName, "溌昔", JOptionPane.INFORMATION_MESSAGE);
         }
         else if (ret == JFileChooser.CANCEL_OPTION) { // 昼社 獄動 刊献 井酔
            JOptionPane.showMessageDialog(SiteInfoManagerApp.this, "督析聖 識澱馬走 省紹柔艦陥.", "井壱", JOptionPane.WARNING_MESSAGE);
            return;
         }
      }
   };
   
   ActionListener exit = new ActionListener() { // 督析 - 曽戟

      @Override
      public void actionPerformed(ActionEvent e) {
         int result = JOptionPane.showConfirmDialog(SiteInfoManagerApp.this, "舛源 曽戟馬獣畏柔艦猿?", "曽戟", JOptionPane.YES_NO_OPTION);
         if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
         }
         else return;
         
      }
   };
   
   ActionListener site = new ActionListener() { // 淫軒 - 紫戚闘 歳嫌

	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	  CategoryManageDialog category = new CategoryManageDialog();
	      }
   };
   
   ItemListener autologin = new ItemListener() { // 竺舛 - 切疑 稽益昔

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) { // 切疑 稽益昔 端滴馬檎
				StartLogin startLogin = new StartLogin(); // 稽益昔但 陥獣襟奄
			}
			
		}
		
	};
	
	ActionListener newin = new ActionListener() { // 歯稽拙失 獄動 戚坤闘
		@Override
	      public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("歯稽 拙失(N)")) { // 歯稽拙失 獄動 適遣馬檎
						
						String siteTitle = siteTF.getText().toString();
						String siteUrl = addrTF.getText().toString();
						String siteKind = group1Combo.getSelectedItem().toString();
						String siteFv = group2Combo.getSelectedItem().toString();
						String siteId = idTF.getText().toString();
						String sitePwd = passTF.getText().toString();
						String[] s = {siteKind,siteFv,siteTitle,siteUrl};
						dtm.addRow(s);
						
						//==== [start] 紫戚闘 舛左煽舌 ====
							HashMap<String,String> mapInfo = new HashMap<String, String>();
							
							mapInfo.put("siteTitle", siteTitle);
							mapInfo.put("siteUrl", siteUrl);
							mapInfo.put("siteKind", siteKind);
							mapInfo.put("siteFv", siteFv);
							mapInfo.put("siteId", siteId);
							mapInfo.put("sitePwd", sitePwd);
							
							siteInfoList.add(mapInfo);
						//==== [END] 紫戚闘 舛左煽舌 ====
							
						
						siteTF.setText("");
						addrTF.setText("");
						idTF.setText("");
						passTF.setText("");
						
						textA.setText("");
						
						sitenum.setText(dtm.getRowCount()+"鯵税 紫戚闘亜 去系鞠醸柔艦陥.");
						
					}
					
					if(e.getSource().equals(table)) { // 妊研 適遣馬檎
						
						HashMap<String, String> getThisMapInfo = siteInfoList.get(1);

						siteTF.setText(getThisMapInfo.get("siteTitle"));
						addrTF.setText(getThisMapInfo.get("siteUrl"));
						idTF.setText(getThisMapInfo.get("siteId"));
						passTF.setText(getThisMapInfo.get("sitePwd"));
						group1Combo.setSelectedItem(getThisMapInfo.get("siteKind"));
						group1Combo.setSelectedItem(getThisMapInfo.get("siteFv"));
						
						
					}
				
					
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
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
   private JPanel tablePanel = new JPanel(); // 표 패널
   private String[] group1 = {"분류","일반", "학교","정보","포털"};
   private String[] group2 = {"미지정","☆", "☆☆","☆☆☆","☆☆☆☆","☆☆☆☆☆"};
   //private String[] group3 = {"분류","일반", "학교","정보","포털"};
   private String[] group4 = {"전체","분류", "선호도","사이트이름","사이트주소"};
   //private String[] group5 = {"전체","분류", "선호도","사이트이름","사이트주소"};
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
   
  // String[] columNames = {"분류 ", "선호도", "사이트 이름","사이트 주소"};

	//Object[][] data = {
			//{"일반","☆", "사람만이","sarammani.com"},
			//{"대학","", "덕성여자대학교","www.duksung.ac.kr" }
	//};
   
	/*protected JPanel Dpanel;
	protected SiteDetailInfo detail;
	protected */
	
	
   protected JTable table;
  // protected InfoTableModel model;
  // protected DefaultTableModel dtm = new DefaultTableModel(data, columNames);
   protected DefaultTableModel dtm; // addRow를 호출하기 위한 선언
  // JTextField idt = new JTextField(7);

    //privateJTextField pass = new JTextField(7);

   SiteInfoList infoList = new SiteInfoList();

   
   
   SiteInfoManagerApp() {
      super("은지's 인터넷 계정관리");
      
      createMenu(); // 메뉴
      createInfo(); // [입력 / 수정]
      JTabbedPane pane = createTabbedPane(); // 탭 생성
      this.add(pane, BorderLayout.CENTER);
      siteNum(); // 사이트 개수
      
      setSize(900, 700);
      setLocation(600,200);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      /*
      setDefaultCloseOperation(JFrame. DO_NOTHING_ON_CLOSE); // X버튼 눌러도 아무 동작 하지 않음
      addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent e) {
              int result = JOptionPane.showConfirmDialog(SiteInfo.this, "정말 종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION);
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
		JMenu m1 = new JMenu("파일(F)");
		JMenu m2 = new JMenu("관리(M)");
		JMenu m3 = new JMenu("설정(S)");
		
		menubar.add(m1);
		menubar.add(m2);
		menubar.add(m3);
		
		//파일
		JMenuItem i1 = new JMenuItem("엑셀 파일에서 가져오기(I)");
		JMenuItem i2 = new JMenuItem("엑셀 파일에서 내보내기(E)");
		JMenuItem i3 = new JMenuItem("저장(S)");
		JMenuItem i4 = new JMenuItem("로그아웃(O)");
		JMenuItem i5 = new JMenuItem("종료(X)");
		
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
		
		//관리
		JMenuItem r1 = new JMenuItem("사용자(U)");
		JMenuItem r2 = new JMenuItem("사이트 분류(C)");
		
		//r1.addActionListener(user);
		r1.setEnabled(false);
		r2.addActionListener(site);
		
		m2.add(r1);
		m2.add(r2);
		
		//설정
		JMenuItem log = new JMenuItem("자동 로그인(L)");
		JMenuItem view = new JMenuItem("계정정보 보기 상태 기억하기(V)");
		
		log.addItemListener(autologin);
		//view.addActionListener(remember);
		
		m3.add(log);
		m3.add(view);
      
      //createTitleBorder();
      
      
   }
  
  
   private JPanel createInfo() {
      putPanel = new JPanel(new BorderLayout());
      putPanel.setBorder(new TitledBorder(new LineBorder(Color.black,1),"입력/수정"));
   
      
      //기본정보
      basicInfoP = new JPanel();
      basicInfoP.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "기본 정보"));
      basicInfoP.setLayout(new GridLayout(4,1));
      
      JPanel siteP = new JPanel(new FlowLayout(FlowLayout.LEFT));
      siteP.add(new JLabel("사이트명"));
      siteTF = new JTextField(14);
      siteP.add(siteTF);
      
      JPanel addrP = new JPanel(new FlowLayout(FlowLayout.LEFT));
      addrP.add(new JLabel("주소(URL) http://", JLabel.LEFT));
      addrTF = new JTextField(10);
      addrP.add(addrTF);

      JPanel idP = new JPanel(new FlowLayout(FlowLayout.LEFT));
      idP.add(new JLabel("아  이  디", JLabel.LEFT));
      idTF = new JTextField(7);
      idP.add(idTF);
      
      JPanel passP = new JPanel(new FlowLayout(FlowLayout.LEFT));
      passP.add(new JLabel("비밀번호", JLabel.LEFT));
      passTF = new JTextField(7);
      //passTF.setEchoChar('*');
      passP.add(passTF);
      
      Changed();
     
      basicInfoP.add(siteP);
      basicInfoP.add(addrP);
      basicInfoP.add(idP);
      basicInfoP.add(passP);
      
      //추가정보
      
      addInfoP = new JPanel(new BorderLayout());
      addInfoP.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "추가 정보"));
      
      JPanel addText = new JPanel(new GridLayout(2,1));
      JPanel addField = new JPanel();
      
      addInfoP.add(addText, BorderLayout.NORTH);
      addInfoP.add(addField, BorderLayout.CENTER);

      //분류
      JPanel groupP = new JPanel(new FlowLayout(FlowLayout.LEFT));
      groupP.add(new JLabel("분     류"));
      group1Combo = new JComboBox<String>(group1);
      groupP.add(group1Combo);
      
      //선호도
      JPanel prefP = new JPanel(new FlowLayout(FlowLayout.LEFT));
         prefP.add(new JLabel("선호도"));
         group2Combo = new JComboBox<String>(group2);
         prefP.add(group2Combo);

         //메모
         JPanel memoP = new JPanel(new FlowLayout(FlowLayout.LEFT));       
         memoP.add(new JLabel("메  모"));
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
      
      //새로작성, 입력 버튼
      btnP = new JPanel(new FlowLayout(FlowLayout.RIGHT));
      JButton btn1 = new JButton("새로 작성(N)");
      JButton btn2 = new JButton("입력(I)");
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
   
   //오른쪽 탭 화면 구성
   private JTabbedPane createTabbedPane() {
      JTabbedPane pane = new JTabbedPane();
      this.add(pane, BorderLayout.CENTER);
      JPanel tabPanel = new JPanel();
      tabPanel.setLayout(new BorderLayout());
      
      
      pane.addTab("사이트 목록", tabPanel);
      pane.addTab("등록현황", new JButton("테스트"));
 
      //검색 정렬
      JPanel searchArrayP = new JPanel();
      tabPanel.add(searchArrayP, BorderLayout.NORTH);
      searchArrayP.setLayout(new BorderLayout());
      searchArrayP.setBorder(new TitledBorder(new LineBorder(Color.black,1),"검색/정렬"));
      
      //검색
      JPanel searchP = new JPanel();
      
      searchP.setBorder(new TitledBorder(new LineBorder(Color.black,1),"검색"));
      group3Combo = new JComboBox<String>(group1);
      
      JLabel filterL = new JLabel("필터 : ");
      filterTF = new JTextField(7);
      
      searchP.add(group3Combo);
      searchP.add(filterL);
      searchP.add(filterTF);

      //정렬
      JPanel arrayP = new JPanel();
      //arrayP.setLayout(new BorderLayout());
      arrayP.setBorder(new TitledBorder(new LineBorder(Color.black,1),"정렬")); // 테두리
     
      JPanel arrayPanel = new JPanel();
      arrayP.add(arrayPanel, BorderLayout.SOUTH);
      //arrayP.add(arrayPanel);
      
      group4Combo = new JComboBox<String>(group4);
      group5Combo = new JComboBox<String>(group4);
          
      btn1 = new JButton("정렬");
      btn2 = new JButton("기본");
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
      
      
      //표
      
      tablePanel.setLayout(new BorderLayout());
      tabPanel.add(tablePanel, BorderLayout.CENTER);
		
	//model = new InfoTableModel();
      dtm = new DefaultTableModel();
      dtm.setColumnIdentifiers(new String[] {"분류 ", "선호도", "사이트 이름","사이트 주소"});
		table = new JTable(dtm);
		table.setRowHeight(30);
		
		table.setAutoCreateRowSorter(true); // 자동 행 정렬
		
		tablePanel.add(new JScrollPane(table));
		tableRow(); // 표 행
      
      //계정정보
     JPanel viewPanel = new JPanel(new BorderLayout()); // 계정정보 보기 패널
     tabPanel.add(viewPanel, BorderLayout.SOUTH);
     
    check = new JCheckBox("계정정보 보기");
     JLabel idl = new JLabel("아이디");
     JTextField idTF_bottom = new JTextField(7); //#공용
     JLabel passl = new JLabel("비밀번호");
     JTextField passTF_bottom = new JTextField(7); //# 공용
     deleteB = new JButton("삭제");
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
   
   // 표 행 클릭했을때
   private void tableRow() {
	   table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		   public void valueChanged(ListSelectionEvent e) {
			   	Vector<SiteInfo> list = new Vector<SiteInfo>();
   				list.addAll(infoList.getSiteInfo());
   			
	   			int Row = table.getSelectedRow(); // 선택 된 열 알아내기
	   			SiteInfo s = list.get(Row);
	   			
	   			
		   }
	   });
	   
   }
   
   // 사이트 개수 나타내기
   private JPanel siteNum() {
	   JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
	   this.add(p, BorderLayout.SOUTH);
	   
	   p.setBorder(BorderFactory.createLoweredBevelBorder());
	   sitenum = new JLabel(dtm.getRowCount()+"개의 사이트가 등록되었습니다.");
	   p.add(sitenum);
	   
	   return p;
   }
   
   ActionListener input = new ActionListener() { // 엑셀 파일 가져오기
	   
	   Object[][] data = {
				//HashSet<SiteInfo> data = new HashSet<SiteInfo>();
				//data = {
						//{"일반","☆", "사람만이","sarammani.com"},
						//{"대학","", "덕성여자대학교","www.duksung.ac.kr" }
				};
	   @Override
	   public void actionPerformed(ActionEvent e) {
		 /*  // 파일을 만들 위치 및 파일명
		   FileOutputStream fos = new FileOutputStream(new File("C://singgo.xls"));
		   
		   // 엑셀을 workbook을 만듭니다.
		   HSSFWorkbook wb = new HSSFWorkbook();
	
		   // Sheet를 만들어요. 이름은 Name
		   HSSFSheet sheet = wb.createSheet("Name");
	
		   // 앞으로 사용할 row와 cell이에요
		   HSSFRow row = null;
		   HSSFCell cell = null;
	
		   // 저장될 데이터를 루프를 돌면서 기록합니다.
		   for(int i=0; i<data.length; i++) {
	
		    // row를 만들어요
		    row = sheet.createRow(i);
	
		    // 각 cell에 데이터를 입력하여줍니다.
		    cell = row.createCell(0);
		    cell.setCellValue(data[i][0]);
		    cell = row.createCell(1);
		    cell.setCellValue(data[i][1]);
	
		   }
		   // file을 만듭니다.
		   wb.write(fos);
	
		   // close는 메모리 누수를 방지하기 위하여 필수
		   if(fos != null) {
		    fos.close();
	
		   }*/
	   }
   };
   
   
   
   
   ActionListener save = new ActionListener() { // 파일 - 저장

      @Override
      public void actionPerformed(ActionEvent e) {
         JFileChooser chooser = new JFileChooser();
         
         int ret = chooser.showSaveDialog(SiteInfoManagerApp.this);
         if (ret == JFileChooser.APPROVE_OPTION) { // 저장 버튼 누른 경우
            String fileName = chooser.getSelectedFile().getName(); // 파일 이름
            JOptionPane.showMessageDialog(SiteInfoManagerApp.this, fileName, "확인", JOptionPane.INFORMATION_MESSAGE);
         }
         else if (ret == JFileChooser.CANCEL_OPTION) { // 취소 버튼 누른 경우
            JOptionPane.showMessageDialog(SiteInfoManagerApp.this, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
            return;
         }
      }
   };
   
   ActionListener exit = new ActionListener() { // 파일 - 종료

      @Override
      public void actionPerformed(ActionEvent e) {
         int result = JOptionPane.showConfirmDialog(SiteInfoManagerApp.this, "정말 종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION);
         if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
         }
         else return;
         
      }
   };
   
   ActionListener site = new ActionListener() { // 관리 - 사이트 분류

	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	  //CategoryManageDialog category = new CategoryManageDialog();
	    	  
	         
	      }
   };
   
   ItemListener autologin = new ItemListener() { // 설정 - 자동 로그인

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
					if (e.getActionCommand().equals("새로 작성(N)")) { // 새로작성 버튼 클릭하면
						
						String siteTitle = siteTF.getText().toString();
						String siteUrl = addrTF.getText().toString();
						String siteKind = group1Combo.getSelectedItem().toString();
						String siteFv = group2Combo.getSelectedItem().toString();
						String siteId = idTF.getText().toString();
						String sitePwd = passTF.getText().toString();
						String[] s = {siteKind,siteFv,siteTitle,siteUrl};
						dtm.addRow(s);
						
						//==== [start] 사이트 정보저장 ====
							/*HashMap<String,String> mapInfo = new HashMap<String, String>();
							
							mapInfo.put("siteTitle", siteTitle);
							mapInfo.put("siteUrl", siteUrl);
							mapInfo.put("siteKind", siteKind);
							mapInfo.put("siteFv", siteFv);
							mapInfo.put("siteId", siteId);
							mapInfo.put("sitePwd", sitePwd);
							
							siteInfoList.add(mapInfo);*/
						//==== [END] 사이트 정보저장 ====
							
						
						siteTF.setText("");
						addrTF.setText("");
						idTF.setText("");
						passTF.setText("");
						
						sitenum.setText(dtm.getRowCount()+"개의 사이트가 등록되었습니다.");
					}
					
					//if(e.getSource().equals(dtm)) { // 표를 클릭하면
						
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
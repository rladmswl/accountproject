import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CategoryManageDialog extends JFrame{
   
   private JList RL;
   private JTextField LNameTF;
   private JButton DeleteB;
   private JButton AddB;
   private JButton NewB;
   private JButton CompleteB; 
   
   private String[] g0 = {"정보","포털", "학교"};
   
   private int siteSet;
   private ArrayList<String> list = new ArrayList<>(siteSet);

   
   
   public CategoryManageDialog() {
      setTitle("사이트 분류 관리");
      
      
   //   buildGUI();
      //등록항목
      this.setLayout(new GridLayout(1,2));
      this.add(Register());
      this.add(Edit());
      
      setSize(600,400);
      //setResizable()
      setLocation(1000,500);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      setVisible(true);
   }
   
   
   private JPanel Register() { //등록항목
      JPanel RP = new JPanel();
      RP.setLayout(new BorderLayout());
      RP.setBorder(new TitledBorder(new LineBorder(Color.black,1),"등록항목"));
      RL  = new JList(g0); ///*등록항목들 Vector listData*/
      RP.add(RL, BorderLayout.CENTER);
      
      JPanel zP = new JPanel();
      RP.add(zP, BorderLayout.SOUTH);
      
      
      return RP;
   }
   private JPanel Edit() { //편집내용
      JPanel EP0 = new JPanel();
      EP0.setLayout(new BorderLayout());
      
      JPanel EP = new JPanel();
      EP.setLayout(new BorderLayout());
      
      EP.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "편집내용"));
      
      JPanel p0 = new JPanel();
      p0.setLayout(new GridLayout(2,1));
      
      // 편집내용 - (항목이름 -텍스트필드)
      JPanel p1 = new JPanel();
      p1.setLayout(new FlowLayout(FlowLayout.CENTER));
      JLabel ListName = new JLabel("항목이름 ");
      LNameTF = new JTextField(10);
      p1.add(ListName);
      p1.add(LNameTF);
      
   
      
      // 편집내용 - (삭제-추가)버튼
      JPanel p2 = new JPanel();
      p2.setLayout(new FlowLayout(FlowLayout.CENTER));
      DeleteB = new JButton("삭제(D)");
      AddB = new JButton("추가(A)");
      DeleteB.setMnemonic(KeyEvent.VK_D);
      AddB.setMnemonic(KeyEvent.VK_A);
      
      DeleteB.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            
            
         }
         
      });
      
      p2.add(DeleteB);
      p2.add(AddB);
      
      
      
      
      //Button에 대한 Action Listener 추가하기!!
      
      //신규-완료 버튼
      JPanel pp1 = new JPanel();
      NewB = new JButton("신규(N)");
      CompleteB = new JButton("완료(C)");
      NewB.setMnemonic(KeyEvent.VK_N);
      CompleteB.setMnemonic(KeyEvent.VK_C);
      
      pp1.add(NewB);
      pp1.add(CompleteB);
      

      p0.add(p1);
      p0.add(p2);
      
      EP.add(p0, BorderLayout.NORTH);
      EP0.add(EP, BorderLayout.CENTER);
      EP0.add(pp1, BorderLayout.SOUTH) ;
      
      
      return EP0;
      
      
   }
   
   public static void main(String[] args) {
      new CategoryManageDialog();
   }
}
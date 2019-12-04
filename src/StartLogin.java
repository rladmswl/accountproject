import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class StartLogin extends JFrame {
   
   // 바깥 믈릭시 클릭막는 것 해야함!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
   private SiteInfoManagerApp main;
   private SiteInfo siteInfo;
   private JButton loginB;
   private JButton exitB;
   private JTextField passTF;

   
   public StartLogin() {
   
      setTitle("사용자 로그인");
      
      LoginPanel();
      setSize(300,140);
      setResizable(false);
      setLocation(800,450);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      setVisible(true);
      
   }
   
   private void LoginPanel() {
      JPanel pL = new JPanel();
      JPanel pT = new JPanel();
      JPanel pB = new JPanel();
      pL.setLayout(new GridLayout(2,1));
      pB.setLayout(new FlowLayout(FlowLayout.CENTER));
      
      pL.setBorder(new TitledBorder(new LineBorder(Color.black,1),"안녕하세요?"));
      //pL.setLayout(null);
      
      JLabel passL = new JLabel("비밀번호 ");
      passTF = new JTextField(10);
      pT.add(passL);
      pT.add(passTF);
      //passL.setBounds(r);
      
   
      loginB = new JButton("로그인");
      exitB= new JButton("종료");
      
      pB.add(loginB);   
      pB.add(exitB);   
      
   
      loginB.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            check();
            
         }
         
      });
      
      exitB.addActionListener( new ActionListener() { // 종료

            @Override
            public void actionPerformed(ActionEvent e) {
               int result = JOptionPane.showConfirmDialog(StartLogin.this, "정말 종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION);
               if (result == JOptionPane.YES_OPTION) {
                  System.exit(0);
               }
               else return;
               
            }
         });
      
      pL.add(pT);
      pL.add(pB);
      this.add(pL);
   
   }
   
   public void check() {
      if(passTF.getText().equals("0000")) {
         main.showSiteInfo();
      }
      else {
         passTF.setText("");
      }
      
   }
   public void setMain(SiteInfoManagerApp main) {
      this.main = main;
   }
   
public static void main(String[] args) {
      new StartLogin(); //맞나?
   }
}
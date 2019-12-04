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
   
   // �ٱ� �ɸ��� Ŭ������ �� �ؾ���!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
   private SiteInfoManagerApp main;
   private SiteInfo siteInfo;
   private JButton loginB;
   private JButton exitB;
   private JTextField passTF;

   
   public StartLogin() {
   
      setTitle("����� �α���");
      
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
      
      pL.setBorder(new TitledBorder(new LineBorder(Color.black,1),"�ȳ��ϼ���?"));
      //pL.setLayout(null);
      
      JLabel passL = new JLabel("��й�ȣ ");
      passTF = new JTextField(10);
      pT.add(passL);
      pT.add(passTF);
      //passL.setBounds(r);
      
   
      loginB = new JButton("�α���");
      exitB= new JButton("����");
      
      pB.add(loginB);   
      pB.add(exitB);   
      
   
      loginB.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            check();
            
         }
         
      });
      
      exitB.addActionListener( new ActionListener() { // ����

            @Override
            public void actionPerformed(ActionEvent e) {
               int result = JOptionPane.showConfirmDialog(StartLogin.this, "���� �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION);
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
      new StartLogin(); //�³�?
   }
}
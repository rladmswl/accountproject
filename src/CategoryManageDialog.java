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
   
   private String[] g0 = {"����","����", "�б�"};
   
   private int siteSet;
   private ArrayList<String> list = new ArrayList<>(siteSet);

   
   
   public CategoryManageDialog() {
      setTitle("����Ʈ �з� ����");
      
      
   //   buildGUI();
      //����׸�
      this.setLayout(new GridLayout(1,2));
      this.add(Register());
      this.add(Edit());
      
      setSize(600,400);
      //setResizable()
      setLocation(1000,500);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      setVisible(true);
   }
   
   
   private JPanel Register() { //����׸�
      JPanel RP = new JPanel();
      RP.setLayout(new BorderLayout());
      RP.setBorder(new TitledBorder(new LineBorder(Color.black,1),"����׸�"));
      RL  = new JList(g0); ///*����׸�� Vector listData*/
      RP.add(RL, BorderLayout.CENTER);
      
      JPanel zP = new JPanel();
      RP.add(zP, BorderLayout.SOUTH);
      
      
      return RP;
   }
   private JPanel Edit() { //��������
      JPanel EP0 = new JPanel();
      EP0.setLayout(new BorderLayout());
      
      JPanel EP = new JPanel();
      EP.setLayout(new BorderLayout());
      
      EP.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "��������"));
      
      JPanel p0 = new JPanel();
      p0.setLayout(new GridLayout(2,1));
      
      // �������� - (�׸��̸� -�ؽ�Ʈ�ʵ�)
      JPanel p1 = new JPanel();
      p1.setLayout(new FlowLayout(FlowLayout.CENTER));
      JLabel ListName = new JLabel("�׸��̸� ");
      LNameTF = new JTextField(10);
      p1.add(ListName);
      p1.add(LNameTF);
      
   
      
      // �������� - (����-�߰�)��ư
      JPanel p2 = new JPanel();
      p2.setLayout(new FlowLayout(FlowLayout.CENTER));
      DeleteB = new JButton("����(D)");
      AddB = new JButton("�߰�(A)");
      DeleteB.setMnemonic(KeyEvent.VK_D);
      AddB.setMnemonic(KeyEvent.VK_A);
      
      DeleteB.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            
            
         }
         
      });
      
      p2.add(DeleteB);
      p2.add(AddB);
      
      
      
      
      //Button�� ���� Action Listener �߰��ϱ�!!
      
      //�ű�-�Ϸ� ��ư
      JPanel pp1 = new JPanel();
      NewB = new JButton("�ű�(N)");
      CompleteB = new JButton("�Ϸ�(C)");
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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CategoryManageDialog extends JFrame{
   
   private JList list;
   private JTextField LNameTF;
   private JButton DeleteB;
   private JButton AddB;
   private JButton NewB;
   private JButton CompleteB;

   
   //private String[] g0 = {"����","����", "�б�"};
   
   //private HashSet siteSet;
   //private ArrayList<String> list = new ArrayList<>(siteSet);   
   private Vector<String> vector = new Vector<String>();

   private DefaultListModel model;
   
   
   
   public CategoryManageDialog() {
      setTitle("����Ʈ �з� ����");
      
      
   //   buildGUI();
      //����׸�
      this.setLayout(new GridLayout(1,2));
      this.add(Register());
      this.add(Edit());
      
      setSize(500,300);
      //setResizable()
      setLocation(1000,500);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      setVisible(true);
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
      
      AddB.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
         
            String s = LNameTF.getText();
            
            //for(int i =0; i<vector.size(); i++ ) {
            int i =0;
            int count = 0;
            while(i<vector.size()) {
               
               String v_text = ((Vector<String>)vector).elementAt(i);
               System.out.println(v_text);
               if(v_text == s) {
                  LNameTF.setText("");
                  System.out.println("b");
                  break;
               }
               else if (v_text != s){
                  count += 1;
                  //if(count==3) {
               //   vector.add(s);//}
                  LNameTF.setText("");
               System.out.println("c");
               //list.updateUI();
               }
               if(count==vector.size()) {
                  vector.add(s);
                  LNameTF.setText("");
                  list.setListData(vector);
               }
               System.out.println("d");
               i++;
            }
            
            /* //.setListData(vector);
            for(int i=0; i < model.getSize(); i++){ 
               String s = (String)(model.getElementAt(i)); 
                if(LNameTF.getText() == s) {
                   break;
                }
                else
                   model.addElement(LNameTF.getText());
                LNameTF.setText("");
            } 
            
            
            
            
               Iterator it = vector.iterator();
               while(it.hasNext()) {
               
                  if( (String)it.next() == LNameTF.getText()) {
                     break; }
                  else { 
                     vector.addElement(LNameTF.getText());
                     LNameTF.setText("");
                     list.updateUI();
                     
                  }
            
               }*/
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
   private JPanel Register() { //����׸�
      JPanel RP = new JPanel();
      JPanel zP = new JPanel();
      
      RP.setLayout(new BorderLayout());
      RP.setBorder(new TitledBorder(new LineBorder(Color.black,1),"����׸�"));
      
      vector.addElement("����");
      vector.addElement("����");
      vector.addElement("�б�");
      list  = new JList(vector); ///*����׸�� Vector listData*/
      /*list = new JList(new DefaultListModel());
      model = (DefaultListModel) list.getModel();
      model.addElement("����");
      model.addElement("����");
      model.addElement("�б�");*/
   
      RP.add(list, BorderLayout.CENTER);
      RP.add(zP, BorderLayout.SOUTH);
      
      
      return RP;
   }
   
   public static void main(String[] args) {
      new CategoryManageDialog();
   }
}
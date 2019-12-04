import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SiteDetailInfo extends SiteInfo{
	
	private JPanel addInfoP;
	
	private String[] group1 = {"�Ϲ�", "�б�","����","����"};
	private String[] group2 = {"������","��", "�١�","�١١�","�١١١�","�١١١١�"};
	   
	private JComboBox<String> group1Combo;
	private JComboBox<String> group2Combo;
	
	private JTextArea textA;
	 
    public JPanel SiteDetailInfo() {
       //super();
    
       addInfoP = new JPanel();
       addInfoP.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "�߰� ����"));
       addInfoP.setLayout(new GridLayout(3,1));

       //�з�
       JPanel groupP = new JPanel(new FlowLayout(FlowLayout.LEFT));
       groupP.add(new JLabel("�з�"));
       group1Combo = new JComboBox<String>(group1);
       groupP.add(group1Combo);
       
       //��ȣ��
       JPanel prefP = new JPanel(new FlowLayout(FlowLayout.LEFT));
          prefP.add(new JLabel("��ȣ��"));
          group2Combo = new JComboBox<String>(group2);
          prefP.add(group2Combo);

          //�޸�
          JPanel memoP = new JPanel(new FlowLayout(FlowLayout.LEFT));       
          memoP.add(new JLabel("�޸�"));
          textA = new JTextArea(7,15);
          memoP.add(textA);
     
     
       
       addInfoP.add(groupP);
       addInfoP.add(prefP);
       addInfoP.add(memoP);
       
      return addInfoP;
    }

}

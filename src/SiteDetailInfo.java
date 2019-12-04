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
	
	private String[] group1 = {"일반", "학교","정보","포털"};
	private String[] group2 = {"미지정","☆", "☆☆","☆☆☆","☆☆☆☆","☆☆☆☆☆"};
	   
	private JComboBox<String> group1Combo;
	private JComboBox<String> group2Combo;
	
	private JTextArea textA;
	 
    public JPanel SiteDetailInfo() {
       //super();
    
       addInfoP = new JPanel();
       addInfoP.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "추가 정보"));
       addInfoP.setLayout(new GridLayout(3,1));

       //분류
       JPanel groupP = new JPanel(new FlowLayout(FlowLayout.LEFT));
       groupP.add(new JLabel("분류"));
       group1Combo = new JComboBox<String>(group1);
       groupP.add(group1Combo);
       
       //선호도
       JPanel prefP = new JPanel(new FlowLayout(FlowLayout.LEFT));
          prefP.add(new JLabel("선호도"));
          group2Combo = new JComboBox<String>(group2);
          prefP.add(group2Combo);

          //메모
          JPanel memoP = new JPanel(new FlowLayout(FlowLayout.LEFT));       
          memoP.add(new JLabel("메모"));
          textA = new JTextArea(7,15);
          memoP.add(textA);
     
     
       
       addInfoP.add(groupP);
       addInfoP.add(prefP);
       addInfoP.add(memoP);
       
      return addInfoP;
    }

}

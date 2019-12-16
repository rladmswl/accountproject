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
	private String group;
	private String prefer;
	private String memo;
	
	SiteDetailInfo(String siteName, String url, String id, String pw, String group, String prefer, String memo) {
		super(siteName, url, id, pw);
		this.group = group;
		this.prefer = prefer;
		this.memo = memo;
	}
	
	String getGroup() {
		return group;
	}
	String getPrefer() {
		return prefer;
	}
	String getMemo() {
		return memo;
	}
	
	void setGroup(String group) {
		this.group = group;
	}
	void setPrefer(String prefer) {
		this.prefer = prefer;
	}
	void setMemo(String memo) {
		this.memo = memo;
	}

}

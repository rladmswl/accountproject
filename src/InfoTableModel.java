import java.util.HashSet;

import javax.swing.table.AbstractTableModel;

public class InfoTableModel extends AbstractTableModel{
	String[] columNames = {"분류 ", "선호도", "사이트 이름","사이트 주소"};

	Object[][] data = {
	//HashSet<SiteInfo> data = new HashSet<SiteInfo>();
	//data = {
			//{"일반","☆", "사람만이","sarammani.com"},
			//{"대학","", "덕성여자대학교","www.duksung.ac.kr" }
	};
	
	@Override
	public String getColumnName(int column) { // 헤드부분 출력
		return columNames[column];
	}

	@Override
	public int getColumnCount() {
		return columNames.length;
	}

	@Override
	public int getRowCount() {
		return data.length;
		//return data.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}
	
}

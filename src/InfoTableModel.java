import java.util.HashSet;

import javax.swing.table.AbstractTableModel;

public class InfoTableModel extends AbstractTableModel{
	String[] columNames = {"분류 ", "선호도", "사이트 이름","사이트 주소"};

	Object[][] data = {
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
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false; // 김은지 : 전제 수정 불가능.
	}
	
}

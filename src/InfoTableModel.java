import java.util.HashSet;

import javax.swing.table.AbstractTableModel;

public class InfoTableModel extends AbstractTableModel{
	String[] columNames = {"�з� ", "��ȣ��", "����Ʈ �̸�","����Ʈ �ּ�"};

	Object[][] data = {
	};
	
	@Override
	public String getColumnName(int column) { // ���κ� ���
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
		return false; // ������ : ���� ���� �Ұ���.
	}
	
}

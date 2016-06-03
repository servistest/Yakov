package jtable;
import javax.swing.*;
import javax.swing.table.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class DateCellEditor extends AbstractCellEditor implements TableCellEditor {
// �������� - ���������������� ������
	private JSpinner spinner;
	
// �����������
	public DateCellEditor()  {
// ����������� ���������������� ������

		SpinnerModel model = new SpinnerDateModel();
		spinner = new JSpinner(model);
		spinner.setEditor(new JSpinner.DateEditor(spinner,"dd.mm.yyyy"));

	}
	
// ���������� ���������, ����������� ��� ��������������
	public java.awt.Component getTableCellEditorComponent(
			JTable table, Object value, boolean isSelected, int row, int column) {
		// ������ �������� � ���������� ������
		spinner.setValue(value);
		return spinner;
	}
	
// ���������� ������� �������� � ���������
	public Object getCellEditorValue() {
		return spinner.getValue();
	}
}
package jtable;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class NumberCellEditor extends AbstractCellEditor implements TableCellEditor {
	
	private static final long serialVersionUID = 1L;
	JComboBox<String> comboBox;
	String[] listNumber={"1","2","3","4"};
	
	public NumberCellEditor() {
		comboBox=new JComboBox<>(listNumber);
		
		DefaultCellEditor editor=new DefaultCellEditor(comboBox);
		
	}
	
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return comboBox.getSelectedItem();
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		
		comboBox.setSelectedItem(value);
		return comboBox;
		
	}
	

}

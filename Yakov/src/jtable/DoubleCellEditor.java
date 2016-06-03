package jtable;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class DoubleCellEditor extends AbstractCellEditor implements TableCellEditor {
	
	private static final long serialVersionUID = 1L;
	JComboBox<Double> comboBox;
	Double[] listNumber={1d,2d,3d,4d};
	
	public DoubleCellEditor() {
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

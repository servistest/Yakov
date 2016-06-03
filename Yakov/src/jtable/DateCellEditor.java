package jtable;
import javax.swing.*;
import javax.swing.table.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class DateCellEditor extends AbstractCellEditor implements TableCellEditor {
// редактор - прокручивающийся список
	private JSpinner spinner;
	
// конструктор
	public DateCellEditor()  {
// настраиваем прокручивающийся список

		SpinnerModel model = new SpinnerDateModel();
		spinner = new JSpinner(model);
		spinner.setEditor(new JSpinner.DateEditor(spinner,"dd.mm.yyyy"));

	}
	
// возвращает компонент, применяемый для редактирования
	public java.awt.Component getTableCellEditorComponent(
			JTable table, Object value, boolean isSelected, int row, int column) {
		// меняем значение и возвращаем список
		spinner.setValue(value);
		return spinner;
	}
	
// возвращает текущее значение в редакторе
	public Object getCellEditorValue() {
		return spinner.getValue();
	}
}
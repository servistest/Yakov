package jtable;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class DatabaseModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Object> columnNames=new ArrayList<>();
	private ArrayList<Object> columnTypes=new ArrayList<>();
	public ArrayList<Object> data=new ArrayList<>();

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return ((ArrayList<?>)data.get(rowIndex)).get(columnIndex);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
	//	System.out.println((Class)columnTypes.get(columnIndex));
		return (Class<?>)columnTypes.get(columnIndex);
		
	}

	@Override
	public String getColumnName(int column) {
	
			return (String)columnNames.get(column);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
		((ArrayList<Object>)data.get(rowIndex)).set(columnIndex, aValue);
	//	fireTableDataChanged();
		fireTableCellUpdated(rowIndex, columnIndex-1);
	}
	
	public ArrayList<Object> getRow(int rowIndex){
		return (ArrayList<Object>) data.get(rowIndex);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		 if(columnIndex!=0) {
			 return true;
		} else return false;
	}

	public void setDataSource(ResultSet resultSet) throws SQLException, ClassNotFoundException{
		data.clear();
		columnNames.clear();
		columnTypes.clear();
		
		ResultSetMetaData metaData = resultSet.getMetaData();
		Integer columnCount= metaData.getColumnCount();
		if (resultSet==null){
			System.out.println("!!Not data!!");
			
		}
		for (int i=0;i<columnCount;i++){
			columnNames.add(metaData.getColumnName(i+1));
			Class type=	Class.forName(metaData.getColumnClassName(i+1));
			columnTypes.add(type);
		
				
		}
		fireTableStructureChanged();
		
		while(resultSet.next()){
			ArrayList<Object> row=new ArrayList<>();
			for(int i=0;i<columnCount;i++){
				if(columnTypes.get(i)==String.class){
					row.add(resultSet.getString(i+1));
				}else{
					row.add(resultSet.getObject(i+1));
				}
				
			}
			data.add(row);
			//fireTableDataChanged();
			fireTableRowsInserted(data.size()-1, data.size()-1);
			//fireTableRowsDeleted(data.size()-1, data.size()-1);
		}
		
		
	}	
}

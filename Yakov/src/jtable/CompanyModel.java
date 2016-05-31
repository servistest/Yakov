package jtable;


import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class CompanyModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private static ArrayList<Company> modelComplany=new ArrayList<>();
	private static String[] nameCount={"ID","Symbol","Quanity","Price","DateOrder"};
	
	
	 CompanyModel() {
		modelComplany.add(new Company(1,"ABC","230",105.36,LocalDate.of(2016,3, 15)));
		modelComplany.add(new Company(2,"CDE","300",32.36,LocalDate.of(2012,2, 11)));
		modelComplany.add(new Company(3,"AEPL","40",320.36,LocalDate.of(2013,8, 13)));
		modelComplany.add(new Company(4,"IBM","50",32.36,LocalDate.of(2014,4, 14)));
		modelComplany.add(new Company(5,"CIS","30",12.36,LocalDate.of(2015,2, 15)));
	
		
	}
	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return modelComplany.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		switch (column) {
		case 0: return modelComplany.get(row).getOrderID();				
		case 1: return modelComplany.get(row).getSymbol();			
		case 2: return modelComplany.get(row).getQuanity();			
		case 3: return modelComplany.get(row).getPrice();		
		case 4: return modelComplany.get(row).getDateOrder();			
		default:return "";
		} 
	}
	//public void set
	public String getColumnName(int col) {
		return nameCount[col];
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		//return columnIndex==3;
		return true;
	}
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0: modelComplany.get(rowIndex).setOrderID((Integer.parseInt((String) aValue)));break;				
		case 1: modelComplany.get(rowIndex).setSymbol((String)aValue);break;			
		case 2: modelComplany.get(rowIndex).setQuanity((String)aValue);break;			
		case 3: modelComplany.get(rowIndex).setPrice(Double.parseDouble((String)aValue));break;		
		case 4: modelComplany.get(rowIndex).setDateOrder((LocalDate.parse(aValue.toString())));break;			
		default:break;
		} 
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return super.getColumnClass(columnIndex);
	}
	
	
}

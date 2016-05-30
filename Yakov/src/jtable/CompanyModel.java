package jtable;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CompanyModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private static ArrayList<Company> modelComplany=new ArrayList<>();
	private static String[] nameCount={"ID","Symbol","Quanity","Price","DateOrder"};
	
	 CompanyModel() {
		
		modelComplany.add(new Company(1,"ABC","230",105.36,new Date(2016-02-06)));
		modelComplany.add(new Company(2,"CDE","300",32.36,new Date(2016-03-05)));
		modelComplany.add(new Company(3,"AEPL","40",320.36,new Date(2016-04-01)));
		modelComplany.add(new Company(4,"IBM","50",32.36,new Date(2016-02-06)));
		modelComplany.add(new Company(5,"CIS","30",12.36,new Date(2013-02-06)));
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
	public String getColumnName(int col) {
		return nameCount[col];
	}

}

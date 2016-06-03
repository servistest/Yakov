package jtable;

import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class CompanyFormWithRender extends JFrame implements TableModelListener{

	 static final long serialVersionUID = 1L;
	 CompanyModel companyModel;
	 JTable table;
	 
	 TableColumn column ;

	
	    CompanyFormWithRender (String title) {
		super(title);
		companyModel =new CompanyModel();
		
		table=new JTable(companyModel);
	
		add(new JScrollPane(table));
		companyModel.addTableModelListener(this);
		
		TableColumn column = table.getColumnModel().getColumn(3);

	
		column.setCellRenderer(
				  new DefaultTableCellRenderer(){ 
		    public Component  getTableCellRendererComponent( 
		             JTable table, Object value, boolean isSelected, 
		                       boolean hasFocus, int row, int col) { 

		         JLabel label = (JLabel) super.getTableCellRendererComponent(
		               table, value, isSelected, hasFocus, row, col); 

		       // right-align the price value   
		       label.setHorizontalAlignment(JLabel.RIGHT);
		       
		       // display stocks that cost more than $100 in red
		       if (((Double) value)>100){
		          label.setForeground(Color.RED);
		       } else{
		    	   label.setForeground(Color.BLACK); 
		       }
		 
		       return label; 

		      } // end of getTableCellRendererComponent
		     }  // end of new DefaultTableCellRenderer
		  );    // end of setCellRenderer(...)
		   
		 }

	    public void tableChanged(TableModelEvent e) {
	    	  // Code to process data changes goes here
	        	
	    		 System.out.println("Someone changed the data in JTable!");
	    	 }
	public static void main(String[] args) {
		CompanyFormWithRender company=new CompanyFormWithRender("Order of company");
		company.setBounds(400, 300, 200, 200);
		company.pack();
		company.setDefaultCloseOperation(EXIT_ON_CLOSE);
		company.setVisible(true);
	}


	

}

package jtable;






import java.awt.Color;
import java.awt.Dimension;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class CompanyForm extends JFrame implements TableModelListener{

	private CompanyModel companyModel;
	
	  public  CompanyForm (String title) {
		super(title);
		companyModel =new CompanyModel();
		companyModel.addTableModelListener(this);
		JTable table=new JTable(companyModel);
		table.setIntercellSpacing(new Dimension(5, 5));
		table.setSelectionForeground(Color.blue);
		table.setSelectionBackground(Color.GREEN);
		
		add(new JScrollPane(table));
		
		
	}

	public static void main(String[] args) {
		
		CompanyForm company=new CompanyForm("Order of company");
		company.pack();
		company.setDefaultCloseOperation(EXIT_ON_CLOSE);
		company.setVisible(true);

	}

	@Override
	public void tableChanged(TableModelEvent e) {
		System.out.println("Change date ");
		
	}

}

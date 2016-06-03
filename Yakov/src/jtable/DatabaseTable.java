package jtable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class DatabaseTable extends JFrame implements TableModelListener{

	private static final long serialVersionUID = 1L;
	private DatabaseModel databaseModel;
	private JTable table;
		
	  public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
		  String sql = "SELECT * FROM COMPANY";
		  PreparedStatement pstm=con.prepareStatement(sql);
		  return pstm;
		  
	  }	
	  public  void selectData() {
		  	  
		  try(
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
				 PreparedStatement pstm =createPreparedStatement(con); 
				 ResultSet resultSet=pstm.executeQuery();
			){
				databaseModel=new DatabaseModel();
				databaseModel.setDataSource(resultSet);
				databaseModel.addTableModelListener(this);
				table=new JTable(databaseModel);
				table.setDefaultEditor(Date.class, new DateCellEditor());
				table.setDefaultEditor(Double.class, new DoubleCellEditor());
				table.setDefaultEditor(Number.class, new NumberCellEditor());
				this.add(new JScrollPane(table));
			 
		  }catch (SQLException | ClassNotFoundException e) {
			  System.out.println( e.getMessage());
		}
	
	  }
	
	 DatabaseTable (String title) {	  
		super(title);
		selectData();
		
	}
	 public void updateDatabaseCompany() {
		
	}
	 @Override
		public void tableChanged(TableModelEvent e) {
			System.out.println("GetType=" +e.getType() + " Column=" + (e.getColumn()+1) +" FirstRow=" + e.getFirstRow());
			System.out.println(databaseModel.getValueAt(e.getFirstRow(),e.getColumn()+1));
			updateDatabaseCompany();
		}

	public static void main(String[] args) {
		
		DatabaseTable databaseTable=new DatabaseTable("Company of database");
		databaseTable.pack();
		databaseTable.setDefaultCloseOperation(EXIT_ON_CLOSE);
		databaseTable.setVisible(true);

	}

}

package jtable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.xml.ws.spi.Invoker;

public class DatabaseTable extends JFrame implements TableModelListener,ActionListener{

	private static final long serialVersionUID = 1L;
	private DatabaseModel databaseModel;
	private JTable table;
	private ManagementCompany mc=null;
	private JButton btnDelete;
		
	  
	  public  void LoadDataToForm(ResultSet resultSet)   {
		  try {
			    databaseModel=new DatabaseModel();
				databaseModel.setDataSource(resultSet);
				databaseModel.addTableModelListener(this);
				table=new JTable(databaseModel);
				table.setDefaultEditor(Date.class, new DateCellEditor());
				table.setDefaultEditor(Double.class, new DoubleCellEditor());
				table.setDefaultEditor(Number.class, new NumberCellEditor());
				
				//this.add(new JScrollPane(table));
				
				JPanel btnPanel=new JPanel();
				btnDelete=new JButton("Delete");
				//btnDelete.setActionCommand("Delete");
				btnPanel.add(add(new JScrollPane(table)));
				btnPanel.add(btnDelete);
				add(btnPanel);
				btnDelete.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if (table.getSelectedRow()>=0){
							deleteRow();
						}else{
							JOptionPane.showMessageDialog(table, "Please, select row " + table.getSelectedRow(),"Warning",JOptionPane.WARNING_MESSAGE);
						}
						
					}
				});
				
				btnPanel.add(btnDelete);
				
				
		  }catch(ClassNotFoundException| SQLException e){
			  System.out.println(e.getMessage());
		  }
	  }  	
	  
	 
	  
	  public void  getDataFromDataBase(){
		mc=ManagementCompany.getInstance();
		LoadDataToForm(mc.selectAllCompany());	
	  } 
	  
	 DatabaseTable (String title) {	  
		super(title);
		getDataFromDataBase();
		
	}
	 
	
	 public void insertRow() {
		 
		
	}
	 public void updateRow(Integer rowIndex,Integer columnIndex)  {
		 Object idCompany =databaseModel.getValueAt(rowIndex, 0);
		 Object updateValue=databaseModel.getValueAt(rowIndex, columnIndex);
		 Object columnName=databaseModel.getColumnName(columnIndex);
		 Object idColumnName =databaseModel.getColumnName(0);		 
		 String type=databaseModel.getColumnClass(columnIndex).toString();
		 String typeName= type.substring(type.lastIndexOf('.')+1);
		 //System.out.println("id =" + idCompany+" columnName="+columnName + " updateValue=" +updateValue+ " class=" + typeName);
		 Thread thread = new Thread("Update company"){
			 public void run(){
				 mc.updateCompany(idColumnName,idCompany,columnName,updateValue,typeName);
			 }
		 };
		 thread.start();
		
		
	}
	 
	 public void reloadTable(){
		 
		 databaseModel=new DatabaseModel();
		 
				try {
					databaseModel.setDataSource(mc.selectAllCompany());
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table.setModel(databaseModel);
			 }
		 
		 
		 /*databaseModel=new DatabaseModel();
		 Thread thread = new Thread("Reload Table"){
			 public void run(){
				try {
					databaseModel.setDataSource(mc.selectAllCompany());
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table.setModel(databaseModel);
			 }
		 };
		 thread.start();
		 */
		 
		 
	
	 public void deleteRow() {
		 Object idCompany= (Long)databaseModel.getValueAt(table.getSelectedRow(), 0);
		 Object idColumnName =databaseModel.getColumnName(0);
		 Thread thread = new Thread("Delete Row"){
			 public void run(){
				 mc.deleteCompany(idColumnName,idCompany);
			
			 }
		 };
		 thread.start();
		 SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				reloadTable();
				
			}
		});
		 
		 
	}
	 
	 @Override
		public void tableChanged(TableModelEvent e)  {
		//	System.out.println("GetType=" +e.getType() + " Column=" + (e.getColumn()+1)  +" FirstRow=" + e.getFirstRow()+ 
		//			" Value=" + databaseModel.getValueAt(e.getFirstRow(),e.getColumn()+1));
				
			switch (e.getType()) {
			case TableModelEvent.INSERT: insertRow();break;
			case TableModelEvent.UPDATE: updateRow(e.getFirstRow(),e.getColumn()+1);break;
			case TableModelEvent.DELETE: deleteRow();break;
			default:
				break;
			}	
		}
	 @Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Delete": 
				
				break;

			default:
				break;
			}
		} 

	public static void main(String[] args) {	
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				DatabaseTable databaseTable=new DatabaseTable("Company of database");
				databaseTable.pack();
				databaseTable.setDefaultCloseOperation(EXIT_ON_CLOSE);
				databaseTable.setVisible(true);
				
			}
		});
		
	}



	
			
		

}

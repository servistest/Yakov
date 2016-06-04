package jtable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class ManagementCompany implements DAOCompany{
	private static ManagementCompany instance;
	private static Connection con;
	
	 
	
	private ManagementCompany(){
		  try{
			  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
		  }	catch (SQLException e) {
				  System.out.println( e.getMessage());
			}	
	}
	public static  synchronized ManagementCompany getInstance() {
		if (instance==null){
			instance=new ManagementCompany();
		} 
		return instance;
	}

	@Override
	public void instertCompany()  {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void updateCompany(Object idColumnName,Object id,Object columnName ,Object updateValue,String typeName){
		String sql = "UPDATE  company SET ";
		sql=sql+" " +columnName.toString()+"=? WHERE "+ idColumnName.toString()+"="+id.toString();
		System.out.println(updateValue);
	
	
		try (
			PreparedStatement prs =con.prepareStatement(sql);
			){		
			switch (typeName) {
			case "Integer":prs.setInt(1,(Integer.parseInt(updateValue.toString())));break;
			case "Long":prs.setLong(1, Long.parseLong(updateValue.toString()));break;	
			case "Double":prs.setDouble(1, (Double)updateValue);break;
			case "String":prs.setString(1, (String)updateValue);break;
			case "Date":prs.setDate(1,  new Date(((java.util.Date)updateValue).getTime()));break;
			default:System.out.println("Error type Class=" + typeName);	break;
			}
			System.out.println(prs.execute());
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
				
		System.out.println(sql);
	
	}

	@Override
	public ResultSet selectAllCompany()  {
		ResultSet resultSet=null;
		String sql = "SELECT * FROM COMPANY";
		
		try {
			PreparedStatement prs=con.prepareStatement(sql);
			resultSet=prs.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
		
	}

	
}		  


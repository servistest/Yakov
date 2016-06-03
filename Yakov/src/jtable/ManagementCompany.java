package jtable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagementCompany implements DAOCompany{
	private static ManagementCompany instance;
	private static Connection con;
	
	  public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
		  String sql = "SELECT * FROM COMPANY";
		  PreparedStatement pstm=con.prepareStatement(sql);
		  return pstm;
	  	 //PreparedStatement pstm =createPreparedStatement(con); 
		 //ResultSet resultSet=pstm.executeQuery();  
	  }
	
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
	public void updateCompany(Object idColumnName,Object id,Object columnName ,Object updateValue){
		String sql = "UPDATE  company SET ";
		sql=sql+" " +columnName.toString()+"="+ updateValue.toString()+ " WHERE "+ idColumnName.toString()+"="+id.toString();
		
		/*stmt.setString(1, student.getFirstName());
        stmt.setString(2, student.getPatronymic());
        stmt.setString(3, student.getSurName());
        stmt.setString(4, new String(new char[]{student.getSex()}));
        stmt.setDate(5, new Date(student.getDateOfBirth().getTime()));
        stmt.setInt(6, student.getGroupId());
        stmt.setInt(7, student.getEducationYear());
        stmt.setInt(8, student.getStudentId());
        stmt.execute();
		
		System.out.println(sql);
		
	/*	try {
			PreparedStatement prs=con.prepareStatement(sql);
			resultSet=prs.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	*/	
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


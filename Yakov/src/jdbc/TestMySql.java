package jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.reflect.Executable;
import java.sql.Connection;
import java.sql.Date;

public class TestMySql {
	
	
	
	static ResultSet result;

	public static void main(String[] args) {
		String sql=("SELECT * FROM STUDENTS WHERE firstName=? and dateOfBirth=?");
		try(
			Connection	con= DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
			PreparedStatement prsm= con.prepareStatement(sql);
			 	
		){
			prsm.setString(1, "Иван");
			prsm.setDate(2, Date.valueOf("1990-03-20"));
			result = prsm.executeQuery();
			while(result.next()){
				String firstName=result.getString("firstName");
				String surName=result.getString("surName");
				Date dateOfBirth=result.getDate("dateOfBirth");
				System.out.println(firstName +" " + surName + " "+ dateOfBirth);
			}
			
		}catch (SQLException e){
			System.out.println(e.getMessage());
		}finally{
			try{
				if(result!=null){result.close();}
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
			
		}
		
	}
}

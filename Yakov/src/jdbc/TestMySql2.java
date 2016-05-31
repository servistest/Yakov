package jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;

public class TestMySql2 {
	

	static ResultSet result;
	private static  PreparedStatement createPrepareStatement(Connection con) throws SQLException {
		String sql=("SELECT * FROM STUDENTS WHERE firstName=? and dateOfBirth=?");
		PreparedStatement prs=con.prepareStatement(sql);
		prs.setString(1, "Иван");
		prs.setDate(2, Date.valueOf("1990-03-20"));
		return prs;
	}

	public static void main(String[] args) {
		
		try(
			Connection	con= DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
			PreparedStatement prs= createPrepareStatement(con);
			ResultSet result=prs.executeQuery();
		){
			
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

package jdbc.students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {
	
	private static ResultSet resultSet =null;

	public static void main(String[] args) {
		String sql="SELECT * FROM STUDENTS ";
		try(
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
				Statement statement= con.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				){

				while(resultSet.next()){
					String firstName=resultSet.getString("firstName");
					String surNmae=resultSet.getString("surName");
					Integer groupID=resultSet.getInt("group_id");
					System.out.println(firstName + " " + surNmae +  " " + groupID);
				}
				
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		

	}

}

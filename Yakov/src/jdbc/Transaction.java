package jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;

public class Transaction {
	
	private static PreparedStatement createPrepareStatement(Connection con) throws SQLException {
		String sql=("SELECT * FROM STUDENTS WHERE firstName=? or dateOfBirth>?");
		PreparedStatement prs=con.prepareStatement(sql);
		prs.setString(1, "Иван");
		prs.setDate(2, Date.valueOf("1991-03-20"));
		return prs;
		
	}

	public static void main(String[] args) throws SQLException {
	
		
		try(
			Connection	con= DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
			PreparedStatement prs=createPrepareStatement(con);
				 	
		){
			//http://stackoverflow.com/questions/9260159/java-7-automatic-resource-management-jdbc-try-with-resources-statement
			con.setAutoCommit(false);
			prs.addBatch("insert into students values(22,'Ivan3','Stepanov3','Sergevich','1990-05-03','M',2,2007)");
			prs.addBatch("insert into students values(23,'Ivan3','Stepanov3','Sergevich','1990-05-03','M',2,2007)");
			prs.addBatch("insert into students values(24,'Ivan3','Stepanov3','Sergevich','1990-05-03','M',2,2007)");
			prs.executeBatch();
			con.commit();
			
			
		}catch (SQLException e){
			//con.rollback();
			System.out.println(e.getMessage());
		}
			
	}
		
	}




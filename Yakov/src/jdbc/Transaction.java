package jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;

public class Transaction {
	
	private static PreparedStatement createPrepareStatement(Connection con) throws SQLException {
		String sql=("SELECT * FROM STUDENTS WHERE firstName=? or dateOfBirth>?");
		PreparedStatement prs=con.prepareStatement(sql);
		prs.addBatch("insert into students values(25,'Ivan3','Stepanov3','Sergevich','1990-05-03','M',2,2007)");
		prs.addBatch("insert into students values(26,'Ivan3','Stepanov3','Sergevich','1990-05-03','M',2,2007)");
		stm.addBatch("insert into students values(27,'Ivan3','Stepanov3','Sergevich','1990-05-03','M',2,2007)");
		return prs;
		
	}

	public static void main(String[] args) throws SQLException {
	
		try(
			Connection	con= DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
				
				 	
		){
			//http://stackoverflow.com/questions/9260159/java-7-automatic-resource-management-jdbc-try-with-resources-statement
			con.setAutoCommit(false);
			try(Statement stm=con.createStatement()){		
				stm.addBatch("insert into students values(25,'Ivan3','Stepanov3','Sergevich','1990-05-03','M',2,2007)");
				stm.addBatch("insert into students values(26,'Ivan3','Stepanov3','Sergevich','1990-05-03','M',2,2007)");
				stm.addBatch("insert into students values(27,'Ivan3','Stepanov3','Sergevich','1990-05-03','M',2,2007)");
				stm.executeBatch();
				
			}catch (SQLException e){
				con.rollback();	
				System.out.println("Rollback transaction:" + e.getMessage());
			}
			con.commit();
			con.setAutoCommit(true);
		}

					
	}
		
}




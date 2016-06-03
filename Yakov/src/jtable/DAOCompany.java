package jtable;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DAOCompany {
	
	public void instertCompany()throws SQLException;
	public ResultSet selectAllCompany() throws SQLException;
	public void updateCompany(Object idColumnName,Object id,Object columnName ,Object updateValue);
}

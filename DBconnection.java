package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	private Connection connection;

	public DBconnection(String dbURL,String user,String password )throws ClassNotFoundException,SQLException {
	
		Class.forName("com.mysql.jdbc.Driver");
		
		this.connection = DriverManager.getConnection(dbURL,user,password);
		
	}

	public Connection getConnection()
	{
		return this.connection; //this provides the required connecton for java program 
				
	}

	public void closeConnection() throws SQLException{
		if(this.connection!=null)//to check if the connection exists
			this.connection.close();//close the connection
		
	}
	

	
	
	
	

}

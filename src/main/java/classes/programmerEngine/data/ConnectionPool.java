package classes.programmerEngine.data;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//ConnectionPool class provides a connection pool to all classes
public class ConnectionPool {
	
	//instance variable that holds a ConnectionPool object
		private static ConnectionPool pool = null;
		private static DataSource dataSource = null;
		
		
		//Create an instance of the connection pool
		private ConnectionPool() {
			try {
				InitialContext ic = new InitialContext();
				dataSource = (DataSource) ic.lookup("java:/comp/env/programmersDB");
			}catch(NamingException e) {
				System.err.println(e);
			}
		}
		
		
		//the getInstance() method returns a reference to the ConnectionPoo object
		public static synchronized ConnectionPool getInstance() {
			if(pool == null)
				pool = new ConnectionPool();
			return pool;
		}
		
		//GetConnection() method returns an ConnectionPool object that can be used to access the database
		public Connection getConnection() {
			try {
				return dataSource.getConnection();
			}catch(SQLException e) {
				System.err.println(e);
			}
			return null;
		}
		//freeConnection() method closes the specified connection object
		public void freeConnection(Connection c) {
			try {
				c.close();
			}catch(SQLException e) {
				System.err.println(e);
			}
		}


}

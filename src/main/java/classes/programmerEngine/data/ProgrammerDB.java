package classes.programmerEngine.data;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

import classes.programmerEngine.business.Framework;
import classes.programmerEngine.business.Programmer_2;
import classes.programmerEngine.business.Programming_Language;
import classes.programmerEngine.util.DBUtil;

public class ProgrammerDB {
	
	
	
	
	
	//insert() methods inserts the information of the programmer into a table named 
	//programmersDetail of the programmersDB database
	public static int insert(Programmer_2 programmer) throws SQLException {
		ConnectionPool pool = ConnectionPool.getInstance();  //get an object of the Connection Pool class
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		String query = "INSERT INTO programmerDetail (firstName, lastName, email, pgmr_pswd, pgmr_github, saltPassword) " 
		        + "VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, programmer.getFirstName());
			ps.setString(2, programmer.getLastName());
			ps.setString(3, programmer.getEmail());
			ps.setString(4, programmer.getPassword());
			ps.setString(5, programmer.getGithub_account());
			ps.setString(6, programmer.getSaltPassword());
			return ps.executeUpdate();
		}catch(SQLException e) {
			System.err.println(e);
			return 0;
		}finally {
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
		
	}
	
	
	//Insert the programming language used by the programmer in  
		//programming_language table of programmersDB database
		public static int insertProgrammingLang(Programming_Language progLang) {
			ConnectionPool pool = ConnectionPool.getInstance();
			Connection connection = pool.getConnection();
			PreparedStatement ps = null;
			
			String query = "INSERT INTO programming_language (language_name) " 
			             + "VALUES (?)";
			try {
				ps = connection.prepareStatement(query);
				ps.setString(1, progLang.getProgramming_lang());
				return ps.executeUpdate();
			}catch(SQLException e) {
				System.err.println(e);
				return 0;
			}finally {
				DBUtil.closePreparedStatement(ps);
				pool.freeConnection(connection);
			}
			
		}
	
	
	
	
	//Update() method update programmer details
	public static int update(Programmer_2 programmer) {
		ConnectionPool pool = ConnectionPool.getInstance(); //gets an object of the Connection Pool class
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		String query = "UPDATE programmerDetail, programming_language, programmer_framework "
				+ "SET programmerDetail.firstName = ?, programmerDetail.lastName = ?, programmerDetail.pgmr_pswd = ?, programmerDetail.pgmr_github = ?, programmerDetail.saltPassword = ?, programming_language.language_name = ?, programmer_framework.framework_name = ? "
				+ "WHERE programmerDetail.programmerID = programming_language.langID AND programming_language.langID = programmer_framework.fwkID AND email = ?";
				
				
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, programmer.getFirstName());
			ps.setString(2, programmer.getLastName());
			ps.setString(3, programmer.getPassword());
			ps.setString(4, programmer.getGithub_account());
			ps.setString(5, programmer.getSaltPassword());
			ps.setString(6, programmer.getProgrammingLanguage());
			ps.setString(7, programmer.getFramework());
			ps.setString(8, programmer.getEmail());
			return ps.executeUpdate();
		}catch(SQLException e) {
			System.err.println(e);
			return 0;
		}finally {
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
		
	}
	
	
	
	//Inserts the Framework used by the programmer in  
	//programming_language table of programmersDB database
	public static int insertFramework(Framework framework) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		String query = "INSERT INTO programmer_framework (framework_name) " 
				+ "VALUES (?)";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, framework.getFramework_name());
			return ps.executeUpdate();
			
		}catch(SQLException e) {
			System.err.println(e);
			return 0;
		}finally {
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
		
	}
	
	//checkEmail() methods returns true if the email exists in the email
	//column of the porgrammersDetail table
	//otherwise, returns false
	public static boolean checkEmail(String email) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT email FROM programmerDetail " 
				+ "WHERE email = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			return rs.next();
		}catch(SQLException e) {
			System.err.println(e);
			return false;
		}finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
	}

	public static Programmer_2 selectUser(String email) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT programmerDetail.firstName, programmerDetail.lastName, programmerDetail.email, programmerDetail.pgmr_pswd, programmerDetail.pgmr_github, programming_language.language_name, programmer_framework.framework_name "
				+ "FROM programmerDetail "
				+ "INNER JOIN programming_language on programmerDetail.programmerID = programming_language.langID "
				+ "INNER JOIN programmer_framework on programming_language.langID = programmer_framework.fwkID "
				+ "WHERE email = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			Programmer_2 programmer2 = null;
			while(rs.next()) {
				programmer2 = new Programmer_2();
				programmer2.setFirstName(rs.getString("firstName"));
				programmer2.setLastName(rs.getString("lastName"));
				programmer2.setEmail(rs.getString("email"));
				programmer2.setPassword(rs.getString("pgmr_pswd"));
				programmer2.setGithub_account(rs.getString("pgmr_github"));
				programmer2.setProgramming_Language(rs.getString("language_name"));
				programmer2.setFramework(rs.getString("framework_name"));
			}
			return programmer2;
		}catch(SQLException e) {
			System.err.println(e);
			return null;
		}finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(ps);
			pool.freeConnection(connection);
		}
		
	}
	
	
	//getSalted() method retrieves salt value added to the programmer's password
	public static String getSalted(String email) throws NoSuchAlgorithmException, InvalidKeySpecException {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT email, saltPassword FROM programmerDetail "
				+ "WHERE email = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			Programmer_2 programmer2 = null;
			while(rs.next()) {
				programmer2 = new Programmer_2();
				programmer2.setEmail(rs.getString("email"));
				programmer2.setSaltPassword(rs.getString("saltPassword"));
			}
			return programmer2.getSaltPassword();
		}catch(SQLException e) {
			System.err.println(e);
			return null;
		}finally {
			pool.freeConnection(connection);
			DBUtil.closeStatement(ps);
			DBUtil.closeResultSet(rs);
		}
		
	}
	
	//getPswd() method retrieves programmer's password from programmersDB's prog_pswd table
	public static String getPswd(String email) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT email, pgmr_pswd FROM programmerDetail " 
				+ "WHERE email = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			Programmer_2 programmer = null;
			while(rs.next()) {
				programmer = new Programmer_2();
				programmer.setEmail(rs.getString("email"));
				programmer.setPassword(rs.getString("pgmr_pswd"));
			}
			return programmer.getPassword();
		}catch(SQLException e) {
			System.err.println(e);
			return null;
		}finally {
			pool.freeConnection(connection);
			DBUtil.closePreparedStatement(ps);
			DBUtil.closeResultSet(rs);
		}
	}
	
	
	
	//perform search operations whether based on Programming Language or Framework
	public static List<Programmer_2> findProgrammingLangOrFwk(String proglang) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT programmerDetail.firstName, programmerDetail.lastName, programmerDetail.email, programmerDetail.pgmr_pswd, programmerDetail.pgmr_github, programming_language.language_name, programmer_framework.framework_name "
				+ "FROM programmerDetail "
				+ "INNER JOIN programming_language on programmerDetail.programmerID = programming_language.langID "
				+ "INNER JOIN programmer_framework on programming_language.langID = programmer_framework.fwkID "
				+ "WHERE language_name LIKE ? OR framework_name LIKE ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, "%"+proglang+"%");
			ps.setString(2, "%"+proglang+"%");
			rs = ps.executeQuery();
			ArrayList<Programmer_2> al = new ArrayList<Programmer_2>();
			while(rs.next()) {
				Programmer_2 p = new Programmer_2();
				p.setFirstName(rs.getString("firstName"));
				p.setLastName(rs.getString("lastName"));
				p.setEmail(rs.getString("email"));
				p.setGithub_account(rs.getString("pgmr_github"));
				p.setProgramming_Language(rs.getString("language_name"));
				p.setFramework(rs.getString("framework_name"));
				al.add(p);
			}
			return al;
		}catch(SQLException e) {
			System.err.println(e);
			return null;
		}finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
		
	}
	
	
	//The method below set up a new password for the end-user
	public static int updateProgrammer_Password(String pswd) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		
		String query = "UPDATE programmerDetail"
				+ "SET programmerDetail.pgmr_pswd = ? "
				+ "WHERE email = ?";
		try {
			Programmer_2 p = new Programmer_2();
			ps = connection.prepareStatement(query);
			ps.setString(1, pswd);
			ps.setString(2, p.getEmail());
			return ps.executeUpdate();
		}catch(SQLException e) {
			System.err.println(e);
			return 0;
		}finally {
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
	}
	

}

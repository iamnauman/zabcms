
package com.dal;
import java.sql.*;
public class Database_Controller {
	private static Database_Controller Database_Controller;
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/zabcms";
	static final String USER = "root";
	static final String PASS = "faizan";
	
	//override default constructor to prevent object creation
	private Database_Controller(){}

	//Singleton access to Database Controller
	public static Database_Controller getDatabase_Controller(){
		if(Database_Controller == null){
			Database_Controller = new Database_Controller();
			return Database_Controller;
		} else {
			return Database_Controller;
		}
	}
	
	
	//return Connection on request
	public Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			return conn;
		} catch (final Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//close database related objects
	public void close(final Object... objects) {
		try {
			for (Object object : objects) {
				if (object != null && object instanceof ResultSet) {
					final ResultSet result = (ResultSet) object;
					if (!result.isClosed()) {
						result.close();
					}
				} else if (object != null && object instanceof PreparedStatement) {
					final PreparedStatement stmt = (PreparedStatement) object;
					if (!stmt.isClosed()) {
						stmt.close();
					}
				} else if (object != null && object instanceof Connection) {
					final Connection conn = (Connection) object;
					if (!conn.isClosed()) {
						conn.close();
					}
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return Database_Controller;
	}
	
	

}


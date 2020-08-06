package grant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseManager {
	private Connection connection;
	private ResultSet resultSet;
	private Statement statement;

	public DatabaseManager() {
		
	}

	public void readDataBase() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost/inventory" + "user=root&password=gSQLh1116!");
			System.out.println("successful");

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}
	public void getAllQuery(String query) {
		
	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {

		}
	}

}

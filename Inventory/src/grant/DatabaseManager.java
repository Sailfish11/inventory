package grant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.sql.SQLException;

public class DatabaseManager {
	private Connection connection;
	private static ResultSet resultSet;
	private Statement statement;
	private PreparedStatement pstatement;
	
	private final String username = "root";
	private final String password = "gSQLh1116!";

	public DatabaseManager() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/inventory", username, password);
			statement = connection.createStatement();
			System.out.println("Successfully Connected");
		} catch (Exception e) {
			throw e;
		
	}

	}
	public ResultSet getAllQuery() {
		try {
			resultSet = statement.executeQuery("select * from inventory");
		} catch (Exception e){
			e.printStackTrace();
		}
		return resultSet;
	}
	public void add(String pn, String pr, int q, String de, String c, String da) {
		try {
			String query = "INSERT INTO inventory (ProductName, Price, Quantity, Description, Category, DateAdded)" + 
			" values (?,?,?,?,?,?)";
			pstatement = connection.prepareStatement(query);
			pstatement.setString(1, pn);
			pstatement.setString(2,  pr);
			pstatement.setInt(3, q);
			pstatement.setString(4, de);
			pstatement.setString(5, c);
			pstatement.setString(6, da);
			
			pstatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void delete(int pid) {
		try {
			String query = "DELETE FROM `INVENTORY` WHERE `PRODUCTID` = ?";
			pstatement = connection.prepareStatement(query);
			pstatement.setInt(1, pid);
			
			pstatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void edit(int pid, String colName, String newName) {
		try {
			String query = "UPDATE INVENTORY "
					+ "SET "+colName+ "= ?"
					+ " WHERE PRODUCTID = ?";
			pstatement = connection.prepareStatement(query);
			if (colName.equals("Quantity")) {
				int q = Integer.parseInt(newName);
				pstatement.setInt(1, q);
			} else {
				pstatement.setString(1, newName);
				pstatement.setInt(2, pid);
			}
			pstatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
        
    }

    public void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
        	int ProductID = 1;
            ProductID = resultSet.getInt(ProductID);
            
            String ProductName = resultSet.getString("ProductName");
            
            String Price = resultSet.getString("Price");
            
            int Quantity = 1;
            Quantity = resultSet.getInt(Quantity);
            
            String Description = resultSet.getString("Description");
            
            String Category = resultSet.getString("Category");
            
            String DateAdded = resultSet.getString("DateAdded");
            
            System.out.println("ProductID: " + ProductID);
            System.out.println("ProductName: " + ProductName);
            System.out.println("Price: " + Price);
            System.out.println("Quantity:" + Quantity);
            System.out.println("Description: " + Description);
            System.out.println("Category:" + Category);
            System.out.println("DateAdded:" + DateAdded);
        }
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
	public static void main(String[] args) throws Exception {
		DatabaseManager dbman = new DatabaseManager();
		dbman.getAllQuery();
		dbman.writeMetaData(resultSet);
		dbman.writeResultSet(resultSet);
	}

}

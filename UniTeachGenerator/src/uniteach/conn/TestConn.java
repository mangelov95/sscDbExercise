package uniteach.conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConn {
		Connection dbConn = null;
		String dbName = null;
		
		public TestConn () {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Postresql Driver not found");
			}
			System.out.println("PostgreSQL driver registered.");
			
			System.setProperty("jdbc.drivers", "org.postgresql.Driver");
			dbName = "jdbc:postgresql://dbteach2.cs.bham.ac.uk/uniteach";
		}
		
		public void connect() {
			try {
				dbConn = DriverManager.getConnection(dbName, "mxa487", "brumbrum");
			} catch (SQLException e) {
				System.out.println("Cannot connect.");
				e.printStackTrace();
			}
			if (dbConn != null) {
				System.out.println("Connection to DB successfull.");
			}
			else {
				System.out.println("Failed to make connection.");
			}
		}
		
		public Connection getDbConn() {
			return dbConn;
		}
		
		public void disconnect() {
			try {
				dbConn.close();
				System.out.println("Successfully closed connection to DB.");
			} catch (SQLException e) {
				System.out.println("Couldn't close connection to DB.");
				e.printStackTrace();
			}
		}
}

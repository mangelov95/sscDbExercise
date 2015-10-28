package uniteach.init;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import uniteach.conn.TestConn;
import uniteach.resources.Queries;

public class DBInit {
	private Connection dbConn;

	public DBInit(Connection dbConn) {
		this.dbConn = dbConn;
	}

	public void initAll() {
		this.initTitlesTable();
		this.initRegTypeTable();
		this.initLecturerTable();
		this.initStudentTable();
		this.initLecturerContactTable();
		this.initTutorTable();
		this.initStudentContactTable();
		this.initNOKContactTable();
		this.initStudentRegTable();
	}

	public void initTitlesTable() {
		PreparedStatement stmt = null;
		try {
			stmt = dbConn.prepareStatement(Queries.GEN_TITLES);
			System.out
					.println("Successfully prepared statement for table Titles");
		} catch (SQLException e) {
			System.out.println("Couldn't prepare statement for table Titles.");
			e.printStackTrace();
		}
		try {
			boolean n = stmt.execute();
			System.out.println("Successfully generated table Titles");
		} catch (SQLException e) {
			System.out.println("Couldn't generate table Titles.");
			e.printStackTrace();
		}
	}

	public void initRegTypeTable() {
		PreparedStatement stmt = null;
		try {
			stmt = dbConn.prepareStatement(Queries.GEN_REG_TYPE);
			System.out
					.println("Successfully prepared statement for table Registration Type");
		} catch (SQLException e) {
			System.out
					.println("Couldn't prepare statement for table Registration Type.");
			e.printStackTrace();
		}
		try {
			boolean n = stmt.execute();
			System.out
					.println("Successfully generated table Registration Type");
		} catch (SQLException e) {
			System.out.println("Couldn't generate table Registration Type.");
			e.printStackTrace();
		}
	}

	public void initLecturerTable() {
		PreparedStatement stmt = null;
		try {
			stmt = dbConn.prepareStatement(Queries.GEN_LECTURER);
			System.out
					.println("Successfully prepared statement for table Lecturer");
		} catch (SQLException e) {
			System.out
					.println("Couldn't prepare statement for table Lecturer.");
			e.printStackTrace();
		}
		try {
			boolean n = stmt.execute();
			System.out.println("Successfully generated table Lecturer");
		} catch (SQLException e) {
			System.out.println("Couldn't generate table Lecturer");
			e.printStackTrace();
		}
	}
	
	public void initStudentTable() {
		PreparedStatement stmt = null;
		try {
			stmt = dbConn.prepareStatement(Queries.GEN_STUDENT);
			System.out
					.println("Successfully prepared statement for table Student");
		} catch (SQLException e) {
			System.out
					.println("Couldn't prepare statement for table Student.");
			e.printStackTrace();
		}
		try {
			boolean n = stmt.execute();
			System.out.println("Successfully generated table Student");
		} catch (SQLException e) {
			System.out.println("Couldn't generate table Student");
			e.printStackTrace();
		}
	}
	
	public void initLecturerContactTable() {
		PreparedStatement stmt = null;
		try {
			stmt = dbConn.prepareStatement(Queries.GEN_LEC_CONTACT);
			System.out
					.println("Successfully prepared statement for table LecturerContact.");
		} catch (SQLException e) {
			System.out
					.println("Couldn't prepare statement for table LecturerContact.");
			e.printStackTrace();
		}
		try {
			boolean n = stmt.execute();
			System.out.println("Successfully generated table LecturerContact.");
		} catch (SQLException e) {
			System.out.println("Couldn't generate table LecturerContact.");
			e.printStackTrace();
		}
	}
	
	public void initTutorTable() {
		PreparedStatement stmt = null;
		try {
			stmt = dbConn.prepareStatement(Queries.GEN_TUTOR);
			System.out
					.println("Successfully prepared statement for table Tutor.");
		} catch (SQLException e) {
			System.out
					.println("Couldn't prepare statement for table Tutor.");
			e.printStackTrace();
		}
		try {
			boolean n = stmt.execute();
			System.out.println("Successfully generated table Tutor.");
		} catch (SQLException e) {
			System.out.println("Couldn't generate table Tutor.");
			e.printStackTrace();
		}
	}
	
	public void initStudentContactTable() {
		PreparedStatement stmt = null;
		try {
			stmt = dbConn.prepareStatement(Queries.GEN_STU_CONTACT);
			System.out
					.println("Successfully prepared statement for table StudentContact.");
		} catch (SQLException e) {
			System.out
					.println("Couldn't prepare statement for table StudentContact.");
			e.printStackTrace();
		}
		try {
			boolean n = stmt.execute();
			System.out.println("Successfully generated table StudentContact.");
		} catch (SQLException e) {
			System.out.println("Couldn't generate table StudentContact.");
			e.printStackTrace();
		}
	}
	
	public void initNOKContactTable() {
		PreparedStatement stmt = null;
		try {
			stmt = dbConn.prepareStatement(Queries.GEN_NOK_CONTACT);
			System.out
					.println("Successfully prepared statement for table NextOfKinContact.");
		} catch (SQLException e) {
			System.out
					.println("Couldn't prepare statement for table NextOfKinContact.");
			e.printStackTrace();
		}
		try {
			boolean n = stmt.execute();
			System.out.println("Successfully generated table NextOfKinContact.");
		} catch (SQLException e) {
			System.out.println("Couldn't generate table NextOfKinContact.");
			e.printStackTrace();
		}
	}
	
	public void initStudentRegTable() {
		PreparedStatement stmt = null;
		try {
			stmt = dbConn.prepareStatement(Queries.GEN_STUDENT_REG);
			System.out
					.println("Successfully prepared statement for table StudentRegistration.");
		} catch (SQLException e) {
			System.out
					.println("Couldn't prepare statement for table StudentRegistration.");
			e.printStackTrace();
		}
		try {
			boolean n = stmt.execute();
			System.out.println("Successfully generated table StudentRegistration.");
		} catch (SQLException e) {
			System.out.println("Couldn't generate table StudentRegistration.");
			e.printStackTrace();
		}
	}
	
	public void clearSingleTable(String tableName) {
		String SQLStatement = "DROP TABLE " + tableName;
		PreparedStatement stmt = null;
		try {
			stmt = dbConn.prepareStatement(SQLStatement);
			boolean n = stmt.execute();
			System.out.println("Successfully deleted table " + tableName);
		} catch (SQLException e) {
			System.out.println("Failed when trying to delete table " + tableName);
			e.printStackTrace();
		}
	}
	
	public void wipe() {
		//conn.connect();
		ArrayList<String> tableNames = new ArrayList<String>();
		ResultSet result = null;
		DatabaseMetaData metaData = null;
		try {
			metaData = dbConn.getMetaData();

		} catch (SQLException e) {
			System.out.println("Couldn't retreive DB meta data.");
			e.printStackTrace();
		} finally {
			if (metaData == null) {
				System.out.println("Cannot retreive meta data.");
			}
		}
		if (metaData != null) {
			try {
				result = metaData.getTables(null, null, "%",
						new String[] { "TABLE" });
				while (result.next()) {
					String tableName = result.getString("TABLE_NAME");
					tableNames.add(tableName);
				}
			} catch (SQLException e) {
				System.out.println("Couldn't get tables from meta data.");
				e.printStackTrace();
			} finally {
				if (tableNames.isEmpty()) {
					System.out.println("Database has no tables.");
				}
			}
		}
		if (!tableNames.isEmpty()) {
			PreparedStatement stmt = null;
			Iterator<String> listIter = tableNames.iterator();
			try {
				while (listIter.hasNext()) {
					String SQLStatement = "DROP TABLE " + listIter.next() + " CASCADE";
					stmt = dbConn.prepareStatement(SQLStatement);
					boolean n = stmt.execute();
					listIter.remove();
				}
			} catch (SQLException e) {
				System.out.println("Couldn't drop tables.");
				e.printStackTrace();
			}
			finally {
				System.out.println("Successfully wiped all tables.");
			}
		}
	}

}

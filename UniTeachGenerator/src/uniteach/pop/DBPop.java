package uniteach.pop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import uniteach.resources.Generator;
import uniteach.resources.Person;

public class DBPop {
	private Generator gen;
	private Connection dbConn;

	public DBPop(Connection dbConn) {
		gen = new Generator();
		this.dbConn = dbConn;
	}

	public void populateStudents(int size) {
		PreparedStatement stmt = null;
		Person[] students = new Person[size];
		System.out.println(students.length);
		for (int i = 0; i < students.length; i++) {
			students[i] = new Person();
		}
		gen.generateStudents(students);

		for (int i = 0; i < students.length; i++) {
			int sID = students[i].getId();
			int tID = students[i].getTitle();
			String forename = students[i].getForename();
			String familyName = students[i].getFamilyName();
			String doB = students[i].getDoB();
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date;
			java.sql.Date sqlStartDate = null;
			try {
				date = sdf1.parse(doB);
				sqlStartDate = new java.sql.Date(date.getTime());
			} catch (ParseException e) {
				System.out.println("Cannot parse date");
				e.printStackTrace();
			}
			String values = String.valueOf(sID) + "," + String.valueOf(tID) + "," + forename + "," +
			familyName + "," + doB;
			System.out.println(values);
			try {
				String SQLStatement = "INSERT INTO Student "
									+ "VALUES (?, ?, ?, ?, ?);";
				stmt = dbConn.prepareStatement(SQLStatement);
				stmt.setInt(1, sID);
				stmt.setInt(2, tID);
				stmt.setString(3, forename);
				stmt.setString(4, familyName);
				stmt.setDate(5,sqlStartDate);
				boolean n = stmt.execute();
				System.out.println("SUCCESSS");
			} catch (SQLException e1) {
				System.out.println("Cannot set values.");
				e1.printStackTrace();
			}
		}
	}
	
	public void populateLecturers(int size) {
		PreparedStatement stmt = null;
		Person[] lecturers = new Person[size];
		System.out.println(lecturers.length);
		for (int i = 0; i < lecturers.length; i++) {
			lecturers[i] = new Person();
		}
		gen.generateLecturers(lecturers);

		for (int i = 0; i < lecturers.length; i++) {
			int sID = lecturers[i].getId();
			int tID = lecturers[i].getTitle();
			String forename = lecturers[i].getForename();
			String familyName = lecturers[i].getFamilyName();
			String doB = lecturers[i].getDoB();
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date;
			java.sql.Date sqlStartDate = null;
			try {
				date = sdf1.parse(doB);
				sqlStartDate = new java.sql.Date(date.getTime());
			} catch (ParseException e) {
				System.out.println("Cannot parse date");
				e.printStackTrace();
			}
			String values = String.valueOf(sID) + "," + String.valueOf(tID) + "," + forename + "," +
			familyName + "," + doB;
			System.out.println(values);
			try {
				String SQLStatement = "INSERT INTO Lecturer "
									+ "VALUES (?, ?, ?, ?);";
				stmt = dbConn.prepareStatement(SQLStatement);
				stmt.setInt(1, sID);
				stmt.setInt(2, tID);
				stmt.setString(3, forename);
				stmt.setString(4, familyName);
				boolean n = stmt.execute();
				System.out.println("SUCCESSS");
			} catch (SQLException e1) {
				System.out.println("Cannot set values.");
				e1.printStackTrace();
			}
		}
	}

	public void populateTitles() {
		PreparedStatement stmt = null;
		String SQLStatement = "INSERT INTO Titles " + "VALUES (1, 'MR');";
		String SQLStatement2 = "INSERT INTO Titles " + "VALUES (2, 'MS');";
		String SQLStatement3 = "INSERT INTO Titles " + "VALUES (3, 'MRS');";
		String SQLStatement4 = "INSERT INTO Titles " + "VALUES (4, 'CAPT');";
		String SQLStatement5 = "INSERT INTO Titles " + "VALUES (5,'DOC');";
		try {
			stmt = dbConn.prepareStatement(SQLStatement);
			boolean n = stmt.execute();
			stmt = dbConn.prepareStatement(SQLStatement2);
			n = stmt.execute();
			stmt = dbConn.prepareStatement(SQLStatement3);
			n = stmt.execute();
			stmt = dbConn.prepareStatement(SQLStatement4);
			n = stmt.execute();
			stmt = dbConn.prepareStatement(SQLStatement5);
			n = stmt.execute();
			System.out.println("Sucessfully populated table Titles.");
		} catch (SQLException e) {
			System.out.println("Failed to populate table Titles");
			e.printStackTrace();
		}
	}

	public void populateRegTypes() {
		PreparedStatement stmt = null;
		String SQLStatement = "INSERT INTO RegistrationType "
				+ "VALUES(1,'Normal');";
		String SQLStatement1 = "INSERT INTO RegistrationType "
				+ "VALUES(2,'Repeat');";
		String SQLStatement2 = "INSERT INTO RegistrationType "
				+ "VALUES(3,'External');";
		try {
			stmt = dbConn.prepareStatement(SQLStatement);
			boolean n = stmt.execute();
			stmt = dbConn.prepareStatement(SQLStatement1);
			n = stmt.execute();
			stmt = dbConn.prepareStatement(SQLStatement2);
			n = stmt.execute();
			System.out.println("Sucessfully populated table RegistrationType.");
		} catch (SQLException e) {
			System.out.println("Failed to populate table RegistrationType");
			e.printStackTrace();
		}
	}
	
	public void populateRealData() {
		PreparedStatement stmt = null;
		String popLecturer = "INSERT INTO Lecturer " +
							 "VALUES(666,1,'Volker','Sorge');";
		String popStudent1 = "INSERT INTO Student " +
							 "VALUES(1,1,'Luke','Skywalker','1990-01-20');";
		String popStudent2 = "INSERT INTO Student " +
		 					 "VALUES(2,2,'Leia','Organa','1990-01-20');";
		String popStudent3 = "INSERT INTO Student " +
		 					 "VALUES(3,1,'James','Bond','1979-02-28');";
		String popStudent4 = "INSERT INTO Student " +
		 					 "VALUES(4,4,'Jack','Sparrow','1990-05-20');";
		String popStudent5 = "INSERT INTO STUDENT " + 
							 "VALUES(5,3,'Sally','Sparrow','1993-12-25');";
		try {
			stmt = dbConn.prepareStatement(popLecturer);
			boolean n = stmt.execute();
			stmt = dbConn.prepareStatement(popStudent1);
			n = stmt.execute();
			stmt = dbConn.prepareStatement(popStudent2);
			n = stmt.execute();
			stmt = dbConn.prepareStatement(popStudent3);
			n = stmt.execute();
			stmt = dbConn.prepareStatement(popStudent4);
			n = stmt.execute();
			stmt = dbConn.prepareStatement(popStudent5);
			n = stmt.execute();
			for (int i=1;i<6;i++) {
				String popTutor = "INSERT INTO Tutor " +
				  				  "VALUES(?,666);";
				stmt = dbConn.prepareStatement(popTutor);
				stmt.setInt(1, i);
				n = stmt.execute();
			}
			System.out.println("Successfully generated real data.");
		}
		catch (SQLException e) {
			System.out.println("Failed to populate real data.");
			e.printStackTrace();
		}
		
	}
	

	// public void populate
}

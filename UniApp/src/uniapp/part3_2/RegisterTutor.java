package uniapp.part3_2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import uniteach.test.Database;

public class RegisterTutor {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Database db = new Database();
		int sID;
		int lID;
		System.out.println("Write ID of student: ");
		sID = input.nextInt();
		System.out.println("Write ID of lecturer: ");
		lID = input.nextInt();

		try {
			db.getConn().connect();
			if (checkExisting(sID,lID,db)) {
				addTutor(sID,lID,db);
			}
			else {
				System.out.println("Sorry, either the lecturer or the user don't exist in the database.");
				System.exit(0);
			}
		} finally {
			db.getConn().disconnect();
		}
	}

	public static boolean checkExisting(int sID, int lID, Database db) {
		boolean sValid = false,lValid = false,tValid=false;
		String SQLStatement = "SELECT * FROM Student WHERE studentID = ?";
		String SQLStatement1 = "SELECT * FROM Lecturer WHERE lecturerID = ?";
		String SQLStatement2 = "SELECT * FROM Tutor WHERE studentID = ? AND lecturerID = ? ";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = db.getConn().getDbConn().prepareStatement(SQLStatement);
			stmt.setInt(1, sID);
			rs = stmt.executeQuery();
			sValid = rs.next();
		} catch (SQLException e) {
			System.out.println("Couldn't execute statement for Student");
			e.printStackTrace();
		}
		
		try {
			stmt = db.getConn().getDbConn().prepareStatement(SQLStatement1);
			stmt.setInt(1, lID);
			rs = stmt.executeQuery();
			lValid = rs.next();
		} catch (SQLException e) {
			System.out.println("Couldn't execute statement for Lecturer");
			e.printStackTrace();
		}
		
		try {
			stmt = db.getConn().getDbConn().prepareStatement(SQLStatement2);
			stmt.setInt(1, sID);
			stmt.setInt(2, lID);
			rs = stmt.executeQuery();
			tValid = rs.next();
			System.out.println("Tvalid: " + tValid);
		} catch (SQLException e) {
			System.out.println("Couldn't execute statement for Tutor");
			e.printStackTrace();
		}
		
		return sValid && lValid && !tValid;
		
	}
	
	public static void addTutor(int sID,int lID, Database db) {
		String SQLStatement = "INSERT INTO Tutor VALUES(?,?);";
		PreparedStatement stmt = null;
		try {
			stmt = db.getConn().getDbConn().prepareStatement(SQLStatement);
			stmt.setInt(1, sID);
			stmt.setInt(2, lID);
			boolean n = stmt.execute();
			System.out.println("Successfully added new tutor");
		} catch (SQLException e) {
			System.out.println("Error: couldn't add tutor");
			e.printStackTrace();
		}
		
	}
}

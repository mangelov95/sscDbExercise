package uniapp.part3_3;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import uniteach.test.Database;

public class StudentReport {
	private static String title = "";
	private static String forename = "";
	private static String familyname = "";
	private static Date dob;
	private static String sId = "";
	private static String yearOfS = "";
	private static String regType = "";
	private static String sEmail = "";
	private static String sPostal = "";
	private static String emName = "";
	private static String emEmail = "";
	private static String emPostal = "";
	private static String tforename = "";
	private static String tfamilyname = "";
	
	public static void main(String args[]) {
		Database db = new Database();
		try {
			db.getConn().connect();
			getInfo(1,db);
			printInfo();
		}
		finally {
			db.getConn().disconnect();
		}
	}
	
	public static void getInfo(int id,Database db) {
		String SQLStatement = "SELECT t.titleString , s.forename, s.familyName, s.studentId, s.dateOfBirth, r.yearOfStudy, rt.description, sc.email,sc.postalAddress, n.name , n.emailAddress, n.postalAddress, l.forename, l.familyName "
				+ "from titles t, student s, studentRegistration r, registrationType rt, studentContact sc, nextOfKinContact n, Lecturer l, tutor tt "
				+ "WHERE t.titleId = s.titleId AND "
				+ "r.studentId = s.studentId AND "
				+ "rt.registrationTypeId = r.registrationTypeId AND "
				+ "sc.studentId = s.studentId AND "
				+ "n.studentId = s.studentId AND "
				+ "tt.studentId = s.studentId AND "
				+ "l.lecturerId = tt.lecturerId AND "
				+ "s.studentId = ?;";
		PreparedStatement stmt = null;
		try {
			stmt = db.getConn().getDbConn().prepareStatement(SQLStatement);
			stmt.setInt(1, id);
			System.out.println("Successfully prepared statement.");
		} catch (SQLException e) {
			System.out.println("Couldn't prepare statement.");
			e.printStackTrace();
		}
		try {
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				title = rs.getString(1);
				forename = rs.getString(2);
				familyname = rs.getString(3);
				sId = rs.getString(4);
				dob = rs.getDate(5);
				yearOfS = rs.getString(6);
				regType = rs.getString(7);
				sEmail = rs.getString(8);
				sPostal = rs.getString(9);
				emName = rs.getString(10);
				emEmail = rs.getString(11);
				emPostal = rs.getString(12);
				tforename = rs.getString(13);
				tfamilyname = rs.getString(14);
			}
			System.out.println("Successfully got data.");
			System.out.println();
		} catch (SQLException e) {
			System.out.println("Couldn't execute query.");
			e.printStackTrace();
		}
	}
	
	public static void printInfo() {
		System.out.println("Name: " + title + " " + forename + " " + familyname);
		System.out.println("Date of birth: " + dob);
		System.out.println("StudentId: " + sId);
		System.out.println("Year of study: " + yearOfS);
		System.out.println("Registration type: " + regType);
		System.out.println("Email: " + sEmail);
		System.out.println("Postal Address: " + sPostal);
		System.out.println("Emergency contact name: " + emName);
		System.out.println("Emergency contact email: " + emEmail);
		System.out.println("Emergency contact address: " + emPostal);
		System.out.println("Tutor name: " + tforename + " " + tfamilyname);
		System.out.println();
	}
}

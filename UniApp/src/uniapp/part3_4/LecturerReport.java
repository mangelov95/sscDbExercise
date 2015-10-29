package uniapp.part3_4;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.print.attribute.standard.PrinterInfo;

import uniapp.extra.Helper;
import uniteach.resources.Person;
import uniteach.test.Database;

public class LecturerReport {
	private static ArrayList<Person> firstYears;
	private static ArrayList<Person> secondYears;
	private static ArrayList<Person> thirdYears;
	
	public static void main(String args[]) {
		firstYears = new ArrayList<Person>();
		secondYears = new ArrayList<Person>();
		thirdYears = new ArrayList<Person>();
		Database db = new Database();
		try {
			db.getConn().connect();
			getInfo(666,db);
			printInfo();
		} finally {
			db.getConn().disconnect();
		}
	}

	public static void getInfo(int id, Database db) {
		String SQLStatement = "SELECT t.titleString,s.forename, s.familyname,s.studentId,rt.description,r.yearOfStudy,s.dateOfBirth,sc.email,sc.postaladdress,n.name,n.emailAddress,n.postalAddress "
				+ "FROM titles t, student s, registrationType rt, studentContact sc, nextOfKinContact n, studentRegistration r, tutor tt "
				+ "WHERE t.titleId = s.titleId AND " + "r.studentId = s.studentId AND "
				+ "rt.registrationTypeId = r.registrationTypeId AND " + "sc.studentId = s.studentId AND "
				+ "n.studentId = s.studentId AND " + "s.studentId = tt.studentId AND " + "tt.lecturerId = ?;";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = db.getConn().getDbConn().prepareStatement(SQLStatement);
			stmt.setInt(1, id);
		} catch (SQLException e) {
			System.out.println("Failed to prepare statement.");
			e.printStackTrace();
		}
		try {
			rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(6) == 1) {
					Person person = new Person(rs.getInt(4),Helper.convertTitle(rs.getString(1)),rs.getString(2),rs.getString(3),"",rs.getString(5),rs.getDate(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
					firstYears.add(person);
				}
				if (rs.getInt(6) == 2) {
					Person person = new Person(rs.getInt(4),Helper.convertTitle(rs.getString(1)),rs.getString(2),rs.getString(3),"",rs.getString(5),rs.getDate(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
					secondYears.add(person);
				}
				if (rs.getInt(6) == 3) {
					Person person = new Person(rs.getInt(4),Helper.convertTitle(rs.getString(1)),rs.getString(2),rs.getString(3),"",rs.getString(5),rs.getDate(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
					thirdYears.add(person);
				}
			}
		} catch (SQLException e) {
			System.out.println("Couldn't get info.");
			e.printStackTrace();
		}

	}
	
	public static void printInfo() {
		System.out.println();
		System.out.println("First year students: ");
		for (int i=0;i<firstYears.size();i++) {
			Person p = firstYears.get(i);
			System.out.println("Student ID: " + p.getId());
			System.out.println("Name: " + Helper.convertTitle(p.getTitle()) + " " + p.getForename() + " " + p.getFamilyName());
			System.out.println("Registration type: " + p.getRegType());
			System.out.println("Date of Birth: " + p.getDateOfBirth());
			System.out.println("Email: " + p.getEmail());
			System.out.println("Postal address: " + p.getPostal());
			System.out.println("Emergency name: " + p.getEmName());
			System.out.println("Emergency email: " + p.getEmEmail());
			System.out.println("Emergency postal: " + p.getEmPostal());
			System.out.println();
		}
		System.out.println("Second years: ");
		for (int i=0;i<secondYears.size();i++) {
			Person p = secondYears.get(i);
			System.out.println("Student ID: " + p.getId());
			System.out.println("Name: " + Helper.convertTitle(p.getTitle()) + " " + p.getForename() + " " + p.getFamilyName());
			System.out.println("Registration type: " + p.getRegType());
			System.out.println("Date of Birth: " + p.getDateOfBirth());
			System.out.println("Email: " + p.getEmail());
			System.out.println("Postal address: " + p.getPostal());
			System.out.println("Emergency name: " + p.getEmName());
			System.out.println("Emergency email: " + p.getEmEmail());
			System.out.println("Emergency postal: " + p.getEmPostal());
			System.out.println();
		}
		System.out.println("Third years: ");
		for (int i=0;i<thirdYears.size();i++) {
			Person p = thirdYears.get(i);
			System.out.println("Student ID: " + p.getId());
			System.out.println("Name: " + Helper.convertTitle(p.getTitle()) + " " + p.getForename() + " " + p.getFamilyName());
			System.out.println("Registration type: " + p.getRegType());
			System.out.println("Date of Birth: " + p.getDateOfBirth());
			System.out.println("Email: " + p.getEmail());
			System.out.println("Postal address: " + p.getPostal());
			System.out.println("Emergency name: " + p.getEmName());
			System.out.println("Emergency email: " + p.getEmEmail());
			System.out.println("Emergency postal: " + p.getEmPostal());
			System.out.println();
		}
	}
}

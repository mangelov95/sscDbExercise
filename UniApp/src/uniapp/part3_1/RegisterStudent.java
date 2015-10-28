package uniapp.part3_1;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import uniapp.extra.Helper;
import uniteach.test.Database;

public class RegisterStudent {

	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		Scanner input = new Scanner(System.in);
		String title, forename, familyName;
		String[] titles = {"MR", "MS", "MRS", "CAPT", "DOC"};
		ArrayList<String> validTitles = new ArrayList<String>();
		validTitles.add("MR");
		validTitles.add("MS");
		validTitles.add("MRS");
		validTitles.add("CAPT");
		validTitles.add("DOC");
		
		title = "";
		forename = "";
		familyName = "";
		while (!validTitles.contains(title.toUpperCase())) {
			System.out.println("Please enter the title, first name and family name of the student: ");
			title = input.next();
			forename = input.next();
			familyName = input.next();
			if (!validTitles.contains(title.toUpperCase())) {
				System.out.println("Sorry, the title isn't in the right format. It should be one of the following: " +
								   "MR,MS,MRS,CAPT,DOC");
			}
		}
		Date dateVar = new Date();
		boolean valid = false;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String date = "";
		System.out.println(title + "=" + Helper.convertTitle(title.toUpperCase()));
		while (!valid) {
			System.out.println("Please input a date in the format yyyy/mm/dd: ");
			date = input.next();
			if (!date.matches("([0-9]{4})/([0-9]{2})/([0-9]{2})")) {
				System.out.println("Sorry your input doesn't satisfy the date format (yyyy/mm/dd). Try again.");
			}
			else {
				valid = true;
			}
		}
		
		try {
			dateVar = formatter.parse(date);
		} catch (ParseException e) {
			System.out.println("Cannot parse date.");
			e.printStackTrace();
		}
		if (!Helper.checkDate(dateVar)) {
			System.out.println("Sorry, the date is not a valid date. Please start the program again.");
			System.exit(0);
		}
		
		Database db = new Database();
		try {
			db.getConn().connect();
			if (checkExisting(title, forename, familyName, dateVar,db)) {
				System.out.println("Sorry, there already exists a student with those details");
				System.exit(0);
			}
			else {
				register(title, forename, familyName, dateVar, db);
			}
		}
		finally {
			db.getConn().disconnect();
		}
	}
	
	public static boolean checkExisting(String title, String forename, String familyName, Date date, Database db) {
		int titleId = Helper.convertTitle(title.toUpperCase());
		db.getConn().connect();
		PreparedStatement stmt;
		ResultSet rs = null;
		String SQLStatement = "SELECT  * FROM student " +
		 "WHERE titleID =? AND " +
		 "forename =? AND " +
		 "familyName =? AND " +
		 "dateOfBirth =?;";
		boolean boole = true;
		try {
			stmt = db.getConn().getDbConn().prepareStatement(SQLStatement);
			stmt.setInt(1, titleId);
			stmt.setString(2, forename);
			stmt.setString(3, familyName);
			stmt.setDate(4, Helper.convertDate(date));
			rs = stmt.executeQuery();
			boole = rs.next();
		} catch (SQLException e) {
			System.out.println("Couldn't execute query.");
			e.printStackTrace();
		}
		return boole;
	}
	
	public static int generateID(Database db) {
		String SQLStatement = "SELECT MAX(studentID) FROM student;";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int maxID = 0;
		try {
			stmt = db.getConn().getDbConn().prepareStatement(SQLStatement);
			rs = stmt.executeQuery();
			while(rs.next()) {
				maxID = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Couldn't get max StudentID.");
			e.printStackTrace();
		}
		return maxID+1;
	}
	
	public static void register(String title, String forename, String familyName, Date date, Database db) {
		String SQLStatement = "INSERT INTO Student "
							+ "VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stmt = null;
		try {
			stmt = db.getConn().getDbConn().prepareStatement(SQLStatement);
			stmt.setInt(1, generateID(db));
			stmt.setInt(2, Helper.convertTitle(title.toUpperCase()));
			stmt.setString(3, forename);
			stmt.setString(4, familyName);
			stmt.setDate(5, Helper.convertDate(date));
			boolean n = stmt.execute();
			System.out.println("Successfully added student " + forename + " " + familyName +" to the DB.");
		} catch (SQLException e) {
			System.out.println("Couldn't add student");
			e.printStackTrace();
		}
	}
}

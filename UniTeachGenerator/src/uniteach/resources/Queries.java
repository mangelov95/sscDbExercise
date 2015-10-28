package uniteach.resources;

public class Queries {
	public static String GEN_TITLES = "CREATE TABLE Titles" +
							   "(" +
							   "	titleID int PRIMARY KEY," +
							   "	titleString varchar(255)" +
							   ");";
	
	public static String GEN_REG_TYPE = "CREATE TABLE RegistrationType" +
			                            "(" +
			                            "	registrationTypeID int PRIMARY KEY," +
			                            "   description varchar(255)" +
			                            ");";
	
	public static String GEN_LECTURER = "CREATE TABLE Lecturer" +
										"(" +
										"	lecturerID int PRIMARY KEY," +
										"	titleID int REFERENCES Titles(titleID)," +
										"   forename varchar(255)," +
										"	familyName varchar(255) NOT NULL" +
										");";
	
	public static String GEN_STUDENT = "CREATE TABLE Student" +
									   "(" +
									   "	studentID int PRIMARY KEY," +
									   "	titleID int REFERENCES Titles(titleID)," +
									   "	forename varchar(255)," +
									   "	familyName varchar(255) NOT NULL," +
									   "	dateOfBirth Date" +
									   ");";
	
	public static String GEN_LEC_CONTACT = "CREATE TABLE LecturerContact" +
										   "(" +
										   "	lecturerID int REFERENCES Lecturer(lecturerID)," +
										   "	office int," +
										   "	email varchar(255) NOT NULL," +
										   "	PRIMARY KEY (lecturerID)" +
										   ");";
	
	public static String GEN_STUDENT_REG = "CREATE TABLE StudentRegistration" +
										   "(" +
										   "	studentID int REFERENCES Student(studentID)," +
										   "	yearOfStudy int," +
										   "	registrationTypeID int REFERENCES RegistrationType(registrationTypeID)," +
										   "	PRIMARY KEY (studentID)" +
										   ");";
	
	public static String GEN_TUTOR = "CREATE TABLE Tutor" +
									 "(" +
									 "		studentID int REFERENCES Student(studentID) NOT NULL," +
									 "		lecturerID int REFERENCES Lecturer(lecturerID) NOT NULL" +
									 ");";
	
	public static String GEN_STU_CONTACT = "CREATE TABLE StudentContact" +
										   "(" +
										   "	studentID int REFERENCES Student(studentID)," +
										   "	email varchar(255) NOT NULL," +
										   "	postalAddress varchar(255)," +
										   "	PRIMARY KEY(studentID)" +
										   ");";
	
	public static String GEN_NOK_CONTACT = "CREATE TABLE NextOfKinContact" +
										   "(" +
										   "	studentID int REFERENCES Student(studentID)," +
										   "	name varchar(255) NOT NULL," +
										   "	eMailAddress varchar(255) NOT NULL," +
										   "	postalAddress varchar(255)" +
										   ");";
}

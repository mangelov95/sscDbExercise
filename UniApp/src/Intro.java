import java.util.Scanner;

import uniapp.part3_1.RegisterStudent;
import uniapp.part3_2.RegisterTutor;
import uniapp.part3_3.StudentReport;
import uniapp.part3_4.LecturerReport;
import uniteach.test.Database;

public class Intro {
	public static void main(String args[]) {
		Database db = new Database();
		Scanner input = new Scanner(System.in);
		System.out.println("Hello, please press any key to create database");
		input.next();
		db.create();
		System.out.println("Database created");
		int choice;
		System.out.println("Press 1 for Part 3.1, 2 for Part 3.2, 3 for Part 3.3, 4 for Part 3.4");
		choice = input.nextInt();
		switch(choice) {
			case 1: RegisterStudent.main(args); break;
			case 2: RegisterTutor.main(args); break;
			case 3: StudentReport.main(args); break;
			case 4: LecturerReport.main(args); break;
		}
	}
}

package uniapp.part3_4;
import uniteach.test.Database;

public class LecturerReport {
	public static void main(String args[]) {
		Database db = new Database();
		try {
			db.getConn().connect();
		}
		finally {
			db.getConn().disconnect();
		}
	}
}

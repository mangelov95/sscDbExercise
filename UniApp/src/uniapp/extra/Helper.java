package uniapp.extra;
import java.util.Calendar;
import java.util.Date;


public class Helper {
	public Helper() {
		
	}
	
	public static boolean checkDate(Date date) {
		boolean valid = true;
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(date);
		}
		catch (Exception e) {
			valid=false;
		}
		return valid;
	}
	
	public static java.sql.Date convertDate(Date date) {
		return new java.sql.Date(date.getTime());		
	}
	
	public static int convertTitle(String title) {
		if (title.equals("MR")) return 1;
		else if (title.equals("MS")) return 2;
		else if (title.equals("MRS")) return 3;
		else if (title.equals("CAPT")) return 4;
		else if (title.equals("DOC")) return 5;
		else return 0;
	}
}

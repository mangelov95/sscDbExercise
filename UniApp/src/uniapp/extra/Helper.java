package uniapp.extra;
import java.util.Calendar;
import java.util.Date;


public class Helper {
	public Helper() {
		
	}
	
	public static boolean checkDate(Date date) {
		boolean valid = true;
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(year + " " + month + " " + day);
		
		if (year % 4 == 0) {
			if (month == 2 && day > 29) {
				return false;
			}
		}
		else {
			if (month == 2 && day > 28) {
				return false;
			}
		}
		
		switch (month) {
			case 1: if (day > 31) return false; else break;
			case 3: if (day > 31) return false; else break;
			case 4: if (day > 30) return false; else break;
			case 5: if (day > 31) return false; else break;
			case 6: if (day > 30) return false; else break;
			case 7: if (day > 31) return false; else break;
			case 8: if (day > 31) return false; else break;
			case 9: if (day > 30) return false; else break;
			case 10: if (day > 31) return false; else break;
			case 11: if (day > 30) return false; else break;
			case 12: if (day > 31) return false; else break;
		}
		return true;
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

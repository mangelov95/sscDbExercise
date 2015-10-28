package uniteach.test;

import java.util.Random;

import uniteach.conn.TestConn;
import uniteach.init.DBInit;
import uniteach.pop.DBPop;

public class Test {
	public static void main(String args[]) {
		TestConn conn = new TestConn();
		DBInit init = null;
		DBPop pop = null;
		try {
			conn.connect();
			init = new DBInit(conn.getDbConn());
			pop = new DBPop(conn.getDbConn());
			init.wipe();
			init.initAll();
			pop.populateTitles();
			pop.populateRegTypes();
			pop.populateStudents(30);
			pop.populateLecturers(30);
			pop.populateRealData();
		}
		finally {
			conn.disconnect();
		}
		//DBPop pop = new DBPop();
		//pop.populateStudents(20);
	}
}

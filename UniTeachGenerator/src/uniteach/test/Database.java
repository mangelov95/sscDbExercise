package uniteach.test;

import uniteach.conn.TestConn;
import uniteach.init.DBInit;
import uniteach.pop.DBPop;

public class Database {
	private TestConn conn;
	private DBInit init;
	private DBPop pop;
	
	public Database() {
		conn = new TestConn();
	}
	
	public void create() {
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
	}
	
	public TestConn getConn() {
		return conn;
	}

}

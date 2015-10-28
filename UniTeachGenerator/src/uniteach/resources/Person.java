package uniteach.resources;

import java.sql.Date;

public class Person {
	private int id;
	private int tId;
	private String forename;
	private String familyName;
	private String doB;
	private Role r;
	
	public Person() {
		
	}
	
	public Person(int id, int tId, String forename, String familyName, String doB, Role r) {
		this.setId(id);
		this.setTitle(tId);
		this.setForename(forename);
		this.setFamilyName(familyName);
		this.setDoB(doB);
		this.setR(r);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setTitle(int tId) {
		this.tId = tId;
	}
	public int getTitle() {
		return tId;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public String getForename() {
		return forename;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setDoB(String doB) {
		this.doB = doB;
	}
	public String getDoB() {
		return doB;
	}

	public void setR(Role r) {
		this.r = r;
	}

	public Role getR() {
		return r;
	}
}

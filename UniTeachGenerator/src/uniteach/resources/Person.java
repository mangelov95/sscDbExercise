package uniteach.resources;

import java.sql.Date;

public class Person {
	private int id;
	private int tId;
	private String forename;
	private String familyName;
	private String doB;
	private String regType;
	private Date dateOfBirth;
	private String email;
	private String postal;
	private String emName;
	private String emEmail;
	private String emPostal;
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
	
	public Person(int id, int tId, String forename, String familyName, String doB, String regType, Date dateOfBirth, String email, String postal, String emName, String emEmail, String emPostal) {
		this.setId(id);
		this.setTitle(tId);
		this.setForename(forename);
		this.setFamilyName(familyName);
		this.setDoB(doB);
		this.setRegType(regType);
		this.setDateOfBirth(dateOfBirth);
		this.setEmail(email);
		this.setPostal(postal);
		this.setEmEmail(emEmail);
		this.setEmName(emName);
		this.setEmPostal(emPostal);
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

	public String getRegType() {
		return regType;
	}

	public void setRegType(String regType) {
		this.regType = regType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmName() {
		return emName;
	}

	public void setEmName(String emName) {
		this.emName = emName;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getEmEmail() {
		return emEmail;
	}

	public void setEmEmail(String emEmail) {
		this.emEmail = emEmail;
	}

	public String getEmPostal() {
		return emPostal;
	}

	public void setEmPostal(String emPostal) {
		this.emPostal = emPostal;
	}
	
	public String toString() {
		return doB;
		
	}
}

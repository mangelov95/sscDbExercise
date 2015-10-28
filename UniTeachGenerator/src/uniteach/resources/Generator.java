package uniteach.resources;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;

public class Generator {
	private static String[] forenames = {"Andres",
		"Tomasa",
		"Mai",
		"Landon",
		"Marget",
		"Jeannette",
		"Harriet",
		"Criselda",
		"Carletta",
		"Sun",
		"Betty",
		"Judith",
		"Mathew",
		"Meghann",
		"Loyd",
		"Rufina",
		"Lauralee",
		"Tandra",
		"Palmira",
		"Alejandrina",
		"Tynisha",
		"Leonora",
		"Katy",
		"Alecia",
		"Christin",
		"Nadene",
		"Charlsie",
		"Amado",
		"Frederick",
		"Georgina"};
	private static String[] familynames = {"Vanda",
		"Ernesto",
		"Cody",
		"Violette",
		"Tanja",
		"Isabell",
		"Rae",
		"Dorthea",
		"Stacey",
		"Thurman",
		"Shellie",
		"Sharan",
		"Lien",
		"Shelby",
		"Lucinda",
		"Virgie",
		"Sommer",
		"Romaine",
		"Dori",
		"Kyong",
		"Nakisha",
		"Freddy",
		"Elise",
		"Cathy",
		"Alana",
		"Jerrica",
		"Yu",
		"Francina",
		"Halley",
		"Merced"};
	
	public void generateStudents(Person[] people) {
		Random rand = new Random();
		ArrayList<Integer> randomIds = new ArrayList<Integer>();
		while (randomIds.size() < people.length) {
			int randomId = rand.nextInt(people.length+5);
			System.out.println("Random Id: " + randomId);
			if (!randomIds.contains(randomId+6)) {
				System.out.println("Passed: " + (randomId+6));
				randomIds.add(randomId+6);
			}
		}
		for (int i=0;i<people.length;i++) {
			people[i].setId(randomIds.get(0));
			randomIds.remove(0);
			people[i].setForename(forenames[rand.nextInt(forenames.length)]);
			people[i].setFamilyName(familynames[rand.nextInt(familynames.length)]);
			people[i].setTitle(rand.nextInt(5) + 1);
			people[i].setR(Role.STUDENT);
			people[i].setDoB((rand.nextInt(20) + 1980) + "-" + (rand.nextInt(12) + 1) + "-" + (rand.nextInt(20) + 1));
		}
	}
	
	public void generateLecturers(Person[] people) {
		Random rand = new Random();
		ArrayList<Integer> randomIds = new ArrayList<Integer>();
		while (randomIds.size() < people.length) {
			int randomId = rand.nextInt(people.length);
			if (!randomIds.contains(randomId) && (randomId != 666)) {
				randomIds.add(randomId);
			}
		}
		for (int i=0;i<people.length;i++) {
			people[i].setId(randomIds.get(0));
			randomIds.remove(0);
			people[i].setForename(forenames[rand.nextInt(forenames.length)]);
			people[i].setFamilyName(familynames[rand.nextInt(familynames.length)]);
			people[i].setTitle(rand.nextInt(3) + 1);
			people[i].setR(Role.LECTURER);
			people[i].setDoB((rand.nextInt(30) + 1950) + "-" + (rand.nextInt(12) + 1) + "-" + (rand.nextInt(20) + 1));
		}
	}
}

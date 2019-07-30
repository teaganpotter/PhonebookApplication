package phonebookApplication;

import java.util.Scanner;

public class Phonebook {

	public static int id = 0;

	public  Person [] entry = new Person [0];

	public void addNewEntry(String input) {
		Person person1 = parseString(input);
		Person [] tempArray = new Person[entry.length +1];
		for (int i=0; i< entry.length; i++) {
			tempArray[i] = entry[i];			
		}
		entry = tempArray;
		entry[entry.length-1] = person1;

	}
	public void printEntries() {
		for (int i=0; i < entry.length; i++) {
			if (!(entry[i].equals(null))) {
			System.out.println(entry[i].toString());
			}
			
		}

	}
	public void deleteEntry(int id) {
		Person [] tempArray = new Person[entry.length -1];
		for (int i=0; i<entry.length; i++) {
			if (id != entry[i].getID()) {
				tempArray[i] = entry[i];
			}
		}
		entry = tempArray;
	}
	public static Person parseString (String entry1) {
		String [] split1 = entry1.split(",");
		String name = split1[0];
		String streetAddress = split1[1];
		String city = split1[2];
		String state = split1[3];
		String zipCode = split1[4];
		String phoneNumber = split1[5];
		id += 1;
		Person person1 = new Person(id, name, phoneNumber, new Address(streetAddress, city, state, zipCode));
		return person1;
	}

	public void searchEntries(int entry1) {

		switch(entry1) {
		case 1: {
			System.out.println("What first name would you like to search by?");
			
			break;
		}
		case 2: {
			System.out.println("What last name would you like to search by?");
			break;
		}
		case 3: {
			System.out.println("What full name would you like to search by?");
			break;
		}
		case 4: {
			System.out.println("What phone number would you like to search by?");
			break;
		}
		case 5: {
			System.out.println("What city would you like to search by?");
			break;
		}
		case 6: {
			System.out.println("What state would you like to search by?");
			break;
		}
		}
		Scanner in = new Scanner(System.in);
		String searchTerm = in.nextLine();
		for (int i = 0; i < entry.length; i++) {
			if (entry[i].search(entry1, searchTerm)) {
				System.out.println(entry[i].toString());
			}
		}
	} 
	public void editEntry(int number, Person p) {

		switch(number) {
		case 1: {
			System.out.println("["+ p.getFirstName() + "]" + "What is the new first name?");

			break;
		}
		case 2: {
			System.out.println("What is the new last name?");
			break;
		}
		case 3: {
			System.out.println("What is the new full name?");
			break;
		}
		case 4: {
			System.out.println("What is the new phone number?");
			break;
		}
		case 5: {
			System.out.println("What is the new city?");
			break;
		}
		case 6: {
			System.out.println("What is the new state?");
			break;
		}
		}
		Scanner in = new Scanner(System.in);
		String editTerm = in.nextLine();
		p.editField(number, editTerm);
		System.out.println(p.toString());
	}
	public Person getPersonByID(int number) {
		for (int i=0; i<entry.length; i++) {
			if (number == entry[i].getID()) {
				return entry[i];
			}
		}
		return null;
	}
	public void sortAlphabetically() {
		boolean didSwitch = false;
		do {
			didSwitch = false;
			for (int i = 0; i < entry.length; i++) {
				if (i == entry.length -1) {
					break;
				} 
				int j = i + 1;
				if (entry[j].getLastName().compareToIgnoreCase(entry[i].getLastName()) < 0) {
					Person p = entry[j];
					entry[j] = entry[i];
					entry[i] = p;
					didSwitch = true;
				}
			}
		} while (didSwitch);
	}
}

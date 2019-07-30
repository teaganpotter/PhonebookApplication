package phonebookApplication;


import java.util.Scanner;

public class Application {
	public static Phonebook phonebook = new Phonebook();
	public static int printMenu() {
		Scanner in = new Scanner(System.in);
		System.out.println("What action would you like to perform? "
				+ "\n1: Add a new record."
				+ "\n2: Delete a record."
				+ "\n3: Search."
				+ "\n4: Update an existing record."
				+ "\n5: Show all records in alphabetical order."
				+ "\n6: Exit the program.");
		int action = in.nextInt();
		return action;
	}
	public static void main(String[] args)  
	{
		Scanner scanner = new Scanner(System.in);
		int action = printMenu();


		while (action != 6){

			switch (action) {
			case 1:{
				System.out.println("What entry would you like to add? (Format: Full name, address, city, state, zip, phone number)");
				Scanner in = new Scanner(System.in);
				String entry1 = in.nextLine();		
				phonebook.addNewEntry(entry1);
				phonebook.printEntries();
				break;
			}
			case 2:{
				System.out.println("Which number would you like to delete? [#]");
				Scanner in = new Scanner(System.in);
				int number = in.nextInt();
				phonebook.deleteEntry(number);
				phonebook.printEntries();
				break;
			}
			case 3:{
				System.out.println("What would you like to search by? \n1) First Name \n2) Last Name \n3) Full Name \n4) Phone Number \n5) City \n6) State");
				Scanner in = new Scanner(System.in);
				int entry1 = in.nextInt();
				phonebook.searchEntries(entry1);
				break;
			}
			case 4:{
				System.out.println("What is the number of the record you would like to update? (#)");
				Scanner in = new Scanner(System.in);
				int number = in.nextInt();
				Person p = phonebook.getPersonByID(number);
				if (p == null) {
					System.out.println("Invalid entry.");
				}else {
					System.out.println(p.toString());
					System.out.println("What would you like to update? \n1) First Name \n2) Last Name \n3) Full Name \n4) Phone Number \n5) City \n6) State");
					number = in.nextInt();
					phonebook.editEntry(number, p);
				}
				break;
			}
			case 5:{
				System.out.println("Here are all of the records we have on file.");
				phonebook.sortAlphabetically();
				phonebook.printEntries();
				break;
			}
			default: {
				System.out.println("Wrong input.");
				break;
			}
			}
			action = printMenu();
		}

		System.exit(0);

	}
}	



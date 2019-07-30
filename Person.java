package phonebookApplication;

public class Person {

	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneNumber;
	private Address address;
	private int id;


	public Person() {}
	public Person(int id, String name, String phoneNumber, Address address) {
		//trim is used to get rid of the extra white space java was giving me from parsing!!! good to know 
		String [] strings = name.split(" ");
		this.lastName = (strings[strings.length-1]).trim();
		this.middleName = "";
		if (strings.length > 2) {
			for (int i = 1; i < strings.length-1; i++) {
//				System.out.print(strings[i]);
				this.middleName += ((i > 1) ? " " : "" ) + strings[i].trim();
			}
		}
		this.firstName = strings[0].trim();
		this.phoneNumber = phoneNumber.trim();
		this.address = address;
		this.id = id;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Address getAddress() {
		return this.address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getID() {
		return this.id;
	}
	public String toString() {
		String numberOutput = this.phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");	
		String output = "[" + id + "] " + this.firstName + " " +  ((this.middleName == "")? "": (this.middleName + " ")) + this.lastName + ", " + this.address.toString() + ", " + numberOutput;
		return output;
	}
	public boolean search(int field, String searchTerm) {
		//		System.out.println(firstName.length()); ---this tested white space count 
		//		System.out.println(searchTerm.length());
		switch(field) {
		case 1: {
			//			System.out.println((firstName.equalsIgnoreCase(searchTerm)));
			return (firstName.equalsIgnoreCase(searchTerm));
		}case 2: {
			return lastName.equalsIgnoreCase(searchTerm);
		}case 3: {
			return (firstName + " " + middleName + " " + lastName).equalsIgnoreCase(searchTerm);
		}case 4: {
			return phoneNumber.equalsIgnoreCase(searchTerm);
		}case 5: {
			return address.getCity().equalsIgnoreCase(searchTerm);
		}case 6: {
			return address.getState().equalsIgnoreCase(searchTerm);
		}
		}
		return false;
	}
	public void editField(int number, String field) {

		switch(number) {
		case 1: {
			firstName = field;
			break;
		}case 2: {
			lastName = field;
			break;
		}case 3: {
			String [] strings = field.split(" ");
			this.lastName = (strings[strings.length-1]).trim();
			this.firstName = (field.substring(0, field.length() - lastName.length())).trim();
			break;
		}case 4: {
			phoneNumber = field;
			break;
		}case 5: {
			address.setCity(field);
			break;
		}case 6: {
			address.setState(field);
		}
		}
	}

}

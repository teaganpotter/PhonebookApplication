package phonebookApplication;

public class Address {

	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;

	public Address () {}
	public Address(String streetAddress, String city, String state, String zipCode) {
		this.streetAddress = streetAddress.trim();
		this.city = city.trim();
		this.state = state.trim();
		this.zipCode = zipCode.trim();
	}
	public String getStreetAddress() {
		return this.streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return this.state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return this.zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String toString() {
		return streetAddress + ", " + city + ", " + state + " " + zipCode;
	}
}

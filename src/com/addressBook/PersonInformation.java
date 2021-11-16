package com.addressBook;

public class PersonInformation {

	// variables
	private String firstName, lastName, address, city, state, zip, phoneNumber, email;

	// default constructor // parameterized constructor
	public PersonInformation() {

	}

	public PersonInformation(String firstName, String lastName, String address, String city, String state,
			String zipCode, String mobileNumber, String emailId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = mobileNumber;
		this.email = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", address='" + address
				+ '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + ", zipCode=" + zip + ", mobileNo="
				+ phoneNumber + ", emailId='" + email + '\'' + '}';
	}
}

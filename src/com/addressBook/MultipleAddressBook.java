package com.addressBook;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MultipleAddressBook {
	Scanner scanner = new Scanner(System.in);

	static final String FILE_PATH = "AddressBookDetails.txt";
	static final String CSV_FILE_PATH = "AddressBook.csv";
	static final String JSON_FILE_PATH = "AddressBook2.json";
	PersonInformation person = new PersonInformation();
	List<PersonInformation> contactList = new ArrayList<>();
	HashMap<String, Contact> contactService = new HashMap<>();

	public void addAddressBook() {
		System.out.println("Enter Name of new Address Book: ");
		String bookName = scanner.next();
		if (contactService.containsKey(bookName)) {
			System.out.println("Address book with this name exists, Enter new name.");
			addAddressBook();
		} else {
			Contact contact = new Contact();
			contactService.put(bookName, contact);
			System.out.println("press 1 if you want to add another book.");
			int newBook = scanner.nextInt();
			if (newBook == 1) {
				addAddressBook();
			}
		}
	}

	// add contact in book
	public void addContact() {
		System.out.println("Enter the name of Address book to add the contact.");
		String newContact = scanner.nextLine();
		Contact addressBook = contactService.get(newContact);
		if (addressBook != null) {
			contactService.get(newContact).addContact();
		} else {
			System.out.println("No address book with this name");
		}
	}

	// edit contact in address book
	public void editContactInBook() {
		System.out.println("Enter Name to Edit Address Book: ");
		String editBookName = scanner.next();
		if (contactService.containsKey(editBookName)) {
			contactService.get(editBookName).editContact();
		} else {
			System.out.println("AddressBook doesn't exist!!");
			editContactInBook();
		}
	}

	// delete address book
	public void deleteAddressBook() {
		System.out.println("Enter Name to Delete Address Book: ");
		String bookName = scanner.next();
		if (contactService.containsKey(bookName)) {
			contactService.remove(bookName);
		} else {
			System.out.println("AddressBook doesn't exist!!");
			deleteAddressBook();
		}
	}

	// delete contacts in address book
	public void deleteContactInBook() {
		System.out.println("Enter Name to delete the contacts from Address Book : ");
		String bookName = scanner.next();
		if (contactService.containsKey(bookName)) {
			contactService.get(bookName).deleteContact();
		} else {
			System.out.println("AddressBook doesn't exist!!");
			deleteContactInBook();
		}
	}

	// search contacts using city or state name
	public void searchContacts() {
		while (true) {
			System.out.println("Enter\n 1. By city\n 2. By state\n 0. for previous menu");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter city: ");
				String city = scanner.nextLine();
				searchByCity(city);
				break;
			case 2:
				System.out.println("Enter state: ");
				String state = scanner.nextLine();
				searchByState(state);
				break;
			case 0:
				return;
			default:
				System.out.println("Entered choice is incorrect!.. please enter correct choice");
			}
		}
	}

	// count number of contacts in all address books using city or state name
	public void countContacts() {
		while (true) {
			System.out.println("Enter\n 1. By city\n 2. By state\n 0. for previous menu");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter city: ");
				String city = scanner.nextLine();
				countByCity(city);
				break;
			case 2:
				System.out.println("Enter state: ");
				String state = scanner.nextLine();
				countByState(state);
				break;
			case 0:
				return;
			default:
				System.out.println("Entered choice is incorrect!.. please enter correct choice");
			}
		}
	}

	// count number of contacts in all address books using city or state name
	public void sortConacts() {
		while (true) {
			System.out.println("Enter\n 1. By name\n 2. By city\n 3. By state\n 4. By zip code\n 0. for previous menu");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				sortByName();
				break;
			case 2:
				sortByCity();
				break;
			case 3:
				sortByState();
				break;
			case 4:
				sortByZip();
				break;
			case 0:
				return;
			default:
				System.out.println("please enter correct choice");
			}
		}
	}

	// search contact by state name
	public void searchByState(String state) {
		for (Map.Entry<String, Contact> entry : contactService.entrySet()) {
			List<PersonInformation> contactListByState = entry.getValue().contactList;
			List<PersonInformation> collect = contactListByState.stream()
					.filter(p -> p.getState().equalsIgnoreCase(state)).collect(Collectors.toList());
			for (PersonInformation contactsss : collect) {
				System.out.println("Search result: " + contactsss);
			}
		}
		System.out.println(" ");
	}

	// search contact by city name
	public void searchByCity(String city) {
		for (Map.Entry<String, Contact> entry : contactService.entrySet()) {
			List<PersonInformation> contactListByCity = entry.getValue().contactList;
			List<PersonInformation> collect = contactListByCity.stream().filter(p -> p.getCity().equalsIgnoreCase(city))
					.collect(Collectors.toList());
			for (PersonInformation contact : collect) {
				System.out.println("Search result: " + contact);
			}
		}
	}

	// count contact by city name
	public void countByCity(String cityName) {
		for (Map.Entry<String, Contact> entry : contactService.entrySet()) {
			System.out.println("The contacts in the Book of < " + entry.getKey() + " > are!...");
			List<PersonInformation> contactListByCity = entry.getValue().contactList;
			long countContactsByCity = contactListByCity.stream().filter(g -> g.getCity().equalsIgnoreCase(cityName))
					.count();
			System.out.println("Total Number of Contact from '" + cityName + "' city is " + countContactsByCity);
		}
	}

	// count contact by state name
	public void countByState(String stateName) {
		for (Map.Entry<String, Contact> entry : contactService.entrySet()) {
			System.out.println("The contacts in the Book of < " + entry.getKey() + " > are!...");
			List<PersonInformation> contactListByState = entry.getValue().contactList;
			long countContactsByState = contactListByState.stream()
					.filter(g -> g.getState().equalsIgnoreCase(stateName)).count();
			System.out.println("Total Number of Contact from '" + stateName + "' state is" + countContactsByState);
		}
	}

	// search contact by state name
	public void sortByName() {
		for (Map.Entry<String, Contact> entry : contactService.entrySet()) {
			System.out.println("The contacts in the Book of < " + entry.getKey() + " > are!...");
			List<PersonInformation> contactListByState = entry.getValue().contactList;
			List<PersonInformation> list = contactListByState.stream().collect(Collectors.toList());
			list.stream().sorted((g1, g2) -> ((String) g1.getFirstName()).compareTo(g2.getFirstName()))
					.forEach(contact -> System.out.println(contact));
		}
	}

	// search contact by city name
	public void sortByCity() {
		for (Map.Entry<String, Contact> entry : contactService.entrySet()) {
			System.out.println("The contacts in the Book of < " + entry.getKey() + " > are!...");
			List<PersonInformation> contactListByState = entry.getValue().contactList;
			List<PersonInformation> list = contactListByState.stream().collect(Collectors.toList());
			list.stream().sorted((g1, g2) -> ((String) g1.getCity()).compareTo(g2.getCity()))
					.forEach(contact -> System.out.println(contact));
		}
	}

	// count contact by state name
	public void sortByState() {
		for (Map.Entry<String, Contact> entry : contactService.entrySet()) {
			System.out.println("The contacts in the Book of < " + entry.getKey() + " > are!...");
			List<PersonInformation> contactListByState = entry.getValue().contactList;
			List<PersonInformation> list = contactListByState.stream().collect(Collectors.toList());
			list.stream().sorted((g1, g2) -> ((String) g1.getState()).compareTo(g2.getState()))
					.forEach(contact -> System.out.println(contact));
		}
	}

	// sort by zip code
	public void sortByZip() {
		for (Map.Entry<String, Contact> entry : contactService.entrySet()) {
			System.out.println("The contacts in the Book of < " + entry.getKey() + " > are!...");
			List<PersonInformation> contactListByState = entry.getValue().contactList;
			List<PersonInformation> list = contactListByState.stream().collect(Collectors.toList());
			list.stream().sorted((g1, g2) -> (g1.getZip()).compareTo(g2.getZip()))
					.forEach(contact -> System.out.println(contact));
		}
	}

	// print name of address books
	public void printBook() {
		System.out.println("Address Book Programs are: ");
		for (Map.Entry<String, Contact> entry : contactService.entrySet()) {
			System.out.println(entry.getKey());
		}
	}

	// print contacts of address books
	public void printContactsInBook() {
		for (Map.Entry<String, Contact> entry : contactService.entrySet()) {
			System.out.println("The contacts in the Book of < " + entry.getKey() + " > are!...");
			System.out.println(entry.getValue().contactList);
		}
		System.out.println(" ");
	}

	public void readAndWriteTextFile() throws IOException {
		while (true) {
			System.out.println("Enter\n 1. Read the tex File\n 2. Write In the text File\n 0. for previous menu");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				readFromFile();
				break;
			case 2:
				writeToFile();
				break;
			case 0:
				return;
			default:
				System.out.println("please enter correct choice");
			}
		}
		
	}

	//select option to read and write in text file
	public void writeToFile() throws IOException {
		FileWriter fw = new FileWriter(FILE_PATH);
		System.out.println("File Writing Started");

		for (Map.Entry<String, Contact> entry : contactService.entrySet()) {
			fw.write("The contacts in the Book of < ''" + entry.getKey() + "'' > are : \n");
			List<PersonInformation> contList = entry.getValue().contactList;
			for (int i = 0; i < contList.size(); i++) {
				fw.write("	{ First Name :" + contList.get(i).getFirstName() + ", Last Name :"
						+ contList.get(i).getLastName() + ", Address : " + contList.get(i).getAddress() + ", City : "
						+ contList.get(i).getCity() + ", State : " + contList.get(i).getState() + ", Zip : "
						+ contList.get(i).getZip() + ", Phone Number : " + contList.get(i).getPhoneNumber()
						+ ", Email ID : " + contList.get(i).getEmail() + " }\n");
			}
		}
		fw.close();
		System.out.println("File Writing closed");
	}

	//read contacts in text file
	public void readFromFile() throws IOException {
		FileReader fileReader = new FileReader(FILE_PATH);
		Scanner scanfile = new Scanner(fileReader);
		scanfile.useDelimiter("\\Z");
		System.out.println(scanfile.next() + " ");
		scanfile.close();
	}
	

	//select option to read and write in csv file
	public void readAndWriteCSVFile() throws IOException {
		while (true) {
			System.out.println("Enter\n 1. Read the CSV File\n 2. Write In the CSV File\n 0. for previous menu");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				readCSVFile();
				break;
			case 2:
				writeCSVFile();
				break;
			case 0:
				return;
			default:
				System.out.println("please enter correct choice");
			}
		}
	}


	// write in the csv file
	private void writeCSVFile() throws IOException {
		FileWriter fw = new FileWriter(CSV_FILE_PATH);
		fw.write("Address Book Name,FirstName,LastName,Address,State,Zip,Phone Number,E-mail\n");
		for (Map.Entry<String, Contact> entry : contactService.entrySet()) {
			List<PersonInformation> contList = entry.getValue().contactList;
			for (int i = 0; i < contList.size(); i++) {
				fw.write(entry.getKey() + "," + contList.get(i).getFirstName() + "," + contList.get(i).getLastName()
						+ "," + contList.get(i).getAddress() + "," + contList.get(i).getCity() + ","
						+ contList.get(i).getState() + "," + contList.get(i).getZip() + ","
						+ contList.get(i).getPhoneNumber() + "," + contList.get(i).getEmail() + "\n");
			}
		}
		fw.close();
	}

	// read csv file
	private void readCSVFile() throws IOException {
		FileReader fr = new FileReader(CSV_FILE_PATH);
		Scanner sc = new Scanner(fr);
		sc.useDelimiter("\\Z");
		System.out.println(sc.next() + " ");
		sc.close();
	}
	// write in the JSON file
	private void writeJSONFile() throws IOException {
		FileWriter fw = new FileWriter(JSON_FILE_PATH);
		fw.write("Address Book Name,FirstName,LastName,Address,State,Zip,Phone Number,E-mail\n");
		for (Map.Entry<String, Contact> entry : contactService.entrySet()) {
			List<PersonInformation> contList = entry.getValue().contactList;
			for (int i = 0; i < contList.size(); i++) {
				fw.write(entry.getKey() + "," + contList.get(i).getFirstName() + "," + contList.get(i).getLastName()
						+ "," + contList.get(i).getAddress() + "," + contList.get(i).getCity() + ","
						+ contList.get(i).getState() + "," + contList.get(i).getZip() + ","
						+ contList.get(i).getPhoneNumber() + "," + contList.get(i).getEmail() + "\n");
			}
		}
		fw.close();
	}
	// read csv file
	private void readJSONFile() throws IOException {
		FileReader fr = new FileReader(JSON_FILE_PATH);
		Scanner sc = new Scanner(fr);
		sc.useDelimiter("\\Z");
		System.out.println(sc.next() + " ");
		sc.close();
	}

	public void readAndWriteJSONFile() throws IOException {
		while (true) {
			System.out.println("Enter\n 1. Read the Json File\n 2. Write In the Json File\n 0. for previous menu");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				readJSONFile();
				break;
			case 2:
				writeJSONFile();
				break;
			case 0:
				return;
			default:
				System.out.println("please enter correct choice");
			}
		}
		
		
	}
	

}

package com.addressBook;

import java.util.Scanner;

public class AddressBook {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		Scanner scanner = new Scanner(System.in);
		Contact contact = new Contact();
		MultipleAddressBook multiAddressBook = new MultipleAddressBook();
		boolean flag = true;

		while (flag) {
			System.out.println("Enter \n 1. Add new AddressBook\n 2. Add contact in AddressBook\n " +
					"3. Edit the contact in AddressBook\n 4. Delete the contact in AddressBook\n 5. Delete the AddressBook\n " +
					"6. Search Contact By City in AddressBook\n 7. Search Contact By State in AddressBook\n 8. Print the AddressBook\n 9. Print the contacts in AddressBook\n 0. Exit Applcation");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				multiAddressBook.addAddressBook();
				break;
			case 2:
				multiAddressBook.addContact();
				break;
			case 3:
				multiAddressBook.editContactInBook();
				break;
			case 4:
				multiAddressBook.deleteContactInBook();
				break;
			case 5:
				multiAddressBook.deleteAddressBook();
				break;
			case 6:
				contact.searchByCity();
				break;
			case 7:
				contact.searchByState();
				break;
			case 8:
				multiAddressBook.printBook();
				break;
			case 9:
				multiAddressBook.printContactsInBook();
				break;
			case 0:
				System.out.println("Exit Application");
				flag = false;
				break;
			default:
				System.out.println("Enter the wrong input");
			}
		}
	}
	
}

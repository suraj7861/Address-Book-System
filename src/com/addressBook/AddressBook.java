package com.addressBook;

import java.util.Scanner;

public class AddressBook {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		Scanner sc = new Scanner(System.in);
		Contact contact = new Contact();
		boolean flag = true;
		while (flag) {
			System.out.println("Enter \n 1. To add The contact \n  2. To exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				contact.addContact();
				break;
			case 2:
				System.out.println("Exit");
				flag = false;
				break;
			default:
				System.out.println("Invalid input");
				continue;
			}
		}
	}

}

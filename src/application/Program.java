package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Initial Balance: ");
			Double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
			
			Account account = new Account(number, name, balance, withdrawLimit);
			System.out.println(account);
			
			System.out.println("");
			System.out.print("Enter amount for withdaw: ");
			double withdraw = sc.nextDouble();
			account.withdraw(withdraw);
			
			
			sc.close();

		}
//		catch (RuntimeException e) {
//			System.out.println("SYSTEM ERROR - Unexpected error.");
//		}
		catch (DomainException e) {
			System.out.println("Withdraw Error: " + e.getMessage());
		}

	}

}

package models;

import models.entities.Account;
import models.exceptions.ServicesException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            sc.nextLine();
            System.out.print("Holder: ");
            String name = sc.nextLine();
            System.out.print("Initial balance: ");
            Double initialBalance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            Double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, name, initialBalance, withdrawLimit);

            System.out.print("\nEnter the amount for withdraw: ");
            Double withdraw = sc.nextDouble();
            account.withdraw(withdraw);

        } catch(ServicesException e) {
            System.out.println(e.getMessage());
        }
    }
}

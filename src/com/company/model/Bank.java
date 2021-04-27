package com.company.model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bank {
    private static final List<Customer> customers = new ArrayList<>();
    private static List<Customer> person;

    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public static void portal(){
        Scanner idScanner = new Scanner(System.in);
        System.out.println("Enter your customer id");
        String customerId = idScanner.nextLine();
        List<String> ids = new ArrayList<>();
        for(Customer customer: customers){
            ids.add(customer.getId());
        }
        if(!ids.contains(customerId)){
            System.err.println("Customer not found");
            portal();
        }
        person = customers.stream().filter(customer -> customer.getId().equals(customerId)).collect(Collectors.toList());
        System.out.println("\nWelcome " + person.get(0).getName());
        process();
    }

    public static void process() {
        System.out.println("\n*********************************************");
            System.out.println("press 1 to create a saving account" +
                    "\npress 2 to create a credit account" +
                    "\npress 3 to view all your accounts" +
                    "\npress 4 to deposit money" +
                    "\npress 5 to withdraw money" +
                    "\npress any other key to quit");
        System.out.println("*********************************************");

            Scanner menuScanner = new Scanner(System.in);
            String input = menuScanner.nextLine();
            if (input.equals("1")) {
                String createdAccountNumber = String.valueOf((int) (Math.random() * 1000000));
                Account account = new SavingAccount(createdAccountNumber);
                person.get(0).addAccounts(account);
                System.out.println("saving account created successfully with number " + createdAccountNumber + "\n");
                process();
            }
            else if (input.equals("2")) {
                String createdAccountNumber = String.valueOf((int) (Math.random() * 1000000));
                Account account = new CreditAccount(createdAccountNumber);
                person.get(0).addAccounts(account);
                System.out.println("credit account created successfully with number " + createdAccountNumber + "\n");
                process();
            }
            else if (input.equals("3")) {
                person.get(0).viewAllAccounts();
                process();
            }
            else if (input.equals("4")) {
                try {
                    Scanner accountNumberScanner = new Scanner(System.in);
                    System.out.println("Enter account number");
                    String accountNumber = accountNumberScanner.nextLine();
                    Scanner amountScanner = new Scanner(System.in);
                    System.out.println("Enter deposit amount");
                    Double amount = amountScanner.nextDouble();
                    System.out.println(person.get(0).deposit(accountNumber, amount));
                    process();
                }  catch (InputMismatchException inputMismatchException) {
                    System.err.println("Account number/amount should be of type number, please try again");
                }
                finally {
                    process();
                }
            }
            else if (input.equals("5")) {
                try {
                    Scanner accountNumberScanner = new Scanner(System.in);
                    System.out.println("Enter account number");
                    String accountNumber = accountNumberScanner.nextLine();
                    Scanner amountScanner = new Scanner(System.in);
                    System.out.println("Enter withdrawal amount");
                    Double amount = amountScanner.nextDouble();
                    System.out.println(person.get(0).withdraw(accountNumber, amount));
                    process();
                }catch (InputMismatchException inputMismatchException) {
                    System.err.println("Account number/amount should be of type number, please try again");
                }
                finally {
                    process();
                }

            }
            else {
                return;
            }
    }
}
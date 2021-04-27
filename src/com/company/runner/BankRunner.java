package com.company.runner;

import com.company.model.*;

public class BankRunner {

    public static void startUp() {
        //create customers
        Customer john = new Customer("001", "John");
        Account johnAccount = john.createAccount(new SavingAccount("0101"));

        Customer amina = new Customer("002", "Amina");
        Account AminaAccount = amina.createAccount(new CreditAccount("1234"));

        Customer phoebe = new Customer("003", "Phoebe");
        Account phoebeAccount = phoebe.createAccount(new CreditAccount("9874"));

        Customer abdul = new Customer("004", "Abdul");
        Account abdulAccount = abdul.createAccount(new SavingAccount("6543"));

        //additional
//        System.out.println(john.deposit("0101", 500));
//        System.out.println(johnAccount.calculateInterest());
//        System.out.println(johnAccount.getInterestRate());
//        System.out.println(johnAccount.getBalance());

        //add customers to bank data
        Bank.addCustomer(john);
        Bank.addCustomer(amina);
        Bank.addCustomer(phoebe);
        Bank.addCustomer(abdul);

        //bank portal
        Bank.portal();

    }
}

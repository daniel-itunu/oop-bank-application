package com.company.model;

public class CreditAccount extends Account{

    public CreditAccount(String accountNumber) {
        super(accountNumber);
        super.setInterestRate(0.005D);
        super.setAccountType("credit account");
        super.setLimit(5000);
    }

    @Override
    public double calculateInterest() {
       return super.getBalance() * super.getInterestRate();
    }
}

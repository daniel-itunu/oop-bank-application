package com.company.model;

public class SavingAccount extends Account{

    public SavingAccount(String accountNumber) {
        super(accountNumber);
        super.setInterestRate(0.01D);
        super.setAccountType("saving account");
    }

    @Override
    public double calculateInterest() {
        return super.getBalance() * super.getInterestRate();
    }
}

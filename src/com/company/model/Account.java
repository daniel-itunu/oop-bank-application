package com.company.model;

public abstract class Account {
    private String accountNumber;
    private String accountType;
    private double balance;
    private double interestRate;

    public void setLimit(int limit) {
        this.limit = limit;
    }

    private int limit;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getInterestRate() {
        return interestRate;
    }

    void setInterestRate(double interest) {
        this.interestRate = interest;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public int getLimit() {
        return limit;
    }


    public String deposit(double amount) {
        this.balance = balance + amount;
        return amount+" deposited successfully. current balance is "+balance;
    }

    public String withdraw(double amount) {
        this.balance = balance - amount;
        return amount+" withdrawn successfully. current balance is "+balance;
    }

    public abstract double calculateInterest();
}

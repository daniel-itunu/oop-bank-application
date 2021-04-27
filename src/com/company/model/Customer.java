package com.company.model;

import com.company.service.BankService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Customer implements BankService {
    List<Account> accounts = new ArrayList<>();
    private String id;
    private String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccounts(Account account) {
        this.accounts.add(account);
    }


    @Override
    public SavingAccount createSavingAccount(SavingAccount savingAccount) {
        accounts.add(savingAccount);
        return savingAccount;
    }

    @Override
    public CreditAccount createCreditAccount(CreditAccount creditAccount) {
        accounts.add(creditAccount);
        return creditAccount;
    }

    public Account createAccount(Account account){
        accounts.add(account);
        return account;
    }

    @Override
    public void viewAllAccounts() {
        accounts.forEach(account -> {
            if(account.getAccountType().equals("credit account")){
                System.out.println("Account Number: "+account.getAccountNumber()+
                        " | Account Type: "+account.getAccountType()+
                        " | Balance: "+account.getBalance()+
                        " | Interest Rate: "+account.getInterestRate()+"" +
                        " | Credit Limit: "+account.getLimit());
            } else{
                System.out.println("Account Number: "+account.getAccountNumber()+
                        " | Account Type: "+account.getAccountType()+
                        " | Balance: "+account.getBalance()+
                        " | Interest Rate: "+account.getInterestRate());
            }
        });
    }

    @Override
    public String deposit(String accountNumber, double amount) {
            List<String> accountNumbers = new ArrayList<>();
            for(Account account: accounts){
                accountNumbers.add(account.getAccountNumber());
            }
            if(!accountNumbers.contains(accountNumber)){
                return "Account number not found";
            }
            List<Account> found = accounts.stream().filter(account -> account.getAccountNumber().equals(accountNumber)).collect(Collectors.toList());
            if(amount == 0){
                return "empty deposit, deposit non zero cannot be zero";
            }
            return found.get(0).deposit(amount);
    }

    @Override
    public String withdraw(String accountNumber, double amount) {
        List<String> accountNumbers = new ArrayList<>();
        for(Account account: accounts){
            accountNumbers.add(account.getAccountNumber());
        }
        if(!accountNumbers.contains(accountNumber)){
            return "Account number not found";
        }
        List<Account> found = accounts.stream().filter(account -> account.getAccountNumber().equals(accountNumber)).collect(Collectors.toList());

        if(found.get(0).getAccountType().equals("credit account")){
            if(found.get(0).getBalance() <= -5000 || amount > 5000){
                return "Limit exceeded 5000SEK";
            } else {
                return found.get(0).withdraw(amount);
            }
        }
        if(found.get(0).getAccountType().equals("saving account")){
            if(found.get(0).getBalance()<amount){
                return "Insufficient fund";
            }
        }
        return found.get(0).withdraw(amount);
    }
}

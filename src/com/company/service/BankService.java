package com.company.service;

import com.company.model.CreditAccount;
import com.company.model.SavingAccount;

public interface BankService {
    SavingAccount createSavingAccount(SavingAccount savingAccount);
    CreditAccount createCreditAccount(CreditAccount creditAccount);
    void viewAllAccounts();
    String deposit(String accountNumber, double amount);
    String withdraw(String accountNumber, double amount);
}

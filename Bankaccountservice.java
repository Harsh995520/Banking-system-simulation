package com.bankingsystem.services;

import com.bankingsystem.dao.BankAccountDAO;
import com.bankingsystem.models.BankAccount;

import java.util.List;

public class BankAccountService {
    private final BankAccountDAO bankAccountDAO;

    public BankAccountService(BankAccountDAO bankAccountDAO) {
        this.bankAccountDAO = bankAccountDAO;
    }

    public BankAccount createAccount(BankAccount account) {
        return bankAccountDAO.save(account);
    }

    public List<BankAccount> getAllAccounts() {
        return bankAccountDAO.findAll();
    }

    public BankAccount getAccountById(int accountId) {
        return bankAccountDAO.findById(accountId);
    }

    public boolean deleteAccount(int accountId) {
        return bankAccountDAO.delete(accountId);
    }
}

package com.bankingsystem.dao;

import com.bankingsystem.models.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class BankAccountDAO {
    private final List<BankAccount> accounts = new ArrayList<>();

    public BankAccount save(BankAccount account) {
        accounts.add(account);
        return account;
    }

    public List<BankAccount> findAll() {
        return new ArrayList<>(accounts);
    }

    public BankAccount findById(int accountId) {
        return accounts.stream()
                .filter(account -> account.getId() == accountId)
                .findFirst()
                .orElse(null);
    }

    public boolean delete(int accountId) {
        return accounts.removeIf(account -> account.getId() == accountId);
    }
}

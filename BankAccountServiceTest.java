package com.bankingsystem.services;

import com.bankingsystem.dao.BankAccountDAO;
import com.bankingsystem.models.BankAccount;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BankAccountServiceTest {
    private BankAccountDAO bankAccountDAO;
    private BankAccountService bankAccountService;

    @Before
    public void setUp() {
        bankAccountDAO = mock(BankAccountDAO.class);
        bankAccountService = new BankAccountService(bankAccountDAO);
    }

    @Test
    public void testCreateAccount() {
        BankAccount account = new BankAccount(1, "John Doe", 1000.0);
        when(bankAccountDAO.save(account)).thenReturn(account);

        BankAccount result = bankAccountService.createAccount(account);

        assertNotNull(result);
        assertEquals("John Doe", result.getAccountHolderName());
        assertEquals(1000.0, result.getBalance(), 0);
        verify(bankAccountDAO, times(1)).save(account);
    }

    @Test
    public void testGetAllAccounts() {
        List<BankAccount> accounts = Arrays.asList(
                new BankAccount(1, "John Doe", 1000.0),
                new BankAccount(2, "Jane Doe", 2000.0)
        );
        when(bankAccountDAO.findAll()).thenReturn(accounts);

        List<BankAccount> result = bankAccountService.getAllAccounts();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(bankAccountDAO, times(1)).findAll();
    }

    @Test
    public void testGetAccountById() {
        BankAccount account = new BankAccount(1, "John Doe", 1000.0);
        when(bankAccountDAO.findById(1)).thenReturn(account);

        BankAccount result = bankAccountService.getAccountById(1);

        assertNotNull(result);
        assertEquals("John Doe", result.getAccountHolderName());
        verify(bankAccountDAO, times(1)).findById(1);
    }

    @Test
    public void testDeleteAccount() {
        when(bankAccountDAO.delete(1)).thenReturn(true);

        boolean result = bankAccountService.deleteAccount(1);

        assertTrue(result);
        verify(bankAccountDAO, times(1)).delete(1);
    }
}

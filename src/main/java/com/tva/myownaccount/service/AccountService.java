package com.tva.myownaccount.service;

import java.util.List;

import com.tva.myownaccount.model.Account;

public interface AccountService {

  public List<Account> getAllAccounts();

  public Account getAccountById(String accountId);
  
  public Account addAccount(Account account);
  
  public void deleteAccount(Account account);

}

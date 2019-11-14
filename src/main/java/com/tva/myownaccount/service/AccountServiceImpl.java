package com.tva.myownaccount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tva.myownaccount.model.Account;
import com.tva.myownaccount.repositorie.AccountRepository;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

  @Autowired
  private AccountRepository accountRepo;

  @Override
  public List<Account> getAllAccounts() {
    return accountRepo.findAll();
  }

  @Override
  public Account getAccountById(String accountId) {
    return accountRepo.findByid(accountId);
  }

  @Override
  public Account addAccount(Account account) {
	return accountRepo.save(account);
  }

  @Override
  public void deleteAccount(Account account) {
	  accountRepo.delete(account);
  }

}

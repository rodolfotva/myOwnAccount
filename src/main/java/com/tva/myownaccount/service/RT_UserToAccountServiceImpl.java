package com.tva.myownaccount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tva.myownaccount.model.RT_UserToAccount;
import com.tva.myownaccount.repositorie.RT_UserToAccountRepository;

@Service("rtusertoaccountService")
@Transactional
public class RT_UserToAccountServiceImpl implements RT_UserToAccountService {

  @Autowired
  private RT_UserToAccountRepository repo;

  @Override
  public List<RT_UserToAccount> getAllValues() {
    return repo.findAll();
  }

  @Override
  public List<RT_UserToAccount> getByAccountId(String accountId) {
    return repo.findByAccountId(accountId);
  }

  @Override
  public List<RT_UserToAccount> getByUserId(String userId) {
    return repo.findByUserId(userId);
  }

}

package com.tva.myownaccount.service;

import java.util.List;

import com.tva.myownaccount.model.RT_UserToAccount;

public interface RT_UserToAccountService {

  public List<RT_UserToAccount> getAllValues();

  public List<RT_UserToAccount> getByAccountId(String accountId);

  public List<RT_UserToAccount> getByUserId(String userId);
}

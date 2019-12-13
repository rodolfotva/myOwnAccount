package com.tva.myownaccount.service;

import java.util.List;

import com.tva.myownaccount.model.Lineitem;

public interface LineitemService {

  public List<Lineitem> getAllLineitems();

  public List<Lineitem> getLineitemsByAccount(String accountId);
  
  public Lineitem addLineitem(Lineitem lineitem);

}

package com.tva.myownaccount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tva.myownaccount.model.Lineitem;
import com.tva.myownaccount.repositorie.LineitemRepository;

@Service("lineitemService")
@Transactional
public class LineitemServiceImpl implements LineitemService {

  @Autowired
  private LineitemRepository lineitemRepo;

  @Override
  public List<Lineitem> getAllLineitems() {
    return lineitemRepo.findAll();
  }

  @Override
  public List<Lineitem> getLineitemsByAccount(String accountId) {
    return lineitemRepo.findByAccount(accountId);
  }

  @Override
  public Lineitem addLineitem(Lineitem lineitem) {
	return lineitemRepo.save(lineitem);
  }

}

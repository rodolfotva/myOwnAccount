package com.tva.myownaccount.repositorie;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tva.myownaccount.model.Lineitem;

@Repository
public interface LineitemRepository extends MongoRepository<Lineitem, String> {

  @Query("{'id':?0}")
  Lineitem findByid(String id);

  @Query("{'accountId':?0}")
  List<Lineitem> findByAccount(String accountId);

  @Query("{'userId':?0}")
  List<Lineitem> findByUser(String userId);

}

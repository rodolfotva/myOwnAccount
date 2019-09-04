package com.tva.myownaccount.repositorie;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tva.myownaccount.model.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

  @Query("{'id':?0}")
  Account findByid(String id);

  @Query("{'name':?0}")
  List<Account> findByName(String name);

}

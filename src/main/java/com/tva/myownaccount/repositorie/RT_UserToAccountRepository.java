package com.tva.myownaccount.repositorie;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tva.myownaccount.model.RT_UserToAccount;

@Repository
public interface RT_UserToAccountRepository extends MongoRepository<RT_UserToAccount, String> {


  @Query("{'accountId':?0}")
  List<RT_UserToAccount> findByAccountId(String accountId);

  @Query("{'userId':?0}")
  List<RT_UserToAccount> findByUserId(String userId);

}

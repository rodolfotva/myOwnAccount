package com.tva.myownaccount.repositorie;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tva.myownaccount.model.Header;

@Repository
public interface HeaderRepository extends MongoRepository<Header, String> {

  @Query("{'id':?0}")
  Header findByid(String id);

  @Query("{'key':?0}")
  List<Header> findByKey(String key);

}

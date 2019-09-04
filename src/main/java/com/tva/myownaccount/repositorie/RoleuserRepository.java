package com.tva.myownaccount.repositorie;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tva.myownaccount.model.Roleuser;

@Repository
public interface RoleuserRepository extends MongoRepository<Roleuser, String> {

  @Query("{'id':?0}")
  Roleuser findByid(String id);

  @Query("{'role':?0}")
  List<Roleuser> findByRole(String role);

}

package com.tva.myownaccount.repositorie;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tva.myownaccount.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

  @Query("{'id':?0}")
  User findByid(String id);

  @Query("{'name':?0}")
  List<User> findByName(String name);

  @Query("{'familyname':?0}")
  List<User> findByFamilyname(String familyname);

  @Query("{'email':?0}")
  User findByEmail(String email);

  @Query("{'username':?0}")
  User findByUsername(String username);

  @Query("{'password':?0}")
  User findByPass(String password);

  @Query("{'username':?0, 'password':?1}")
  User findByPassAndUser(String username, String password);

}

package com.tva.myownaccount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tva.myownaccount.model.User;
import com.tva.myownaccount.repositorie.UserRepository;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepo;

  @Override
  public List<User> getAllUsers() {
    return userRepo.findAll();
  }

  @Override
  public User getUserByUsername(String username) {
    return userRepo.findByUsername(username);
  }

  @Override
  public User getUserByPass(String pass) {
    return userRepo.findByPass(pass);
  }

  @Override
  public User getUserByPassAndUser(String username, String password) {
    return userRepo.findByPassAndUser(username, password);
  }

}

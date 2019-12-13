package com.tva.myownaccount.service;

import java.util.List;

import com.tva.myownaccount.model.User;

public interface UserService {

  public List<User> getAllUsers();

  public User getUserByUsername(String username);

  public User getUserByPass(String pass);

  public User getUserByPassAndUser(String username, String pass);

  public User getUserByid(String userId);
}

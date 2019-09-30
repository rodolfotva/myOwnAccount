package com.tva.myownaccount.controller;

import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tva.myownaccount.model.User;
import com.tva.myownaccount.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  private static final Logger logger = LogManager.getLogger(UserController.class.getName());

  public UserController() {
    logger.info("Initializing User Controller");
  }

  @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<User>> listAllUsers() {
    logger.info("listAllUsers ResponseEntity");
    List<User> userLst = userService.getAllUsers();

    if (Objects.isNull(userLst) || userLst.isEmpty()) {
      return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
    }

    logger.info("Users found: " + userLst.size());
    return new ResponseEntity<List<User>>(userLst, HttpStatus.OK);
  }

  @RequestMapping(value = "/login/{username}/{pass}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> login(@PathVariable("username") String username, @PathVariable("pass") String pass) {
    logger.info("Login ResponseEntity");
    User userUsername = userService.getUserByUsername(username);

    if (Objects.isNull(userUsername)) {
      return new ResponseEntity<String>("Username not found", HttpStatus.NO_CONTENT);
    } else {
      User userPass = userService.getUserByPassAndUser(username, pass);
      if (Objects.isNull(userPass)) {
        return new ResponseEntity<String>("Wrong password", HttpStatus.NO_CONTENT);
      }
    }

    logger.info("Login ok: " + username);
    return new ResponseEntity<String>("Login success", HttpStatus.OK);
  }

}

package com.tva.myownaccount.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import com.tva.myownaccount.model.SpringUserDetails;
import com.tva.myownaccount.model.User;

@RestController
@RequestMapping("/login")
public class LoginController {

  private static final Logger logger = LogManager.getLogger(LoginController.class.getName());

  public LoginController() {
    logger.info("Initializing Login Controller");
  }

  @RequestMapping(value = "/failed", method = RequestMethod.GET)
  public ResponseEntity<String> loginError() {
	logger.info("Login attempt failed");
    return new ResponseEntity<String>("true", HttpStatus.OK);
  }
  
  @RequestMapping(value = "/out", method = RequestMethod.GET)
  public String logout(SessionStatus session) {
      SecurityContextHolder.getContext().setAuthentication(null);
      session.setComplete();
      return "redirect:/login";
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String postLogin(Model model, HttpSession session) {
	logger.info("postLogin()");
	UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
	validatePrinciple(authentication.getPrincipal());
	User loggedInUser = ((SpringUserDetails) authentication.getPrincipal()).getUserDetails();
	model.addAttribute("currentUser", loggedInUser.getUsername());
	session.setAttribute("userId", loggedInUser.getId());
	return "redirect:/accountmain";
  }
  
  private void validatePrinciple(Object principal) {
	if (!(principal instanceof SpringUserDetails)) {
	    throw new  IllegalArgumentException("Principal can not be null!");
	}
  }

}

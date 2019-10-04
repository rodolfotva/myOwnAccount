package com.tva.myownaccount.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{locale:en|fr|pt}/")
public class PagesController {

  private static final Logger logger = LogManager.getLogger(PagesController.class.getName());

  @GetMapping
  public String getIndexPage() {
    logger.info("loading index locale page");
    return "index";
  }

  @GetMapping(value = "page1")
  public String getPage1Page() {
    logger.info("loading page1 page");
    return "page1";
  }

  @GetMapping(value = "page2")
  public String getPage2Page() {
    logger.info("loading page2 page");
    return "page2";
  }
  
  @GetMapping(value = "login")
  public String getLoginPage() {
    logger.info("loading login page");
    return "login";
  }

  @GetMapping(value = "accountmain")
  public String getAccountMainPage() {
    logger.info("loading account main page");
    return "accountmain";
  }

  @GetMapping(value = "account")
  public String getAccountPage() {
    logger.info("loading account page");
    return "account";
  }
  
  @GetMapping(value = "lineitem")
  public String getLineitemPage() {
    logger.info("loading lineitem page");
    return "lineitem";
  }
}

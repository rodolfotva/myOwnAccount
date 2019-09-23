package com.tva.myownaccount.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/{locale:en|fr|pt}/")
public class PagesController {

  private static final Logger logger = LogManager.getLogger(PagesController.class.getName());

  @RequestMapping(method = RequestMethod.GET)
  public String getIndexPage() {
    logger.info("loading index locale page");
    return "index";
  }

  @RequestMapping(value = "page1", method = RequestMethod.GET)
  public String getPage1Page() {
    logger.info("loading page1 page");
    return "page1";
  }

  @RequestMapping(value = "page2", method = RequestMethod.GET)
  public String getPage2Page() {
    logger.info("loading page2 page");
    return "page2";
  }
  
  @RequestMapping(value = "login", method = RequestMethod.GET)
  public String getLoginPage() {
    logger.info("loading login page");
    return "login";
  }

  @RequestMapping(value = "accountmain", method = RequestMethod.GET)
  public String getAccountMainPage() {
    logger.info("loading account main page");
    return "accountmain";
  }

  @RequestMapping(value = "account", method = RequestMethod.GET)
  public String getAccountPage() {
    logger.info("loading account page");
    return "account";
  }
  
  @RequestMapping(value = "lineitem", method = RequestMethod.GET)
  public String getLineitemPage() {
    logger.info("loading lineitem page");
    return "lineitem";
  }
}

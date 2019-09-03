package com.tva.myownaccount.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

  private static final Logger logger = LogManager.getLogger(IndexController.class.getName());

  @RequestMapping(method = RequestMethod.GET)
  public String getIndexPage() {
    logger.info("loading index page");
    return "redirect:en/";
  }

}

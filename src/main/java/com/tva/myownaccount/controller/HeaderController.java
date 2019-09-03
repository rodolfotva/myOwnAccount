package com.tva.myownaccount.controller;

import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tva.myownaccount.model.Header;
import com.tva.myownaccount.service.HeaderService;

@RestController
@RequestMapping("/header")
public class HeaderController {

  @Autowired
  private HeaderService service;

  private static final Logger logger = LogManager.getLogger(HeaderController.class.getName());

  public HeaderController() {
    logger.info("Initializing Group Controller");
  }

  @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Header>> listAllHeaders() {
    logger.info("listAllGroups ResponseEntity");
    List<Header> groupLst = service.getAllHeaders();

    if (Objects.isNull(groupLst) || groupLst.isEmpty()) {
      return new ResponseEntity<List<Header>>(HttpStatus.NO_CONTENT);
    }

    logger.info("Headers found: " + groupLst.size());
    return new ResponseEntity<List<Header>>(groupLst, HttpStatus.OK);

  }


}

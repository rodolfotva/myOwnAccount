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

import com.tva.myownaccount.model.Lineitem;
import com.tva.myownaccount.service.LineitemService;

@RestController
@RequestMapping("/lineitem")
public class LineitemController {

  @Autowired
  private LineitemService service;

  private static final Logger logger = LogManager.getLogger(LineitemController.class.getName());

  public LineitemController() {
    logger.info("Initializing Lineitem Controller");
  }

  @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Lineitem>> listAllLineitens() {
    logger.info("listAllAccounts ResponseEntity");
    List<Lineitem> lineitenLst = service.getAllLineitems();

    if (Objects.isNull(lineitenLst) || lineitenLst.isEmpty()) {
      return new ResponseEntity<List<Lineitem>>(HttpStatus.NO_CONTENT);
    }

    logger.info("Lineitens found: " + lineitenLst.size());
    return new ResponseEntity<List<Lineitem>>(lineitenLst, HttpStatus.OK);
  }

  @RequestMapping(value = "/byaccount/{accountId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Lineitem>> getLineitemByAccount(@PathVariable("accountId") String accountId) {
    logger.info("getLineitemByAccount ResponseEntity");
    List<Lineitem> lineitenLst = service.getLineitemsByAccount(accountId);

    if (Objects.isNull(lineitenLst) || lineitenLst.isEmpty()) {
      return new ResponseEntity<List<Lineitem>>(HttpStatus.NO_CONTENT);
    }

    logger.info("Lineitens found: " + lineitenLst.size());
    return new ResponseEntity<List<Lineitem>>(lineitenLst, HttpStatus.OK);
  }

}

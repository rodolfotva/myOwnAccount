package com.tva.myownaccount.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tva.myownaccount.model.Account;
import com.tva.myownaccount.model.Lineitem;
import com.tva.myownaccount.model.User;
import com.tva.myownaccount.service.LineitemService;
import com.tva.myownaccount.service.UserService;

@RestController
@RequestMapping("/lineitem")
public class LineitemController {

  @Autowired
  private LineitemService service;

  @Autowired
  private UserService userService;

  private static final Logger logger = LogManager.getLogger(LineitemController.class.getName());

  public LineitemController() {
    logger.info("Initializing Lineitem Controller");
  }

  @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Lineitem>> listAllLineitems() {
    logger.info("listAllAccounts ResponseEntity");
    List<Lineitem> lineitenLst = service.getAllLineitems();

    if (Objects.isNull(lineitenLst) || lineitenLst.isEmpty()) {
      return new ResponseEntity<List<Lineitem>>(HttpStatus.NO_CONTENT);
    }

    logger.info("Lineitens found: " + lineitenLst.size());
    return new ResponseEntity<List<Lineitem>>(lineitenLst, HttpStatus.OK);
  }

  @RequestMapping(value = "/byaccount/{accountId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, Object>> getLineitemByAccount(@PathVariable("accountId") String accountId) {
    logger.info("getLineitemByAccount ResponseEntity");
	Map<String, Object> values = new HashMap<String, Object>();

    List<Lineitem> lineitenLst = service.getLineitemsByAccount(accountId);
	values.put("lineitenLst", lineitenLst);
	
	Double total = lineitenLst.stream().mapToDouble(line -> line.getValue()).sum();
	values.put("total", total);

    if (Objects.isNull(lineitenLst) || lineitenLst.isEmpty()) {
      return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
    }

    logger.info("Lineitens found: " + lineitenLst.size());
    return new ResponseEntity<Map<String, Object>>(values, HttpStatus.OK);
  }

  @GetMapping(value = "/add/{description}/{value}/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Boolean> addLineItem(@PathVariable("description") String description, @PathVariable("value") Double value, @PathVariable("accountId") String accountId, HttpSession session) {
		if (Objects.isNull(session.getAttribute("userId")) || Objects.isNull(description) || Objects.isNull(value) || Objects.isNull(accountId)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		logger.info("addLineitem (description:  " + description + " value: " + value + " accountId: " + accountId + "}");
		
		String userId = session.getAttribute("userId").toString(); 
		User user = userService.getUserByid(userId);
		ObjectId objectId = new ObjectId();
		Lineitem lineitem = new Lineitem(objectId, objectId.toString(), description, accountId, user.getName()+" "+ user.getFamilyname(), new Date(), value);
		
		if (Objects.isNull(service.addLineitem(lineitem))) {
			logger.error("Error adding lineitem");
			return new ResponseEntity<Boolean>(new Boolean(false), HttpStatus.OK);
		}
		
		return new ResponseEntity<Boolean>(new Boolean(true), HttpStatus.OK);
  }
}

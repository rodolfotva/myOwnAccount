package com.tva.myownaccount.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tva.myownaccount.model.Account;
import com.tva.myownaccount.model.RT_UserToAccount;
import com.tva.myownaccount.service.AccountService;
import com.tva.myownaccount.service.RT_UserToAccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private RT_UserToAccountService rtService;

	private static final Logger logger = LogManager.getLogger(AccountController.class.getName());

	public AccountController() {
		logger.info("Initializing Account Controller");
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> listAllAccounts() {
		logger.info("listAllAccounts ResponseEntity");
		List<Account> accountLst = accountService.getAllAccounts();

		if (Objects.isNull(accountLst) || accountLst.isEmpty()) {
			return new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);
		}

		logger.info("Accounts found: {}", accountLst.size());
		return new ResponseEntity<List<Account>>(accountLst, HttpStatus.OK);
	}

	@GetMapping(value = "/byuser/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> listAccountsFromUser(@PathVariable("userId") String userId, HttpSession session) {

		if (Objects.isNull(session.getAttribute("userId"))) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		logger.info("listAccountsFromUser ResponseEntity");
		List<RT_UserToAccount> rtEntity = rtService.getByUserId(String.valueOf(session.getAttribute("userId")));
		List<Account> accountLst = new ArrayList<Account>();

		for (RT_UserToAccount value : rtEntity) {
			Account account = accountService.getAccountById(value.getAccountId());
			if (Objects.nonNull(account)) {
				accountLst.add(account);
			}
		}

		if (Objects.isNull(accountLst) || accountLst.isEmpty()) {
			return new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);
		}

		logger.info("Accounts found: {}", accountLst.size());
		return new ResponseEntity<List<Account>>(accountLst, HttpStatus.OK);
	}

	@GetMapping(value = "/byuser2", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> listAccountsFromUser111() {
		logger.info("listAccountsFromUser ResponseEntity");
		return new ResponseEntity<String>("abc", HttpStatus.OK);
	}

}

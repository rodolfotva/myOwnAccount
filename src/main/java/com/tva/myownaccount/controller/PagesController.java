package com.tva.myownaccount.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/{locale:en|fr|pt}/")
public class PagesController {

	private static final Logger logger = LogManager.getLogger(PagesController.class.getName());

	public PagesController() {
		logger.info("Initializing Page Controller");
	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String getIndexPage() {
		logger.info("loading index locale page");
		return "index";
	}

	@GetMapping(value = "login")
	public String getLoginPage(HttpSession session) {
		logger.info("loading login page");
		return "login";
	}

	@RequestMapping(value = "accountmain", method = { RequestMethod.GET, RequestMethod.POST })
	public String getAccountMainPage(HttpSession session) {
		logger.info("loading account main page");
		if (StringUtils.isEmpty(session.getAttribute("userId"))) {
			return getLoginPage(session);
		}
		return "accountmain";
	}

	@RequestMapping(value = "account", method = { RequestMethod.GET, RequestMethod.POST })
	public String getAccountPage(HttpSession session) {
		logger.info("loading account page");
		if (StringUtils.isEmpty(session.getAttribute("userId"))) {
			return getLoginPage(session);
		}
		return "account";
	}

	@GetMapping(value = "lineitem")
	public String getLineitemPage() {
		logger.info("loading lineitem page");
		return "lineitem";
	}
	
	@GetMapping(value = "addaccount")
	public String getAddAccountPage() {
		logger.info("loading addaccount page");
		return "addaccount";
	}
}

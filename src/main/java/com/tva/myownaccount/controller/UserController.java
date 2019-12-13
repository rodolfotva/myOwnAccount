package com.tva.myownaccount.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.ArrayBuilders.BooleanBuilder;
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

	@GetMapping(value = "/login/{username}/{pass}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> login(@PathVariable("username") String username, @PathVariable("pass") String pass, HttpSession session) {
		logger.info("Login ResponseEntity");

		User userPass = null;
		User userUsername = null;
		Map<String, Object> values = new HashMap<String, Object>();

		userUsername = userService.getUserByUsername(username);

		if (Objects.isNull(userUsername)) {
			values.put("loginStatus", "401");
			return new ResponseEntity<Map<String, Object>>(values, HttpStatus.OK);
		} else {
			// userPass = userService.getUserByPassAndUser(username,
			// passwordEncoder.encode(pass));
			userPass = userService.getUserByPassAndUser(username, pass);
			if (Objects.isNull(userPass)) {
				values.put("loginStatus", "402");
				return new ResponseEntity<Map<String, Object>>(values, HttpStatus.OK);
			}
		}

		session.setAttribute("userId", userPass.getId());
		session.setAttribute("userName", userPass.getName());
		session.setAttribute("isAdmin", userPass.getIsAdmin());
		values.put("userId", userPass.getId());
		values.put("loginStatus", "200");
		values.put("usercompname", userPass.getName() + " " + userPass.getFamilyname());

		logger.info("Login ok: " + username);
		return new ResponseEntity<Map<String, Object>>(values, HttpStatus.OK);
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public ResponseEntity<Boolean> logout(HttpSession session) {
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		session.invalidate();
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

}

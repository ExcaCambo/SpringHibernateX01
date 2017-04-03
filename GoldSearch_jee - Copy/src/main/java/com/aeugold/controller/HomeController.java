package com.aeugold.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aeugold.model.User;
import com.aeugold.service.UserService;

@RestController
@RequestMapping("/api")
public class HomeController {

	private final String OK_MESSAGE = "DATA PROCCESS OK";
	private final String NO_MESSAGE = "DATA DOES NOT PROCCESS";
	private final String ER_MESSAGE = "DATA PROCCESS ERROR";

	@Autowired
	private UserService user_service;

	/* ====================== GET DATA FROM SERVER ======================= */
	@RequestMapping(value = { "/getUser", }, method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> selectUsers() {
		System.out.println("Selecting User");
		Map<String, Object> map = new Hashtable<String, Object>();
		try {
			ArrayList<User> user = user_service.getUsersX();
			if (!user.isEmpty()) {
				map.put("MESSAGE", OK_MESSAGE);
				map.put("STATE", true);
				map.put("DATA", user);
			} else {
				map.put("MESSAGE", NO_MESSAGE);
				map.put("STATE", true);
				map.put("DATA", null);
			}
		} catch (Exception e) {
			map.put("MESSAGE", ER_MESSAGE);
			map.put("STATE", false);
			map.put("DATA", null);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	/* ====================== POST DATA TO SERVER ======================= */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> insertUsers(@RequestBody String username) {
		System.out.println("Delete name " + username);
		Map<String, Object> map = new Hashtable<String, Object>();
		try {
			if (user_service.insertUserX(username)) {
				map.put("MESSAGE", OK_MESSAGE + " HAVE INSERT ");
				map.put("STATE", true);
			} else {
				map.put("MESSAGE", NO_MESSAGE + " NOT INSERT ");
				map.put("STATE", true);
			}
		} catch (Exception e) {
			map.put("MESSAGE", ER_MESSAGE);
			map.put("STATE", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	/* ====================== POST DATA TO SERVER ======================= */
	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> updateUsers(@RequestBody User user) {
		System.out.println("Update user : " + user.getId() + " " + user.getUsername());
		Map<String, Object> map = new Hashtable<String, Object>();
		try {
			if (user_service.updateUserX(user)) {
				map.put("MESSAGE", OK_MESSAGE + " HAVE UPDATE ");
				map.put("STATE", true);
			} else {
				map.put("MESSAGE", NO_MESSAGE + " NOT UPDATE ");
				map.put("STATE", true);
			}
		} catch (Exception e) {
			map.put("MESSAGE", ER_MESSAGE);
			map.put("STATE", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	/* ====================== DELETE DATA TO SERVER ======================= */
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Map<String, Object>> deleteUsers(@PathVariable("id") int id) {
		System.out.println("Delete id " + id);
		Map<String, Object> map = new Hashtable<String, Object>();
		try {
			if (user_service.deleteUserX(id)) {
				map.put("MESSAGE", OK_MESSAGE + " DELETE ID " + id);
				map.put("STATE", true);
			} else {
				map.put("MESSAGE", NO_MESSAGE + " DELETE ID " + id);
				map.put("STATE", true);
			}
		} catch (Exception e) {
			map.put("MESSAGE", ER_MESSAGE);
			map.put("STATE", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
}

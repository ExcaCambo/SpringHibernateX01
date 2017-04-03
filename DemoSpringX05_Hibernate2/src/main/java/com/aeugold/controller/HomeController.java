package com.aeugold.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aeugold.enity.FullTimeTeacher;
import com.aeugold.service.TeacherDetailService;

@RestController
@RequestMapping("/api")
public class HomeController {
	
	@Autowired
	private TeacherDetailService teacherService;
	
	/* ====================== GET DATA FROM SERVER ======================= */
	@RequestMapping(value = { "/getTeacher", }, method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> selectUsers() {
		Map<String, Object> map = new Hashtable<String, Object>();
		try {
			ArrayList<FullTimeTeacher> user = teacherService.getFullTimeTeacher();
			if (!user.isEmpty()) {
				map.put("MESSAGE", "GET");
				map.put("STATE", true);
				map.put("DATA", user);
			} else {
				map.put("MESSAGE", "NOT GET");
				map.put("STATE", true);
				map.put("DATA", null);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "ERROR");
			map.put("STATE", false);
			map.put("DATA", null);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

}

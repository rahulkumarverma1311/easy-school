package com.deeRav.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = { "", "/", "home" })
	public String getHome(Model model) {
		return "home.html";
	}

//	@RequestMapping(value = { "", "/courses", "courses" })
//	public String getCourses(Model model) {
//		return "courses.html";
//	}
}
	
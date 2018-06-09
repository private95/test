package com.ly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/")
	private String indexShow() {
		return "index";
	} 
	
	@RequestMapping("{page}")
	private String page(@PathVariable String page) {
		return page;
	}
	
	
}

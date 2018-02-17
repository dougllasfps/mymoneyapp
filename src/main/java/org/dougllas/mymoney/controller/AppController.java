package org.dougllas.mymoney.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class AppController {

//	@GetMapping("/index")
	public String index() {
		return "index";
	}
}

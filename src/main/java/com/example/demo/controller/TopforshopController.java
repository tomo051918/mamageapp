package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopforshopController {
	
	@RequestMapping("/topforshop")
	public String index() {
		/*
		int sum = 0;
		for(int i = 1 ; i <= num ; i++) {
			sum += i;
		}
		model.addAttribute("msg", "sum=" + sum);
		*/
		return "topforshop";
	}

}

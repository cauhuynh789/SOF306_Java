package com.sof306.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/auth/index")
	public String index(Model model){
		return "redirect:/assets/admin/index.html";
	}

	@RequestMapping("/home/index")
	public String index(){
		return "view/index";
	}

}
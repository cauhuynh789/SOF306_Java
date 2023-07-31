package com.sof306.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/auth/index")
	public String index(Model model){

		return "admin/index";
	}

	@RequestMapping("/home/index")
	public String index(){
		return "/index";
	}
}
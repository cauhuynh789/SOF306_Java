package com.sof306.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AccountsController {
	@RequestMapping("/admin/accounts/index")
	public String index(Model m) {
		return "student/index";
	}
}

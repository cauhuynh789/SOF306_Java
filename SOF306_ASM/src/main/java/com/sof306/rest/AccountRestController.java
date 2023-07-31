package com.sof306.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sof306.dao.AccountsDAO;
import com.sof306.entity.Accounts;

@CrossOrigin("*")
@RestController
public class AccountRestController {
	@Autowired
	AccountsDAO dao;
	
	@GetMapping("/rest/accounts")
	public List<Accounts> getAll(Model model) {
		return dao.findAll();
	}
	
	@GetMapping("/rest/accounts/{email}")
	public Accounts getOne(@PathVariable("email") String email) {
		return dao.findById(email).get();
	}
	
	@PostMapping("/rest/accounts")
	public Accounts post(@RequestBody Accounts student) {
		dao.save(student);
		return student;
	}
	
	@PutMapping("/rest/accounts/{email}")
	public Accounts put(@PathVariable("email") String email, @RequestBody Accounts student) {
		dao.save(student);
		return student;
	}
	
	@DeleteMapping("/rest/accounts/{email}")
	public void delete(@PathVariable("email") String email) {
		dao.deleteById(email);
	}
}

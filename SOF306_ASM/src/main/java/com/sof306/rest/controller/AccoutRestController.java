package com.sof306.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sof306.entity.Accounts;
import com.sof306.service.SecurityService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/accounts")
public class AccoutRestController {
	
	@Autowired
	private SecurityService tkService;

	@GetMapping
	public ResponseEntity<List<Accounts>> getAll() {
		return ResponseEntity.ok(tkService.findAll());
	}
	
	@GetMapping("/{accountId}")
	public ResponseEntity<Accounts> getById(@PathVariable("accountId") String username) {
		Accounts account = tkService.findById(username);
		if (account == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(account);
	}
	
	@PostMapping
	public Accounts create(@RequestBody Accounts accounts) {
//		Accounts account = tkService.getById(id);
//		if (account == null) {
//			return ResponseEntity.badRequest().build();
//		}
		return tkService.create(accounts);
	}
	
	@PutMapping("/{accountId}")
	public Accounts update(@PathVariable("accountId") String id, @RequestBody Accounts account) {
		return tkService.create(account);
	}
	
	@DeleteMapping("/{accountId}")
	public void delete(@PathVariable("accountId") String id) {
		tkService.delete(id);
	}
	
}

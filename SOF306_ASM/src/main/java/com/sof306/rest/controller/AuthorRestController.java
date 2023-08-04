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

import com.sof306.entity.Authors;
import com.sof306.service.AuthorService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/authors")
public class AuthorRestController {
	
	@Autowired
	private AuthorService authorService;

	@GetMapping
	public ResponseEntity<List<Authors>> getAll() {
		return ResponseEntity.ok(authorService.findAll());
	}
	
	@GetMapping("/{authorId}")
	public ResponseEntity<Authors> getById(@PathVariable("authorId") String authorId) {
		Authors author = authorService.findById(authorId);
		if (author == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(author);
	}
	
	@PostMapping
	public Authors create(@RequestBody Authors author) {
//		Product product = productService.getById(id);
//		if (product == null) {
//			return ResponseEntity.badRequest().build();
//		}
		return authorService.create(author);
	}
	
	@PutMapping("/{authorId}")
	public Authors update(@PathVariable("authorId") String authorId, @RequestBody Authors author) {
		return authorService.create(author);
	}
	
	@DeleteMapping("/{authorId}")
	public void delete(@PathVariable("authorId") String authorId) {
		authorService.delete(authorId);
	}
	
}

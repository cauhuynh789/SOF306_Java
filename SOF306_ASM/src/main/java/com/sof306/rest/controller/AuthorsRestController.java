package com.sof306.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sof306.dao.AuthorsDAO;
import com.sof306.entity.Authors;

@CrossOrigin("*")
@RestController
public class AuthorsRestController {
	@Autowired
	AuthorsDAO dao;

	@GetMapping("/rest/authors")
	public ResponseEntity<List<Authors>> getAll(Model model) {
		return ResponseEntity.ok(dao.findAll());
	}

	@GetMapping("/rest/authors/{authorId}")
	public ResponseEntity<Authors> getOne(@PathVariable("authorId") String authorId) { // nhận id
		if (!dao.existsById(authorId)) { // kiểm tra trong csdl
			return ResponseEntity.notFound().build();// ko trà về notFound
		}
		return ResponseEntity.ok(dao.findById(authorId).get()); // có trả về cái id
	}

	@PostMapping("/rest/authors") // để trả về ResponseEntity<Category>
	public ResponseEntity<Authors> post(@RequestBody Authors author) {
		if (dao.existsById(author.getAuthorId())) {
			return ResponseEntity.badRequest().build();
		}
		dao.save(author);
		return ResponseEntity.ok(author);
	}

	@PutMapping("/rest/authors/{authorId}")
	public ResponseEntity<Authors> put(@PathVariable("authorId") String authorId, @RequestBody Authors authors) {
		if (!dao.existsById(authorId)) {
			return ResponseEntity.notFound().build();
		}
		dao.save(authors);
		return ResponseEntity.ok(authors);
	}

	@DeleteMapping("/rest/authors/{authorId}")
	public ResponseEntity<Void> delete(@PathVariable("authorId") String authorId) {
		if (!dao.existsById(authorId)) {
			return ResponseEntity.notFound().build();
		}
		dao.deleteById(authorId);
		return ResponseEntity.ok().build();
	}
}

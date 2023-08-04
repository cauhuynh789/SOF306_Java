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

import com.sof306.entity.Books;
import com.sof306.service.BookService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/books")
public class BookRestController {
	
	@Autowired
	private BookService bookService;

	@GetMapping
	public ResponseEntity<List<Books>> getAll() {
		return ResponseEntity.ok(bookService.findAll());
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<Books> getById(@PathVariable("bookId") String bookId) {
		Books book = bookService.findById(bookId);
		if (book == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(book);
	}
	
	@PostMapping
	public Books create(@RequestBody Books book) {
//		Product product = productService.getById(id);
//		if (product == null) {
//			return ResponseEntity.badRequest().build();
//		}
		return bookService.create(book);
	}
	
	@PutMapping("/{bookId}")
	public Books update(@PathVariable("bookId") String bookId, @RequestBody Books book) {
		return bookService.create(book);
	}
	
	@DeleteMapping("/{bookId}")
	public void delete(@PathVariable("bookId") String bookId) {
		bookService.delete(bookId);
	}
	
}

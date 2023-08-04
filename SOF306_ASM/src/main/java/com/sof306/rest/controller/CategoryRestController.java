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
import com.sof306.entity.Categories;
import com.sof306.service.CategoryService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<List<Categories>> getAll() {
		return ResponseEntity.ok(categoryService.findAll());
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<Categories> getById(@PathVariable("categoryId") String categoryId) {
		Categories category = categoryService.findById(categoryId);
		if (category == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(category);
	}
	
	@PostMapping
	public Categories create(@RequestBody Categories category) {
		return categoryService.create(category);
	}
	
	@PutMapping("/{id}")
	public Categories update(@PathVariable("categoryId") String categoryId, @RequestBody Categories category) {
		return categoryService.update(category);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("categoryId") String categoryId) {
		categoryService.delete(categoryId);
	}
	
}

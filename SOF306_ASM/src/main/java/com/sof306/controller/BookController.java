package com.sof306.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sof306.entity.Books;
import com.sof306.entity.Categories;
import com.sof306.service.BookService;
import com.sof306.service.CategoryService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private CategoryService CateService;
	
	@GetMapping("/books/list")
	public String list(Model model) {
		List<Books> books = bookService.findAll();
		model.addAttribute("items", books);
		return "book/list";
	}
	
	@GetMapping("/books/detail/{bookId}")
	public String detail(Model model, @PathVariable("bookId") String bookId) {
		Books book = bookService.findById(bookId);
		List<Categories> category = CateService.findAll();
		
		
		model.addAttribute("listCate", category);
		model.addAttribute("item", book);
		return "book/detail";
	}
}

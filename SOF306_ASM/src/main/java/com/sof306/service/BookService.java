package com.sof306.service;

import java.util.List;

import com.sof306.entity.Books;

public interface BookService {
	
	List<Books> findAll();
	Books findById(String bookId);
	Books create(Books book);
	void delete(String bookId);

}

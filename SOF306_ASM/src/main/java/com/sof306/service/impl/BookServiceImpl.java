package com.sof306.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sof306.dao.BooksDAO;
import com.sof306.entity.Books;
import com.sof306.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BooksDAO booksDAO;

	@Override
	public List<Books> findAll() {
		return booksDAO.findAll();
	}

	@Override
	public Books findById(String bookId) {
		Optional<Books> optional = booksDAO.findById(bookId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public <S extends Books> S save(S entity) {
		return booksDAO.save(entity);
	}

	public boolean existsById(String bookId) {
		return booksDAO.existsById(bookId);
	}

	public void deleteById(String bookId) {
		booksDAO.deleteById(bookId);
	}

	@Override
	public Books create(Books book) {
		return booksDAO.save(book);
	}

	@Override
	public void delete(String bookId) {
		booksDAO.deleteById(bookId);
	}
}

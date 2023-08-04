package com.sof306.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sof306.dao.AuthorsDAO;
import com.sof306.dao.BooksDAO;
import com.sof306.entity.Authors;
import com.sof306.entity.Books;
import com.sof306.service.AuthorService;
import com.sof306.service.BookService;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private AuthorsDAO authorDAO;

	@Override
	public List<Authors> findAll() {
		return authorDAO.findAll();
	}

	@Override
	public Authors findById(String authorId) {
		Optional<Authors> optional = authorDAO.findById(authorId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public <S extends Authors> S save(S entity) {
		return authorDAO.save(entity);
	}

	public boolean existsById(String authorId) {
		return authorDAO.existsById(authorId);
	}

	public void deleteById(String authorId) {
		authorDAO.deleteById(authorId);
	}

	@Override
	public Authors create(Authors author) {
		return authorDAO.save(author);
	}

	@Override
	public void delete(String authorId) {
		authorDAO.deleteById(authorId);
	}
}

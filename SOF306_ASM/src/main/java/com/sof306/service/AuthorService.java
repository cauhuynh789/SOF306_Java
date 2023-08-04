package com.sof306.service;

import java.util.List;

import com.sof306.entity.Authors;

public interface AuthorService {
	
	List<Authors> findAll();
	Authors findById(String authorId);
	Authors create(Authors author);
	void delete(String authorId);

}

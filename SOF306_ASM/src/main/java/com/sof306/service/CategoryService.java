package com.sof306.service;

import java.util.List;

import com.sof306.entity.Books;
import com.sof306.entity.Categories;

public interface CategoryService {
	
	List<Categories> findAll();

	Categories create(Categories category);

	Categories update(Categories category);

	void delete(String categoryId);

	Categories findById(String categoryId);
}

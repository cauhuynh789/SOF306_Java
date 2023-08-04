package com.sof306.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sof306.dao.CategoriesDAO;
import com.sof306.entity.Accounts;
import com.sof306.entity.Categories;
import com.sof306.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoriesDAO cateDAO;

	@Override
	public List<Categories> findAll() {
		return cateDAO.findAll();
	}

	@Override
	public Categories create(Categories category) {
		return cateDAO.save(category);
	}

	@Override
	public Categories update(Categories category) {
		return cateDAO.save(category);
	}

	@Override
	public void delete(String categoryId) {
		cateDAO.deleteById(categoryId);
	}

	@Override
	public Categories findById(String categoryId) {
		Optional<Categories> optional = cateDAO.findById(categoryId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
}

package com.sof306.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sof306.entity.Books;

public interface BooksDAO extends JpaRepository<Books, String>{

}

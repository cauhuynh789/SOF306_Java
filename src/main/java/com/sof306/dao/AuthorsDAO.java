package com.sof306.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sof306.entity.Authors;

public interface AuthorsDAO extends JpaRepository<Authors, String>{

}

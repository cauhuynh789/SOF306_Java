package com.sof306.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sof306.entity.Comments;

public interface CommentsDAO extends JpaRepository<Comments, Integer>{

}

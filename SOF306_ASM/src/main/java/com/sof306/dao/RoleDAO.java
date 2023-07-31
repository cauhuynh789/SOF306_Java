package com.sof306.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sof306.entity.Roles;

public interface RoleDAO extends JpaRepository<Roles, String>{

}

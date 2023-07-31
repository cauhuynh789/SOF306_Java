package com.sof306.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sof306.entity.Accounts;

public interface AccountsDAO extends JpaRepository<Accounts, String>{

}

package com.sof306.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sof306.entity.Accounts;

@Repository
public interface AccountsDAO extends JpaRepository<Accounts, String>{

}

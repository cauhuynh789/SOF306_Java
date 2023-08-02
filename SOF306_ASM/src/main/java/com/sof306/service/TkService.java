package com.sof306.service;

import java.util.List;

import com.sof306.entity.Accounts;

public interface TkService {
	
	List<Accounts> findAll();
	Accounts findById(String username);
	Accounts create(Accounts accounts);
	void delete(String username);
	
}

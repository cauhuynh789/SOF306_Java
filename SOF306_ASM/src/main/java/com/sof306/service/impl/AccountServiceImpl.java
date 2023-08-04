package com.sof306.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sof306.dao.AccountsDAO;
import com.sof306.entity.Accounts;
import com.sof306.service.SecurityService;

@Service
public class AccountServiceImpl implements SecurityService {
	
	@Autowired
	private AccountsDAO accDAO;

	@Override
	public List<Accounts> findAll() {
		return accDAO.findAll();
	}

	@Override
	public Accounts findById(String id) {
		Optional<Accounts> optional = accDAO.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public <S extends Accounts> S save(S entity) {
		return accDAO.save(entity);
	}

	public boolean existsById(String id) {
		return accDAO.existsById(id);
	}

	public void deleteById(String id) {
		accDAO.deleteById(id);
	}

	@Override
	public Accounts create(Accounts Accounts) {
		return accDAO.save(Accounts);
	}

	@Override
	public void delete(String id) {
		accDAO.deleteById(id);
	}	
}

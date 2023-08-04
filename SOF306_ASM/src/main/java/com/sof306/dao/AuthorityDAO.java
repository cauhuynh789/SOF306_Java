package com.sof306.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sof306.entity.Authorities;

public interface AuthorityDAO extends JpaRepository<Authorities, Integer>{

}

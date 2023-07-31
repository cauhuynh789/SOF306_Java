package com.sof306.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sof306.entity.OrderDetails;

public interface OrdersDAO extends JpaRepository<OrderDetails, Integer>{

}

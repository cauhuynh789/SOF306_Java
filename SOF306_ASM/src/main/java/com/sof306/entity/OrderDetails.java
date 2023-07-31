package com.sof306.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Orderdetails")
public class OrderDetails implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "Orderdetailid")
   private int orderDetailId;

   @JsonIgnore
   @ManyToOne
   @JoinColumn(name = "Orderid", referencedColumnName = "Orderid")
   private Orders order;

   @JsonIgnore
   @ManyToOne
   @JoinColumn(name = "Bookid", referencedColumnName = "Bookid")
   private Books book;

   @Column(name = "Quantity")
   private int quantity;

   @Column(name = "Price")
   private BigDecimal price;
}

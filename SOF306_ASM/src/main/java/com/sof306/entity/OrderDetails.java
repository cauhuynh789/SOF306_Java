package com.sof306.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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

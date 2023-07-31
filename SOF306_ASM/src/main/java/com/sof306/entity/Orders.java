package com.sof306.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Orders")
public class Orders implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "Orderid")
   private int orderId;

   @JsonIgnore
   @ManyToOne
   @JoinColumn(name = "Accountid", referencedColumnName = "Accountid")
   private Accounts account;

   @Column(name = "Orderdate")
   private Date orderDate;

   @Column(name = "Totalamount")
   private BigDecimal totalAmount;
   
   @JsonIgnore
   @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
   private List<OrderDetails> orderDetails;
}

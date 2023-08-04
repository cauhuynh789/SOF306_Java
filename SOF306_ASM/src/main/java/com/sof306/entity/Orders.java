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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

   @ManyToOne
   @JoinColumn(name = "Accountid", referencedColumnName = "Accountid")
   private Accounts account;

   @Temporal(TemporalType.DATE)
   @Column(name = "Orderdate")
   private Date orderDate;

   @Column(name = "Totalamount")
   private BigDecimal totalAmount;
   
   @JsonIgnore
   @OneToMany(mappedBy = "order")
   private List<OrderDetails> orderDetails;
}

package com.sof306.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Books")
public class Books implements Serializable{

   @Id
   @Column(name = "Bookid")
   private String bookId;

   @Column(name = "Title")
   private String title;

   @JsonIgnore
   @ManyToOne
   @JoinColumn(name = "Authorid", referencedColumnName = "Authorid")
   private Authors author;

   @JsonIgnore
   @ManyToOne
   @JoinColumn(name = "Publisherid", referencedColumnName = "Publisherid")
   private Publishers publisher;

   @Column(name = "Publishdate")
   private Date publishDate;

   @Column(name = "Description")
   private String description;

   @Column(name = "Price")
   private BigDecimal price;

   @Column(name = "Quantity")
   private int quantity;

   @JsonIgnore
   @ManyToOne
   @JoinColumn(name = "Categoryid", referencedColumnName = "Categoryid")
   private Categories category;

   @Column(name = "Bookphoto")
   private String bookPhoto;

   @Column(name = "Bookstatus")
   private boolean bookStatus;
   
   @JsonIgnore
   @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private List<OrderDetails> orderDetails;

   @JsonIgnore
   @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private List<Comments> comments;
   
   
}
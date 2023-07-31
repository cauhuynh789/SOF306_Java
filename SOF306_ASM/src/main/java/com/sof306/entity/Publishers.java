package com.sof306.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Publishers")
public class Publishers implements Serializable{
	
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "Publisherid")
   private String publisherId;
   
   @Column(name = "Publishername")
   private String publisherName;
   
   @Column(name = "Publisheraddress")
   private String publisherAddress;
   
   @Column(name = "Publisherphone")
   private String publisherPhone;
   
   @Column(name = "Publisherphoto")
   private String publisherPhoto;
   
   @JsonIgnore
   @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   private List<Books> books;
}

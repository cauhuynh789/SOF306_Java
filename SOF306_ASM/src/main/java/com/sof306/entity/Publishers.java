package com.sof306.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Publishers")
public class Publishers implements Serializable{
	
   @Id
   @GeneratedValue
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

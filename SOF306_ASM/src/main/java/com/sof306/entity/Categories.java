package com.sof306.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Categories")
public class Categories implements Serializable {
	  @Id
	   @Column(name = "Categoryid")
	   private String categoryId;

	   @Column(name = "Categoryname")
	   private String categoryName;

	   @Column(name = "Categoryphoto")
	   private String categoryPhoto;
	   
	   @JsonIgnore
	   @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	   private List<Books> books;
}

package com.sof306.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

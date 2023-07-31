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
@Table(name = "Authors")
public class Authors  implements Serializable{

   @Id
   @Column(name = "Authorid")
   private String authorId;

   @Column(name = "Authorname")
   private String authorName;

   @Column(name = "Authorbio")
   private String authorBio;

   @Column(name = "Authorphoto")
   private String authorPhoto;
   
   @JsonIgnore
   @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   private List<Books> books;
}

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

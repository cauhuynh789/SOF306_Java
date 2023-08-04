package com.sof306.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Accounts")
public class Accounts implements Serializable{

	   @Id
	   @Column(name = "Accountid")
	   private String accountId;
	
	   @Column(name = "Password")
	   private String password;
	
	   @Column(name = "Email")
	   private String email;
	
	   @Column(name = "Gender")
	   private boolean gender;
	
	   @Column(name = "Fullname")
	   private String fullName;
	
	   @Column(name = "Address")
	   private String address;
	
	   @Column(name = "Phone")
	   private String phone;
	
	   @Column(name = "Photo")	
	   private String photo;
	
	   @Column(name = "Status")
	   private boolean status;
	   
	   @JsonIgnore
	   @OneToMany(mappedBy = "account")
	   private List<Orders> orders;
	
	   @JsonIgnore
	   @OneToMany(mappedBy = "account")
	   private List<Comments> comments;
	   
	   @JsonIgnore
	   @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	   private List<Authorities> authority;
}

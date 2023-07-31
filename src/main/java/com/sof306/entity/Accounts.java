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
	
	   @Column(name = "Roleid")
	   private boolean roleId;
	
	   @Column(name = "Photo")	
	   private String photo;
	
	   @Column(name = "Status")
	   private boolean status;
	   
	   @JsonIgnore
	   @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	   private List<Orders> orders;
	
	   @JsonIgnore
	   @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	   private List<Comments> comments;
}

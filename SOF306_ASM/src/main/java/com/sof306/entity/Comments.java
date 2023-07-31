package com.sof306.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Comments")
public class Comments implements Serializable {
	   @Id
	   @Column(name = "Commentid")
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private int commentId;
	
	   @JsonIgnore
	   @ManyToOne
	   @JoinColumn(name = "Accountid", referencedColumnName = "Accountid")
	   private Accounts account;
	
	   @JsonIgnore
	   @ManyToOne
	   @JoinColumn(name = "Bookid", referencedColumnName = "Bookid")
	   private Books book;
	
	   @Column(name = "Commenttext")
	   private String commentText;
	
	   @Column(name = "Commentdate")
	   private Date commentDate;
	
	   @Column(name = "Commentstatus")
	   private boolean commentStatus;
}

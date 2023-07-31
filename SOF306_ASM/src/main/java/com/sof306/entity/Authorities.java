package com.sof306.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Authority", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"Accountid", "Roleid"})
})
public class Authorities implements Serializable{
	@Id 
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnore
	@ManyToOne 
	@JoinColumn(name = "Accountid", referencedColumnName = "Accountid")
	private Accounts account;
	
	@ManyToOne  
	@JoinColumn(name = "Roleid", referencedColumnName = "Roleid")
	private Roles role;
}

package com.sof306.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "roles")
public class Roles implements Serializable{
	@Id
	@Column(name = "Id")
	private String id;
	
	@Column(name = "Name")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Authorities> Authority;
	
}

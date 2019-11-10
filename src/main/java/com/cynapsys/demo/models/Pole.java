package com.cynapsys.demo.models;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity(name = "Service")
@Table(name = "Service")
public class Pole {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int id;
	
	@Column
	private String nomService;
	
	@Column
	private Boolean etat;
	
	public Pole(int id, String nomService, Boolean etat) {
		this.id = id;
		this.nomService = nomService;
		this.etat = etat;
	}
	
	//@OneToMany(mappedBy = "pole")
	  //  private List<User> users;


	public Pole() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNomService() {
		return nomService;
	}


	public void setNomService(String nomService) {
		this.nomService = nomService;
	}

	public Boolean getEtat() {
		return etat;
	}


	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

/*
	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}
	*/
		
}
	
	

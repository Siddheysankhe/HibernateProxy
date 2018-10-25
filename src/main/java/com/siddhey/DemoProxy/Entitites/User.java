package com.siddhey.DemoProxy.Entitites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	  public User() {
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", role=" + role + "]";
	}

	@Id
	  @GeneratedValue
	  private Long id;

	  private String name;

	  private String role;

	  public User(final String name, final String role) {
	    this.name = name;
	    this.role = role;
	  }

	  public Long getId() {
			return id;
		}

	  public String getName() {
	    return name;
	  }

	  public String getRole() {
	    return role;
	  }
	  
	  public void setId(Long id) {
			this.id = id;
		}
	  

	  public void setName(final String name) {
	    this.name = name;
	  }

	  public void setRole(final String role) {
	    this.role = role;
	  }

	}
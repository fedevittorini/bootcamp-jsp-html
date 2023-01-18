package com.eduit.bootcamp.jdbc.entity;

import java.io.Serializable;
import java.util.Date;

public class Usuarios implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String TABLE_NAME = "usuarios";
	
	public static String ID_FIELD = "id";
	public static String USERNAME_FIELD = "username";
	public static String FIRST_NAME_FIELD = "first_name";
	public static String LAST_NAME_FIELD = "last_name";
	public static String PASSWORD_FIELD = "password";
	public static String DATE_CREATED_FIELD = "date_created";
	public static String DATE_DELETED_FIELD = "date_deteled";
	
	private Long id;
	private String username;
    private String firstName;
    private String lastName;
    private String password;
    private Date dateCreated;
    private Date dateDeleted;
    
    public Usuarios() {
    	
    }
    
	public Usuarios(final Long theId, final String theUsername, final String theFirstName,
			final String theLastName, final String thePassword, final Date theDateCreated, 
			final Date theDateDeleted) {
		this.id = theId;
		this.username = theUsername;
		this.firstName = theFirstName;
		this.lastName = theLastName;
		this.password = thePassword;
		this.dateCreated = theDateCreated;
		this.dateDeleted = theDateDeleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateDeleted() {
		return dateDeleted;
	}

	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", dateCreated=" + dateCreated + ", dateDeleted=" + dateDeleted + "]";
	}

	
}

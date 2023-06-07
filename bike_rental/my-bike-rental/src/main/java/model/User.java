package model;

import java.sql.Date;
public class User {
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private Date dateRegistered;

	public User(String firstName, String lastName, String email, Date dateRegistered) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateRegistered = dateRegistered;
	}

	public User(int userId, String firstName, String lastName, String email, Date dateRegistered) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateRegistered = dateRegistered;
	}

	public User() {

	}

	public int getUserId() {
		return userId;
	}

	public void setUserID(int userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateRegistered() {
		return dateRegistered;
	}

	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}
}

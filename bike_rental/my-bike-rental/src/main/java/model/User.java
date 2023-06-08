package model;

import java.sql.Date;
import java.util.List;

public class User {
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private Date dateRegistered;
	private List<BikeRental> bikeRentals;
	private List<PassBikeRental> passBikeRentals;
	private List<Event> organizedEvents;
	private List<RentalTransaction> rentalTransactions;
	private List<PassTransaction> passTransactions;


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

	@Override
	public String toString() {
		return String.format("\nUser ID: %d" +
						"\nFirst Name %s" +
						"\nLast name: %s" +
						"\nEmail: %s" +
						"\nDate registered: %s",
				getUserId(), getFirstName(), getLastName(), getEmail(), getDateRegistered());
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

	public List<BikeRental> getBikeRentals() {
		return bikeRentals;
	}

	public void setBikeRentals(List<BikeRental> bikeRentals) {
		this.bikeRentals = bikeRentals;
	}

	public List<PassBikeRental> getPassBikeRentals() {
		return passBikeRentals;
	}

	public void setPassBikeRentals(List<PassBikeRental> passBikeRentals) {
		this.passBikeRentals = passBikeRentals;
	}

	public List<Event> getOrganizedEvents() {
		return organizedEvents;
	}

	public void setOrganizedEvents(List<Event> organizedEvents) {
		this.organizedEvents = organizedEvents;
	}
	public List<RentalTransaction> getRentalTransactions() {
		return rentalTransactions;
	}

	public void setRentalTransactions(List<RentalTransaction> rentalTransactions) {
		this.rentalTransactions = rentalTransactions;
	}

	public List<PassTransaction> getPassTransactions() {
		return passTransactions;
	}

	public void setPassTransactions(List<PassTransaction> passTransactions) {
		this.passTransactions = passTransactions;
	}
}

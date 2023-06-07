package entityLayer;

public class Technician {
	private int technicianId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;

	// Constructors
	public Technician() {
	}

	public Technician(int technicianId, String firstName, String lastName, String phoneNumber, String email) {
		this.technicianId = technicianId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Technician(String firstName, String lastName, String phoneNumber, String email) {
		this.technicianId = technicianId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	// Getters and Setters
	public int getTechnicianId() {
		return technicianId;
	}

	public void setTechnicianId(int technicianId) {
		this.technicianId = technicianId;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

public void setEmail(String email) {
		this.email = email;
	}
}
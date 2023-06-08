package model;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "technician")
@XmlAccessorType(XmlAccessType.FIELD)
public class Technician {
	@XmlElement(name = "technicianId")
	private int technicianId;
	@XmlElement(name = "firstName")
	private String firstName;
	@XmlElement(name = "lastName")
	private String lastName;
	@XmlElement(name = "phoneNumber")
	private String phoneNumber;

	@XmlElement(name = "email")
	private String email;
	@XmlElementWrapper(name = "maintenanceList")
	@XmlElement(name = "maintenance")
	private List<Maintenance> maintenanceList;

	// Constructors

	public Technician() {
	}
	public Technician(int technicianId, String firstName, String lastName, String phoneNumber,
	                  String email) {
		this.technicianId = technicianId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.maintenanceList = new ArrayList<>();
	}

	public Technician(String firstName, String lastName, String phoneNumber, String email) {
		this.technicianId = technicianId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.maintenanceList = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Technician{" + "technicianId=" + technicianId + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", phoneNumber='" + phoneNumber + '\'' + ", email='" + email + '\'' + ", maintenanceList=" + maintenanceList + '}';
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

	public List<Maintenance> getMaintenanceList() {
		return maintenanceList;
	}

	public void setMaintenanceList(List<Maintenance> maintenanceList) {
		this.maintenanceList = maintenanceList;
	}
}

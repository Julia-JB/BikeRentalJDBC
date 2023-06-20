package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Maintenance {
	@JsonProperty("maintenanceId")
	private int maintenanceId;

	@JsonProperty("dateStart")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America" +
			"/Los_Angeles")
	private Date dateStart;

	@JsonProperty("dateEnd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America" +
			"/Los_Angeles")
	private Date dateEnd;

	@JsonProperty("description")
	private String description;

	@JsonProperty("bikeId")
	private int bikeId;

	@JsonProperty("technicianId")
	private int technicianId;

	public Maintenance() {
	}

	public Maintenance(Date dateStart, Date dateEnd, String description, int bikeId, int technicianId) {
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.description = description;
		this.bikeId = bikeId;
		this.technicianId = technicianId;
	}

	public Maintenance(int maintenanceId, Date dateStart, Date dateEnd, String description, int bikeId, int technicianId) {
		this.maintenanceId = maintenanceId;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.description = description;
		this.bikeId = bikeId;
		this.technicianId = technicianId;

	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDateEnd = (dateEnd != null) ? dateFormat.format(dateEnd) : "N/A";
		return "Maintenance{" +
				"maintenanceId=" + maintenanceId +
				", dateStart=" + dateFormat.format(dateStart) +
				", dateEnd=" + formattedDateEnd +
				", description='" + description + '\'' +
				", bikeId=" + bikeId +
				", technicianId=" + technicianId +
				'}';
	}

	public int getMaintenanceId() {
		return maintenanceId;
	}

	public void setMaintenanceId(int maintenanceId) {
		this.maintenanceId = maintenanceId;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getBikeId() {
		return bikeId;
	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}

	public int getTechnicianId() {
		return technicianId;
	}

	public void setTechnicianId(int technicianId) {
		this.technicianId = technicianId;
	}
}

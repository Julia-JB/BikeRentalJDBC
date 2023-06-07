package entityLayer;

import java.util.Date;

public class Maintenance {
	private int maintenanceId;
	private Date dateStart;
	private Date dateEnd;
	private String description;
	private int bikeId;
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

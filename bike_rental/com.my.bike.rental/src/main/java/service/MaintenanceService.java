package service;

import dao.MaintenanceDAO;
import model.Maintenance;

import java.util.List;

public class MaintenanceService {
	private MaintenanceDAO maintenanceDAO;

	public MaintenanceService() {
		maintenanceDAO = new MaintenanceDAO();
	}

	public void insertMaintenance(Maintenance maintenance) {
		maintenanceDAO.save(maintenance);
	}

	public Maintenance selectMaintenance(int maintenanceId) {
		return maintenanceDAO.getById(maintenanceId);
	}

	public List<Maintenance> selectAllMaintenance() {
		return maintenanceDAO.getAll();
	}

	public void updateMaintenance(Maintenance maintenance) {
		maintenanceDAO.update(maintenance);
	}

	public void deleteMaintenance(int maintenanceId) {
		maintenanceDAO.delete(maintenanceId);
	}
}

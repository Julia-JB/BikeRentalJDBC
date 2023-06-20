package mapper;

import model.Maintenance;
import model.User;

import java.util.List;

public interface MaintenanceMapper {
	void addMaintenance(Maintenance maintenance);
	Maintenance selectMaintenanceById(int id);
	List<Maintenance> selectAllMaintenances();
	void updateMaintenance(Maintenance maintenance);
	void deleteMaintenance(int id);
}

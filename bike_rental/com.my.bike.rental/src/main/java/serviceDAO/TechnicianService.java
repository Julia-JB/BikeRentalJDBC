package serviceDAO;

import dao.TechnicianDAO;
import designPatterns.serviceInterface.ITechnicianService;
import model.Technician;

import java.util.List;

public class TechnicianService implements ITechnicianService {
	private TechnicianDAO technicianDAO;

	public TechnicianService() {
		technicianDAO = new TechnicianDAO();
	}

	public void insertTechnician(Technician technician) {
		technicianDAO.save(technician);
	}

	public Technician selectTechnician(int technicianId) {
		return technicianDAO.getById(technicianId);
	}

	public List<Technician> selectAllTechnicians() {
		return technicianDAO.getAll();
	}

	public void updateTechnician(Technician technician) {
		technicianDAO.update(technician);
	}

	public void deleteTechnician(int technicianId) {
		technicianDAO.delete(technicianId);
	}
}

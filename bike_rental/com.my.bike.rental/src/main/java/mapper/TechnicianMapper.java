package mapper;

import model.Technician;

import java.util.List;

public interface TechnicianMapper {

	void addTechnician(Technician technician);

	Technician selectTechnicianById(int id);

	List<Technician> selectAllTechnicians();

	void updateTechnician(Technician technician);

	void deleteTechnician(int id);
}

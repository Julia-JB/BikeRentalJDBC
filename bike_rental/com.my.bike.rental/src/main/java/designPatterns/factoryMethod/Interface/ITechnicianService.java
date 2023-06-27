package designPatterns.factoryMethod.Interface;

import model.Bike;
import model.Technician;

import java.util.List;

public interface ITechnicianService {
	public void insertTechnician(Technician technician);

	public Technician selectTechnician(int technicianId);

	public List<Technician> selectAllTechnicians();

	public void updateTechnician(Technician technician);

	public void deleteTechnician(int technicianId);
}

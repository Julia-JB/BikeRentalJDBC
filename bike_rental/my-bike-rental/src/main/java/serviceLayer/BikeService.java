package serviceLayer;

import daoLayer.BikeDAO;
import entityLayer.Bike;

import java.util.List;

public class BikeService {
	private BikeDAO bikeDAO;

	public BikeService() {
		bikeDAO = new BikeDAO();
	}

	public void insertBike(Bike bike) {
		bikeDAO.save(bike);
	}

	public Bike selectBike(int bikeId) {
		return bikeDAO.getById(bikeId);
	}

	public List<Bike> selectAllBikes() {
		return bikeDAO.getAll();
	}

	public void updateBike(Bike bike) {
		bikeDAO.update(bike);
	}

	public void deleteBike(int bikeId) {
		bikeDAO.delete(bikeId);
	}
}

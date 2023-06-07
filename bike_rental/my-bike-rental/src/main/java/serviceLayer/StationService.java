package serviceLayer;

import daoLayer.StationDAO;
import entityLayer.Station;

import java.util.List;

public class StationService {
	private StationDAO stationDAO;
	public StationService() {
		stationDAO = new StationDAO();
	}

	public void insertStation(Station station) {
		stationDAO.save(station);
	}

	public Station selectStation(int stationId) {
		return stationDAO.getById(stationId);
	}

	public List<Station> selectAllStations() {
		return stationDAO.getAll();
	}

	public void updateStation(Station station) {
		stationDAO.update(station);
	}

	public void deleteStation(int stationId) {
		stationDAO.delete(stationId);
	}
}


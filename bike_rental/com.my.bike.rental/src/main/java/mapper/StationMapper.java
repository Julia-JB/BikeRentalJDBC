package mapper;

import model.Station;

import java.util.List;

public interface StationMapper {
	void addStation(Station station);

	Station selectStationById(int id);

	List<Station> selectAllStations();
	void updateStation(Station station);

	void deleteStation(int id);
}

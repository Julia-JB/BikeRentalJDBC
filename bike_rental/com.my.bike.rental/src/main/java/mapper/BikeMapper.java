package mapper;
import model.Bike;

import java.util.List;

public interface BikeMapper {
	void addBike(Bike bike);
	Bike selectBikeById(int id);
	List<Bike> selectAllBikes();
	void updateBike(Bike bike);
	void deleteBike(int id);
}

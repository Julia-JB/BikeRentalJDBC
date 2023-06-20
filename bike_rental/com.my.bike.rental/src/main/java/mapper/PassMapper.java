package mapper;

import model.Pass;

import java.util.List;

public interface PassMapper {
	void addPass(Pass pass);

	Pass selectPassById(int id);

	List<Pass> selectAllPasses();

	void updatePass(Pass pass);

	void deletePass(int id);
}

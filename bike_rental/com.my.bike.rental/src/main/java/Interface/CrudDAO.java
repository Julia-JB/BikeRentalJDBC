package Interface;

import java.util.List;

public interface CrudDAO <T, I> {
	void save(T t);
	T getById(I id);
	List<T> getAll();
	void update(T t);
	void delete(I id);
}

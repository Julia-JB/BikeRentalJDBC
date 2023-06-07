package utilities;

import java.awt.geom.Point2D;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatementUtility {

	public static void setObjectParameters(PreparedStatement statement, Object object) throws SQLException,
			IllegalAccessException {
			Field[] fields = object.getClass().getDeclaredFields();
		for (int i = 1; i < fields.length; i++) {
			fields[i].setAccessible(true);
			Object value = fields[i].get(object);
			statement.setObject(i, value);
		}
	}

	public static <T> T mapResultSetToObject(ResultSet resultSet, Class<T> targetClass) throws SQLException, IllegalAccessException, InstantiationException {
		T object = targetClass.newInstance();
		if (resultSet.next()) {
			Field[] fields = targetClass.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				Object value = resultSet.getObject(fields[i].getName());
				fields[i].set(object, value);
			}
		}
		return object;
	}

	public static <T> List<T> mapResultSetToObjectList(ResultSet resultSet, Class<T> targetClass) throws SQLException, IllegalAccessException, InstantiationException {
		List<T> objects = new ArrayList<>();
		Field[] fields = targetClass.getDeclaredFields();

		while (resultSet.next()) {
			T object = targetClass.newInstance();

			for (Field field : fields) {
				field.setAccessible(true);
				Object value = resultSet.getObject(field.getName());
				field.set(object, value);
			}

			objects.add(object);
		}

		return objects;
	}

	public static int setObjectFieldsForUpdate(PreparedStatement statement, Object object) throws IllegalAccessException, SQLException {
		Field[] fields = object.getClass().getDeclaredFields();
		int parameterIndex = 1;

		for (int i = 1; i < fields.length; i++) {
			Field field = fields[i];
			field.setAccessible(true);
			Object value = field.get(object);
			statement.setObject(parameterIndex, value);
			parameterIndex++;
		}
		return parameterIndex;
	}

	public static Point2D parseLocationText(String locationStr) {
		// Remove the "POINT(" prefix and ")" suffix from the location string
		String pointText = locationStr.replace("POINT(", "").replace(")", "");

		// Split the point text into X and Y coordinates
		String[] coordinates = pointText.split(" ");

		// Extract the X and Y coordinates
		double x = Double.parseDouble(coordinates[0]);
		double y = Double.parseDouble(coordinates[1]);

		return new Point2D.Double(x, y);
	}
}

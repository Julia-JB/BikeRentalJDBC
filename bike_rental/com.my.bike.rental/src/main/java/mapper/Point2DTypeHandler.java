package mapper;

import dao.daoUtilities.DaoUtility;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.awt.geom.Point2D;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Point2DTypeHandler extends BaseTypeHandler<Point2D> {

	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int i, Point2D point2D, JdbcType jdbcType) throws SQLException {
		// Convert the Point2D object to the appropriate database representation and set it as the parameter value
		preparedStatement.setString(i, convertToDatabaseFormat(point2D));
	}

	@Override
	public Point2D getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
		String locationStr = resultSet.getString("location");
		return DaoUtility.parseLocationText(locationStr);
	}

	@Override
	public Point2D getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
		String locationStr = resultSet.getString(columnIndex);
		return DaoUtility.parseLocationText(locationStr);
	}

	@Override
	public Point2D getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
		String locationStr = callableStatement.getString(columnIndex);
		return DaoUtility.parseLocationText(locationStr);
	}

	private String convertToDatabaseFormat(Point2D point2D) {
		// Convert the Point2D object to a database-specific format (e.g., "POINT(x y)")
		return "POINT(" + point2D.getX() + " " + point2D.getY() + ")";
	}
}


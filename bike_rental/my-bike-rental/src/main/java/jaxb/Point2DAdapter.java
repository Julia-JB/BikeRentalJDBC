package jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.awt.geom.Point2D;

public class Point2DAdapter extends XmlAdapter<String, Point2D>{

	@Override
	public Point2D unmarshal(String s) throws Exception {
		String[] coordinates = s.split(",");
		double x = Double.parseDouble(coordinates[0]);
		double y = Double.parseDouble(coordinates[1]);
		return new Point2D.Double(x, y);
	}

	@Override
	public String marshal(Point2D point) throws Exception {
		return point.getX() + "," + point.getY();
	}
}

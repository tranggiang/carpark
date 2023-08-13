package com.wego.test.carpark.util;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

public class GeometryUtil {

    public static final int SRID = 4326; // LatLng
    private static WKTReader wktReader = new WKTReader();

    private static Geometry wktToGeometry(String wellKnownText) {
        Geometry geometry = null;

        try {
            geometry = wktReader.read(wellKnownText);
        } catch (ParseException e) {
            // TODO add log
            e.printStackTrace();
        }
        return geometry;
    }

    public static Point parseLocation(double x, double y) {
        Geometry geometry = GeometryUtil.wktToGeometry(String.format("POINT (%s %s)", x, y));
        Point p = (Point) geometry;
        p.setSRID(4326);
        return p;
    }
}

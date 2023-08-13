package com.wego.test.carpark.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.locationtech.jts.geom.Point;

public interface CarParkReport {

    String getCarParkNumber();

    String getAddress();

    @JsonIgnore
    Point getPoint();

    Integer getTotal_lots();

    Double getKm();

    Integer getAvailable_lots();

}

package com.wego.test.carpark.service;

import com.wego.test.carpark.model.CarParkReport;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarParkService {

    List<CarParkReport> findNearestParking(double latitude, double longitude, Pageable pageable);

}

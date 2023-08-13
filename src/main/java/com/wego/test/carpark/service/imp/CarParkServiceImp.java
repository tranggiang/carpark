package com.wego.test.carpark.service.imp;

import com.wego.test.carpark.model.CarParkReport;
import com.wego.test.carpark.repo.CarParkRepo;
import com.wego.test.carpark.service.CarParkService;
import com.wego.test.carpark.util.GeometryUtil;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarParkServiceImp implements CarParkService {

    @Autowired
    private CarParkRepo carParkRepo;


    @Override
    public List<CarParkReport> findNearestParking(double latitude, double longitude, Pageable pageable) {
        Point point = GeometryUtil.parseLocation(latitude, longitude);
        return carParkRepo.findNearestParking(point.toString(), pageable);
    }

}

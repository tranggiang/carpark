package com.wego.test.carpark.controller;

import com.wego.test.carpark.model.CarParkReport;
import com.wego.test.carpark.service.CarParkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carkpark")
public class CarParkController {

    private Logger logger = LoggerFactory.getLogger(CarParkController.class);
    @Autowired
    private CarParkService carParkService;

    @GetMapping("/nearest")
    public ResponseEntity<List<CarParkReport>> getNearestParking(
            @RequestParam(required = true) Double latitude,
            @RequestParam(required = true) Double longitude,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int per_page

    ) {
        if (latitude == null || longitude == null || page < 0 || per_page < 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        logger.info("Find closest  parking location from latitude: {}, longitude: {}", latitude, longitude);
        Pageable paging = PageRequest.of(page, per_page);

        List<CarParkReport> nearestParking = carParkService.findNearestParking(longitude, latitude, paging);
        return ResponseEntity.of(Optional.of(nearestParking));
    }
}

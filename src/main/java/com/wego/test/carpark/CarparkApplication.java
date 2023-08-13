package com.wego.test.carpark;

import com.wego.test.carpark.model.CarPark;
import com.wego.test.carpark.model.CarparkInfo;
import com.wego.test.carpark.repo.CarParkInfoRepo;
import com.wego.test.carpark.repo.CarParkRepo;
import com.wego.test.carpark.service.imp.CarParkAvailability;
import com.wego.test.carpark.service.imp.CarParkLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootApplication
public class CarparkApplication {

    @Autowired
    private CarParkRepo carParkRepo;
    @Autowired
    private CarParkInfoRepo carParkInfoRepo;
    private Logger logger = LoggerFactory.getLogger(CarparkApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CarparkApplication.class, args);
    }

    @Bean
    InitializingBean InitializeDatabase() throws FileNotFoundException {
        logger.debug("Initialize database");

        return () -> {
            List<CarPark> savedCarPark = carParkRepo.saveAll(CarParkLoader.loadCarPark());

            Map<String, CarPark> carParkMap = savedCarPark.stream().collect(Collectors.toMap(CarPark::getCarParkNumber, Function.identity()));

            List<CarparkInfo> parkingAvailability = CarParkAvailability.getParkingAvailability();

            parkingAvailability.forEach(p -> p.setCarPark(carParkMap.get(p.getCarParkNumber())));

            carParkInfoRepo.saveAll(parkingAvailability);
        };
    }

}

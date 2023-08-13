package com.wego.test.carpark.repo;

import com.wego.test.carpark.model.CarPark;
import com.wego.test.carpark.model.CarParkReport;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarParkRepo extends JpaRepository<CarPark, String> {

    @Query(value = " SELECT  cp.address as address , cp.car_park_number as carParkNumber,cp.point as point,SUM(ci.total_lots) as total_lots,SUM(ci.lots_available) as available_lots ," +
            " ST_DISTANCE(point,ST_GEOMFROMTEXT(:pointParam, 4326)) / 1000 AS km  FROM car_park cp " +
            "JOIN  carpark_info  ci " +
            "WHERE cp.car_park_number = ci.car_park_id GROUP BY ci.car_park_id  ORDER BY km  ",
            countQuery = "SELECT count(cp.car_park_number),ST_DISTANCE(point,ST_GEOMFROMTEXT(:pointParam, 4326)) / 1000 as km FROM car_park cp, carpark_info ci  " +
                    " WHERE cp.car_park_number = ci.car_park_number GROUP BY cp.car_park_number " +
                    " ORDER BY km HAVING  lots_available > 0", nativeQuery = true)
    List<CarParkReport> findNearestParking(@Param("pointParam") String p, Pageable pageable);


}

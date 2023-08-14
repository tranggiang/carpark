package com.wego.test.carpark.repo;

import com.wego.test.carpark.model.CarPark;
import com.wego.test.carpark.model.CarParkReport;
import com.wego.test.carpark.util.GeometryUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest()
public class CarParkRepoTest {
    @Autowired
    private CarParkRepo carParkRepo;

    @Test
    public void saveCarParkRepoSucceed() {
        List<CarPark> carParkList = carParkRepo.findAll();
        assertThat(carParkList.size()).isEqualTo(2200);
    }

    @Disabled("ST_DISTANCE is not supported by H2 DB")
    @Test
    public void findNearestParkingSucceed() {
        Point point = GeometryUtil.parseLocation(1.37326, 103.897);
        Pageable paging = PageRequest.of(1, 10);
        List<CarParkReport> nearestParking = carParkRepo.findNearestParking(point.toString(), paging);
        assertThat(nearestParking.size()).isEqualTo(10);
    }
}

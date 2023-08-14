package com.wego.test.carpark.repo;

import com.wego.test.carpark.model.CarparkInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest()
public class CarParkInfoRepoTest {
    @Autowired
    private CarParkInfoRepo carParkInfoRepo;

    @Test
    public void saveCarParkRepoSucceed() {
        Pageable pagable = PageRequest.of(1, 10);
        Page<CarparkInfo> carparkInfos = carParkInfoRepo.findAll(pagable);
        assertThat(carparkInfos.getContent().size()).isEqualTo(10);

    }
}

package com.wego.test.carpark.repo;

import com.wego.test.carpark.model.CarParkInfoId;
import com.wego.test.carpark.model.CarparkInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarParkInfoRepo extends JpaRepository<CarparkInfo, CarParkInfoId> {
}

package com.wego.test.carpark.model;

import java.io.Serializable;

public class CarParkInfoId implements Serializable {
    private String carParkNumber;
    private String lotType;

    public String getLotType() {
        return lotType;
    }

    public void setLotType(String lotType) {
        this.lotType = lotType;
    }

    public String getCarParkNumber() {
        return carParkNumber;
    }

    public void setCarParkNumber(String carParkNumber) {
        this.carParkNumber = carParkNumber;
    }
}

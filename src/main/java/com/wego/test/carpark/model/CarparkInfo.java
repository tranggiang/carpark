package com.wego.test.carpark.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@IdClass(CarParkInfoId.class)
public class CarparkInfo {
    @Id
    private String carParkNumber;
    @Id
    @JsonProperty("lot_type")
    private String lotType;
    @ManyToOne
    @JoinColumn(name = "car_park_id")
    private CarPark carPark;
    @JsonProperty("total_lots")
    private int totalLots;
    @JsonProperty("lots_available")
    private int lotsAvailable;

    private Date updateDateTime;

    public CarPark getCarPark() {
        return carPark;
    }

    public void setCarPark(CarPark carPark) {
        this.carPark = carPark;
    }

    public int getTotalLots() {
        return this.totalLots;
    }

    public void setTotalLots(int totalLots) {
        this.totalLots = totalLots;
    }


    public String getLotType() {
        return this.lotType;
    }

    public void setLotType(String lotType) {
        this.lotType = lotType;
    }


    public int getLotsAvailable() {
        return this.lotsAvailable;
    }

    public void setLotsAvailable(int lotsAvailable) {
        this.lotsAvailable = lotsAvailable;
    }

    public String getCarParkNumber() {
        return carParkNumber;
    }

    public void setCarParkNumber(String carParkNumber) {
        this.carParkNumber = carParkNumber;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    @Override
    public String toString() {
        return "CarparkInfo{" +
                "carParkNumber='" + carParkNumber + '\'' +
                ", lotType='" + lotType + '\'' +
                ", totalLots='" + totalLots + '\'' +
                ", lotsAvailable='" + lotsAvailable + '\'' +
                '}';
    }
}


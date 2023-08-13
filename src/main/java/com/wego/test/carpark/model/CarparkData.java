package com.wego.test.carpark.model;

import java.util.ArrayList;
import java.util.Date;

public class CarparkData {
    public ArrayList<CarparkInfo> getCarpark_info() {
        return this.carpark_info;
    }

    public void setCarpark_info(ArrayList<CarparkInfo> carpark_info) {
        this.carpark_info = carpark_info;

    }

    private ArrayList<CarparkInfo> carpark_info;

    public String getCarpark_number() {
        return this.carpark_number;
    }

    public void setCarpark_number(String carpark_number) {
        this.carpark_number = carpark_number;
        carpark_info.forEach(c -> c.setCarParkNumber(this.carpark_number));

    }

    private String carpark_number;

    public Date getUpdate_datetime() {
        return this.update_datetime;
    }

    public void setUpdate_datetime(Date update_datetime) {
        this.update_datetime = update_datetime;
        carpark_info.forEach(c -> c.setUpdateDateTime(this.update_datetime));
    }

    private Date update_datetime;

}

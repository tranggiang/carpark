package com.wego.test.carpark.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Item {
    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    private Date timestamp;

    public List<CarparkData> getCarpark_data() {
        return this.carpark_data;
    }

    public void setCarpark_data(ArrayList<CarparkData> carpark_data) {
        this.carpark_data = carpark_data;
    }

    private List<CarparkData> carpark_data;
}

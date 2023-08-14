package com.wego.test.carpark.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wego.test.carpark.util.GeometryUtil;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CarPark {
    @Id
    private String carParkNumber;
    private String address;
    @Transient
    private double latitude;
    @Transient
    private double longitude;
    @JsonIgnore
    @Column(columnDefinition = "GEOMETRY")
    private Point point;

    private String carParkType;
    private String parkingSystem;
    private String shortTermParking;
    private String freeParking;
    private String nightParking;
    private int carParkDeck;
    private double gantryHeight;
    private boolean parkBaseMent;

    @OneToMany(mappedBy = "carPark")
    private Set<CarparkInfo> carkCarparkInfos;

    public Set<CarparkInfo> getCarkCarparkInfos() {
        return carkCarparkInfos;
    }

    public void setCarkCarparkInfos(Set<CarparkInfo> carkCarparkInfos) {
        this.carkCarparkInfos = carkCarparkInfos;
    }

    public CarPark() {
    }

    public CarPark(String carParkNumber, String address, double latitude, double longitude, String carParkType, String parkingSystem,
                   String shortTermParking, String freeParking, String nightParking, int carParkDeck, double gantryHeight,
                   boolean parkBaseMent) {
        super();
        this.carParkNumber = carParkNumber;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.carParkType = carParkType;
        this.parkingSystem = parkingSystem;
        this.shortTermParking = shortTermParking;
        this.freeParking = freeParking;
        this.nightParking = nightParking;
        this.carParkDeck = carParkDeck;
        this.gantryHeight = gantryHeight;
        this.parkBaseMent = parkBaseMent;
        point = GeometryUtil.parseLocation(latitude, longitude);
    }

    public String getCarParkNumber() {
        return carParkNumber;
    }

    public void setCarParkNumber(String carParkNumber) {
        this.carParkNumber = carParkNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String getCarParkType() {
        return carParkType;
    }

    public void setCarParkType(String carParkType) {
        this.carParkType = carParkType;
    }

    public String getParkingSystem() {
        return parkingSystem;
    }

    public void setParkingSystem(String parkingSystem) {
        this.parkingSystem = parkingSystem;
    }

    public String getShortTermParking() {
        return shortTermParking;
    }

    public void setShortTermParking(String shortTermParking) {
        this.shortTermParking = shortTermParking;
    }

    public String getFreeParking() {
        return freeParking;
    }

    public void setFreeParking(String freeParking) {
        this.freeParking = freeParking;
    }

    public String getNightParking() {
        return nightParking;
    }

    public void setNightParking(String nightParking) {
        this.nightParking = nightParking;
    }

    public int getCarParkDeck() {
        return carParkDeck;
    }

    public void setCarParkDeck(int carParkDeck) {
        this.carParkDeck = carParkDeck;
    }

    public double getGantryHeight() {
        return gantryHeight;
    }

    public void setGantryHeight(double gantryHeight) {
        this.gantryHeight = gantryHeight;
    }

    public boolean isParkBaseMent() {
        return parkBaseMent;
    }

    public void setParkBaseMent(boolean parkBaseMent) {
        this.parkBaseMent = parkBaseMent;
    }

    @Override
    public String toString() {
        return "CarPark [id=" + carParkNumber + ", address=" + address + ", xCoord=" + latitude + ", yCoord=" + longitude + ", point="
                + point + ", carParkType=" + carParkType + ", parkingSystem=" + parkingSystem + ", shortTermParking="
                + shortTermParking + ", freeParking=" + freeParking + ", nightParking=" + nightParking
                + ", carParkDeck=" + carParkDeck + ", gantryHeight=" + gantryHeight + ", parkBaseMent=" + parkBaseMent
                + "]";
    }

}

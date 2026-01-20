package com.devmart.mallaxisservice;

import jakarta.persistence.*;

@Entity
@Table(name = "mall_unit")
public class MallUnitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer unitId;

    private String unitName;       // Shop / Facility name
    private String unitType;       // SHOP, FOODCOURT, CINEMA
    private Integer floorNumber;
    private String status;         // ACTIVE, INACTIVE
    private Double rentAmount;

    public MallUnitEntity() {}

    public MallUnitEntity(String unitName, String unitType, Integer floorNumber,
                    String status, Double rentAmount) {
        this.unitName = unitName;
        this.unitType = unitType;
        this.floorNumber = floorNumber;
        this.status = status;
        this.rentAmount = rentAmount;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(Double rentAmount) {
        this.rentAmount = rentAmount;
    }
}

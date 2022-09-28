package main.java.model;

public class Vehicle {
    private String regNo;
    private String Color;
    private String carBrand;

    public Vehicle(String regNo, String color) {
        this.regNo = regNo;
        Color = color;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }
}

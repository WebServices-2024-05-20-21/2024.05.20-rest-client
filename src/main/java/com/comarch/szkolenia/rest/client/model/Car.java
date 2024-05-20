package com.comarch.szkolenia.rest.client.model;

public class Car {
    private int id;
    private String brand;
    private String model;
    private String plate;

    public Car(int id, String brand, String model, String plate) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.plate = plate;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}

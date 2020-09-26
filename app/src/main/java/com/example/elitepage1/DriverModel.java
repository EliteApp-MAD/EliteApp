package com.example.elitepage1;

public class DriverModel {
    private int id;
    private String name, time, phone, vehicleno, successfulldeliveries;

    public DriverModel(){

    }

    public DriverModel(int id, String name, String time, String phone, String vehicleno, String successfulldeliveries) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.phone = phone;
        this.vehicleno = vehicleno;
        this.successfulldeliveries = successfulldeliveries;
    }

    public DriverModel(String name, String time, String phone, String vehicleno, String successfulldeliveries) {
        this.name = name;
        this.time = time;
        this.phone = phone;
        this.vehicleno = vehicleno;
        this.successfulldeliveries = successfulldeliveries;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(String vehicleno) {
        this.vehicleno = vehicleno;
    }

    public String getSuccessfulldeliveries() {
        return successfulldeliveries;
    }

    public void setSuccessfulldeliveries(String successfulldeliveries) {
        this.successfulldeliveries = successfulldeliveries;
    }
}

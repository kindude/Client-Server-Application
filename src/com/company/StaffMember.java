package com.company;

import java.io.Serializable;

public class StaffMember implements Serializable {
    private String SNL; //ФИО
    private String Job; //работа
    private int hours; //Количество отработанных часов
    private double pricePerHour; //Цена за час

    public StaffMember(){
    }

    public StaffMember(String SNL, String job, int hours, double pricePerHour) {
        this.SNL = SNL;
        Job = job;
        this.hours = hours;
        this.pricePerHour = pricePerHour;
    }

    public String getSNL() {
        return SNL;
    }

    public void setSNL(String SNL) {
        this.SNL = SNL;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    @Override
    public String toString() {
        return "StaffMember{" +
                "SNL='" + SNL + '\'' +
                ", Job='" + Job + '\'' +
                ", hours=" + hours +
                ", pricePerHour=" + pricePerHour +
                '}';
    }
}

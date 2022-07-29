package com.company;

import java.io.Serializable;

public class PartTimeMember extends StaffMember implements Serializable {
    private String PartTimeJob;
    private int hoursPartTimeJob;
    private double pricePartTimeJobHour;

    public PartTimeMember(){

    }

    public PartTimeMember(String SNL, String job, int hours, double pricePerHour, String partTimeJob, int hoursPartTimeJob, double pricePartTimeJobHour) {
        super(SNL, job, hours, pricePerHour);
        PartTimeJob = partTimeJob;
        this.hoursPartTimeJob = hoursPartTimeJob;
        this.pricePartTimeJobHour = pricePartTimeJobHour;
    }

    public String getPartTimeJob() {
        return PartTimeJob;
    }

    public void setPartTimeJob(String partTimeJob) {
        PartTimeJob = partTimeJob;
    }

    public int getHoursPartTimeJob() {
        return hoursPartTimeJob;
    }

    public void setHoursPartTimeJob(int hoursPartTimeJob) {
        this.hoursPartTimeJob = hoursPartTimeJob;
    }

    public double getPricePartTimeJobHour() {
        return pricePartTimeJobHour;
    }

    public void setPricePartTimeJobHour(double pricePartTimeJobHour) {
        this.pricePartTimeJobHour = pricePartTimeJobHour;
    }

    @Override
    public String toString() {
        return "PartTimeMember{" +
                "PartTimeJob='" + PartTimeJob + '\'' +
                ", hoursPartTimeJob=" + hoursPartTimeJob +
                ", pricePartTimeJobHour=" + pricePartTimeJobHour +
                '}';
    }
}

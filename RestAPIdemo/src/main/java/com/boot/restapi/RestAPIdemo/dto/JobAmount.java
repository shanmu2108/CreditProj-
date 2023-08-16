package com.boot.restapi.RestAPIdemo.dto;

public class JobAmount
{
    private String Job;
    private double totalAmount;

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        this.Job = Job;
    }

    public double getTotalamount() {
        return totalAmount;
    }

    public void setTotalamount(double totalamount) {
        this.totalAmount = totalAmount;
    }
}

package com.boot.restapi.RestAPIdemo.dto;

public class StateAmount
{
    private String state;

    private double totalAmount;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}

package com.boot.restapi.RestAPIdemo.dto;

public class MerchantAmount
{
    private String merchant;
    private double totalAmount;

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public double getTotalamount() {
        return totalAmount;
    }

    public void setTotalamount(double totalamount) {
        this.totalAmount = totalAmount;
    }
}

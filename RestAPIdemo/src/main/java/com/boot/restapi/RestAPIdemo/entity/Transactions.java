package com.boot.restapi.RestAPIdemo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

public class Transactions {
    @Id
    private ObjectId _id;
    @Field("trans_date_trans_time")
    private String transdatetranstime;

    private double amt;
    @Field("trans_num")
    private int transnum;
    @Field("customer_id")
    private int customerid;
    private String city;
    private String state;
    @Field("city_population")
    private int citypopulation;
    private String merchant;
    private String category;
    private String first;
    private String last;
    private String gender;
    @Field("Job")
    private String job;
    private String dob;

    @Override
    public String toString() {
        return "transactions{" +
                "trans_date_trans_time='" + transdatetranstime + '\'' +
                ", amt=" + amt +
                ", trans_num=" + transnum +
                ", customer_id=" + customerid +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", city_population=" + citypopulation +
                ", merchant='" + merchant + '\'' +
                ", category='" + category + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", gender='" + gender + '\'' +
                ", job='" + job + '\'' +
                ", dob=" + dob +
                '}';
    }

    public Transactions() {
    }

    public Transactions(String trans_date_trans_time, double amt, int trans_num, int customer_id, String city, String state, int city_population, String merchant, String category, String first, String last, String gender, String job, String dob) {
        this.transdatetranstime = trans_date_trans_time;
        this.amt = amt;
        this.transnum = trans_num;
        this.customerid = customer_id;
        this.city = city;
        this.state = state;
        this.citypopulation = city_population;
        this.merchant = merchant;
        this.category = category;
        this.first = first;
        this.last = last;
        this.gender = gender;
        this.job = job;
        this.dob = dob;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getTrans_date_trans_time() {
        return transdatetranstime;
    }

    public void setTrans_date_trans_time(String trans_date_trans_time) {
        this.transdatetranstime = trans_date_trans_time;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public int getTrans_num() {
        return transnum;
    }

    public void setTrans_num(int trans_num) {
        this.transnum = trans_num;
    }

    public int getCustomer_id() {
        return customerid;
    }

    public void setCustomer_id(int customer_id) {
        this.customerid = customer_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCity_population() {
        return citypopulation;
    }

    public void setCity_population(int city_population) {
        this.citypopulation = city_population;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}

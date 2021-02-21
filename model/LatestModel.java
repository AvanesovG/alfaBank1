package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class LatestModel {
    private String disclaimer;
    private String license;
    private long timestamp;

    @JsonProperty(value = "base")
    private String currency;

    private HashMap<String, String> rates ;

    public LatestModel() {
    }

    public LatestModel(String disclaimer, String license, long timestamp, String base, HashMap<String, String> rates) {
        this.disclaimer = disclaimer;
        this.license = license;
        this.timestamp = timestamp;
        this.currency = base;
        this.rates = rates;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public HashMap<String, String> getRates() {
        return rates;
    }

    public void setRates(HashMap<String, String> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "LatestModel{" +
                "disclaimer='" + disclaimer + '\'' +
                ", license='" + license + '\'' +
                ", timestamp=" + timestamp +
                ", base='" + currency + '\'' +
                ", rates=" + rates +
                '}';
    }
}

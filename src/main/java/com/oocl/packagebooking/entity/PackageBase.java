package com.oocl.packagebooking.entity;

import javax.persistence.*;

@Table
@Entity
public class PackageBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String trackingNumber;
    private String recipient;
    private String phoneNumber;
    private double weight;

    public PackageBase() {
    }

    public PackageBase(String trackingNumber, String recipient, String phoneNumber, double weight) {
        this.trackingNumber = trackingNumber;
        this.recipient = recipient;
        this.phoneNumber = phoneNumber;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

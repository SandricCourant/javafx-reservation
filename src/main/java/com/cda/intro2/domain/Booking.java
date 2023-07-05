package com.cda.intro2.domain;

public class Booking {
    private String firstname;
    private String lastname;
    private Vehicle vehicle;
    private String startAt;
    private String endAt;
    private String email;
    private String phone;

    public Booking(String firstname, String lastname, Vehicle vehicle, String startAt, String endAt, String email, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.vehicle = vehicle;
        this.startAt = startAt;
        this.endAt = endAt;
        this.email = email;
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return email + ", " + vehicle + ", début: " + startAt + ", fin: " + endAt;
    }
}

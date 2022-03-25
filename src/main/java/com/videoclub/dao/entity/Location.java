package com.videoclub.dao.entity;


import com.videoclub.controller.model.responses.LocationResponse;

import java.time.LocalDate;

public class Location {
    private Long id;
    private User loaner;
    private LocalDate localDate;

    public Location() {
    }

    public Location(User loaner, LocalDate localDate) {
        this.loaner = loaner;
        this.localDate = localDate;
    }

    public LocationResponse toDto(){
        LocationResponse locationResponse = new LocationResponse();
        locationResponse.setId(this.id);
        locationResponse.setLocalDate(this.localDate);
        locationResponse.setLoaner(this.loaner);
        return locationResponse;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getLoaner() {
        return loaner;
    }

    public void setLoaner(User loaner) {
        this.loaner = loaner;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}

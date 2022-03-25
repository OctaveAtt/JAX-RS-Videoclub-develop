package com.videoclub.controller.model.responses;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.videoclub.dao.entity.User;

import java.time.LocalDate;

public class LocationResponse {

    private Long id;
    private User loaner;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate localDate;

    public LocationResponse() {
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

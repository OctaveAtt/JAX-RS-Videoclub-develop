package com.videoclub.controller.model.creates;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.videoclub.dao.entity.User;

import java.io.Serializable;
import java.time.LocalDate;

public class CreateLocation implements Serializable {

    private Long id;
    private User loaner;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate localDate;

    public CreateLocation() {
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

package com.videoclub.controller.model.responses;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class AlbumResponse {
    private Long id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate releaseDate;
    private String artist;
    private double duration;
    private int quantity;

    public AlbumResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

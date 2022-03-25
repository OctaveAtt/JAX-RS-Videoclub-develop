package com.videoclub.dao.entity;

import com.videoclub.controller.model.responses.AlbumResponse;

import java.time.LocalDate;

public class Album {
    private Long id;
    private String title;
    private LocalDate releaseDate;
    private String artist;
    private double duration;
    private int quantity;

    public Album() {
    }

    public Album( String title, LocalDate releaseDate, String artist, double duration, int quantity) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.artist = artist;
        this.duration = duration;
        this.quantity = quantity;
    }

    public AlbumResponse toDto(){
        AlbumResponse albumResponse = new AlbumResponse();
        albumResponse.setId(this.id);
        albumResponse.setReleaseDate(this.releaseDate);
        albumResponse.setArtist(this.artist);
        albumResponse.setDuration(this.duration);
        albumResponse.setQuantity(this.quantity);
        return albumResponse;
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

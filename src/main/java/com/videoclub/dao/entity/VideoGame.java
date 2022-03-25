package com.videoclub.dao.entity;


import com.videoclub.controller.model.responses.VideoGameResponse;

import java.time.LocalDate;

public class VideoGame {

    private Long id;
    private String title;
    private String editor;
    private LocalDate releaseDate;
    private int quantity;

    public VideoGame( String title, String editor, LocalDate releaseDate, int quantity) {
        this.title = title;
        this.editor = editor;
        this.releaseDate = releaseDate;
        this.quantity = quantity;
    }

    public VideoGame() {
    }

    public VideoGameResponse toDto(){
        VideoGameResponse videoGameResponse = new VideoGameResponse();
        videoGameResponse.setId(this.id);
        videoGameResponse.setTitle(this.title);
        videoGameResponse.setEditor(this.editor);
        videoGameResponse.setQuantity(this.quantity);
        videoGameResponse.setReleasedDate(this.releaseDate);
        return videoGameResponse;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

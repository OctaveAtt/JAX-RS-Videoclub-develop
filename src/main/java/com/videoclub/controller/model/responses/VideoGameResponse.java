package com.videoclub.controller.model.responses;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class VideoGameResponse {

    private Long id;
    private String editor;
    private String title;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate releasedDate;
    private int quantity;


    public VideoGameResponse() {
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

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

package com.videoclub.controller.model.creates;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;

public class CreateVideoGame implements Serializable {

    private String title;
    private String editor;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate releasedDate;
    private int quantity;

    public CreateVideoGame() {
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

    public void setReleaseDate(LocalDate releaseDate) {
        this.releasedDate = releaseDate;
    }

    @Override
    public String toString() {
        return "CreateMovie{" +
                "title='" + title + '\'' +
                ", editor=" + editor +
                ", releaseDate=" + releasedDate +
                ",quantity="+quantity+
                '}';
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

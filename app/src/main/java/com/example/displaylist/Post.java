package com.example.displaylist;

import com.google.gson.annotations.Expose;

public class Post {
    @Expose
    private int id;

    @Expose
    private String name;

    @Expose
    private String message;

    @Expose
    private String photoUrl;

    public Post() {

    }

    public Post(int id, String name, String message, String photoUrl) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.photoUrl = photoUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}

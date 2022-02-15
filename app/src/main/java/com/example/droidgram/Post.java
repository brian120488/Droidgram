package com.example.droidgram;

import java.util.ArrayList;

public class Post {
    private int likes;
    private ArrayList<String> comments;
    private String name;
    private String caption;
    private int image;

    public Post(String name, String caption, int image) {
        this.likes = 0;
        this.comments = new ArrayList<String>();
        this.name = name;
        this.caption = caption;
        this.image = image;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaption() { return caption; }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

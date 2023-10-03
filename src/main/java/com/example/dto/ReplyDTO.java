package com.example.dto;

public class ReplyDTO {
    private String text;
    private int likes;
    private int dislikes;
    private UserDTO user;


    public ReplyDTO() {
    }

    public ReplyDTO(String text, int likes, int dislikes, UserDTO user) {
        this.text = text;
        this.likes = likes;
        this.dislikes = dislikes;
        this.user = user;
    }

    // Getter and Setter methods

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
package com.example.dto;


public class UserDTO {
    private Long id;
    private String userName;

    // Constructors

    public UserDTO() {
    }

    public UserDTO(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    // Getter and Setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

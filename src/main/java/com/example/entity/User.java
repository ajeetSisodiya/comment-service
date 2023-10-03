package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;


@ToString
@EqualsAndHashCode
@Entity
@Data
public class User {
    @Id
    private Long id;
    private String userName;
}

package com.wojtek.openapi.resort.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class RoomEty {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    int area;

    int beds;

    boolean bath;

    boolean shower;
}

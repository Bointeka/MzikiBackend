package com.okeyo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "artist")
@AllArgsConstructor
public class Artist {

    Artist(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;
    @Column(name = "genre")
    private String genre;


}

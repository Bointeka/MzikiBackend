package com.okeyo.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "artist")
@NoArgsConstructor
public class Artist {

    public Artist(UUID artistId) {
        this.id = artistId;
    }
    public Artist(String name, String genre) {
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

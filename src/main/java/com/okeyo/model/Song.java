package com.okeyo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.math.BigInteger;
import java.sql.Time;
import java.util.UUID;

@Entity
@Table(name = "song")
@Getter
@Setter
@NoArgsConstructor
public class Song {

    Song(String title, String fileLocation) {
        this.title = title;
        this.fileLocation = fileLocation;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "title")
    private String title;
    @Column(name = "file_location")
    private String fileLocation;
    @Column(name = "cover_location")
    private String coverLocation;
    @Column(name = "play_time")
    private Time playTime;
    @Column(name = "streams")
    private BigInteger streams;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album album;
    private File song;

}

package com.okeyo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "album")
@Getter
@Setter
@NoArgsConstructor
public class Album {

    Album(String albumName, String albumType, Date releaseDt, Artist artist) {
        this.albumName = albumName;
        this.albumType = albumType;
        this.releaseDt = releaseDt;
        this.artist = artist;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "album_name")
    private String albumName;
    @Column(name = "album_type")
    private String albumType;
    @Column(name = "release_date")
    private Date releaseDt;
    @OneToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "song")
    private List<Song> songs;


}

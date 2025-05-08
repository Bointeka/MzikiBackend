package com.okeyo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "album")
@Getter
@Setter
@AllArgsConstructor
public class Album {

    Album(String albumName, String albumType, Date releaseDt, UUID artistId) {
        this.albumName = albumName;
        this.albumType = albumType;
        this.releaseDt = releaseDt;
        this.artistId = artistId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "album_name")
    private String albumName;
    @Column(name = "album_type")
    private String albumType;
    @Column(name = "release_dt")
    private Date releaseDt;
    @Column(name = "artist_id")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private UUID artistId;

}

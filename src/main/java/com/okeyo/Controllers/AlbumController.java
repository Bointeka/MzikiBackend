package com.okeyo.Controllers;

import com.okeyo.Model.Album;
import com.okeyo.Model.Artist;
import com.okeyo.Repositories.AlbumRepository;
import com.okeyo.Service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api")
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private AlbumService albumService;


    @PostMapping("/create-album")
    public ResponseEntity<Album> createAlbum(@RequestBody Album album) {
        albumService.saveAlbum(album);
        return ResponseEntity.ok(album);
    }

    @GetMapping("/albumByArtist")
    public ResponseEntity<List<Album>> getAlbumByArtist(@RequestBody Artist artist) {
        List<Album> albums = albumService.getAlbumByArtist(artist);
        return ResponseEntity.ok(albums);
    }


}

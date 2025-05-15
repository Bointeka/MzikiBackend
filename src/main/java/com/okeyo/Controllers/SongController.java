package com.okeyo.Controllers;

import com.okeyo.Model.Album;
import com.okeyo.Model.Song;
import com.okeyo.Service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name="/api")
public class SongController {

    @Autowired
    private AlbumService albumService;


    @PostMapping(name="/stream")
    public ResponseEntity stream(@RequestBody Song song) {
        return ResponseEntity.ok().build();
    }
}

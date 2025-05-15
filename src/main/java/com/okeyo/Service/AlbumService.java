package com.okeyo.Service;

import com.okeyo.Model.Album;
import com.okeyo.Model.Artist;
import com.okeyo.Model.Song;

import java.util.List;

public interface AlbumService {

    void saveAlbum(Album song);

    List<Album> getAlbumByArtist(Artist artist);

}

package com.okeyo.Repositories;

import com.okeyo.Model.Album;
import com.okeyo.Model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AlbumRepository extends JpaRepository<Album, UUID> {

    List<Album> findAlbumByArtist(Artist artist);
}

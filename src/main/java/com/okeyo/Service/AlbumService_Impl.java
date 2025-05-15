package com.okeyo.Service;

import com.okeyo.Model.Album;
import com.okeyo.Model.Artist;
import com.okeyo.Model.Song;
import com.okeyo.Repositories.AlbumRepository;
import com.okeyo.Repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.util.List;

@Service
public class AlbumService_Impl implements AlbumService {
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private S3Client s3Client;
    @Value("${s3.bucket.name}")
    private String bucketName;


    public List<Album> getAlbumByArtist(Artist artist) {
       return albumRepository.findAlbumByArtist(artist);
    }

    public void saveAlbum(Album album) {
        albumRepository.save(album);
        String artistId = album.getArtist().getId().toString();
        String fileLocation = artistId.concat("/").concat(album.getId().toString()).concat("/");

        for (Song song: album.getSongs()) {
            songRepository.save(song);
            song.setFileLocation(fileLocation.concat(song.getId().toString()));

            PutObjectRequest putObj = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(song.getFileLocation())
                .build();

            s3Client.putObject(putObj, RequestBody.fromFile(song.getSong()));

        }



    }
}

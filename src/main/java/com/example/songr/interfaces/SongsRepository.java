package com.example.songr.interfaces;

import com.example.songr.Album;
import com.example.songr.Songs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SongsRepository extends JpaRepository <Songs,Long> {
    Optional<List<Songs>> findSongsByAlbum(Album title);
}

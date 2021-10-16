package com.example.songr.interfaces;

import com.example.songr.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {
    Optional<Album> findAlbumByTitle(String title);
}

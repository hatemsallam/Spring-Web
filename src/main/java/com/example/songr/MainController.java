package com.example.songr;

import com.example.songr.SongDTO.SongDTO;
import interfaces.AlbumRepository;
import interfaces.SongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private SongsRepository songsRepository;


    @GetMapping("/hello")
    String getGreeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model userName) {
        userName.addAttribute("name", name);
        return "Greeting";
    }

    @GetMapping("/capitalize/{word}")
    public String showCapital(Model m, @PathVariable("word") String word) {
        m.addAttribute("word", word);
        return "Capitalize";
    }

    Album albums[] = {
            new Album("agmal oyoon",
                    "Amro Diab",
                    15,
                    1500, "https://see.news/wp-content/uploads/2021/06/unnamed-e1622636145135.jpg")
            ,
            new Album("Hana AL-Aan"
                    , "Adham Nabelsi",
                    26,
                    15002,
                    "https://i.ytimg.com/vi/bUUBdcUGgA8/maxresdefault.jpg")
            ,
            new Album("Boshrat Khair"
                    , "Hussein AlJasmi",
                    10,
                    2600,
                    "https://etbilarabi.com/sites/default/files/styles/article_landing/public/2019-04/unnamed.jpg?itok=PpdAaQ_S")
    };

    @GetMapping("/album")
    String getAlbum(Model album) {
        album.addAttribute("album", albums);
        return "albums";
    }

    @PostMapping("/albums")
    public RedirectView createNewAlbum(@ModelAttribute Album album) {
        albumRepository.save(album);
        return new RedirectView("addAlbum");
    }

    @GetMapping("/albums")
    public String getAlbums(Model model) {
        model.addAttribute("album", albumRepository.findAll());
        return "addAlbum";
    }


    @GetMapping("/allAlbums")
    public String getAllAlbums(Model model) {
        model.addAttribute("album", albumRepository.findAll());
        return "albums";

    }

    @GetMapping("/songs")
    public String viewAllSongs(Model model) {
        model.addAttribute("songs", songsRepository.findAll());
        return "songs";

    }

    @GetMapping("/songs/addSong")
    public String addSong() {
        return "songForm";
    }

    @GetMapping("/songs/album/{album}")
    public String getSongsByAlbum(@PathVariable String album, Model model) {
        List<Songs> songs = songsRepository.findSongsByAlbumTitle(album).orElseThrow();
        model.addAttribute("songs", songs);
        return "songs";
    }

    @PostMapping("/songs")
    public RedirectView createNewSong(@ModelAttribute SongDTO songDTO) {
        Album album = albumRepository.findAlbumByTitle(songDTO.getAlbum()).orElseThrow();
        Songs newSong = new Songs(songDTO.getTitle(), songDTO.getLength(), songDTO.getTrackNumber(), album);
        songsRepository.save(newSong);
        return new RedirectView("songs");

    }
}

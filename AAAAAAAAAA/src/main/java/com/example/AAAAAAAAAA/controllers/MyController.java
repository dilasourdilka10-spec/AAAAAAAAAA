package com.example.AAAAAAAAAA.controllers;

import com.example.AAAAAAAAAA.Song;
import com.example.AAAAAAAAAA.SongRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class MyController {

    private final SongRepository repo = new SongRepository();

    @GetMapping
    public List<Song> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public String add(@RequestBody Song song) {
        repo.save(song);
        return "Saved!";
    }

    @PutMapping("/{title}")
    public String update(@PathVariable String title, @RequestBody Song song) {
        repo.update(title, song.getDuration(), song.getGenre());
        return "Updated!";
    }

    @DeleteMapping("/{title}")
    public String delete(@PathVariable String title) {
        repo.delete(title);
        return "Deleted!";
    }
}
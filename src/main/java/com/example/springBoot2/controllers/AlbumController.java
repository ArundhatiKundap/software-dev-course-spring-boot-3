package com.example.springBoot2.controllers;

import com.example.springBoot2.Repositories.AlbumRepository;

import com.example.springBoot2.models.Album;

import com.example.springBoot2.models.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumRepository albumRepository;
    private final List<Album> albums = List.of(
        new Album("The Dark Side of the Moon", "Pink Floyd", 1973, 10),
        new Album("Back in Black", "AC/DC", 1980, 10),
        new Album("The Bodyguard", "Whitney Houston", 1992, 10)
    );

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }


    @GetMapping("")
    public List<Album> getAllItems() {
        return albumRepository.findAll();
    }

    @PostMapping("/add")
    public Album addItem(@RequestBody Album album) {
        return albumRepository.save(album);
    }
    @GetMapping("/{id}")
    public Album getItem(@PathVariable int id) {
        return albumRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Album updateItem(@PathVariable int id, @RequestBody Album album) {
        album.setId(id);
        return albumRepository.save(album);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        albumRepository.deleteById(id);
    }
}

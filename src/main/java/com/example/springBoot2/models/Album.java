package com.example.springBoot2.models;


import jakarta.persistence.*;

@Entity

public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Year")
    private int year;
    @Column(name = "Artist")
    private String artist;
    @Column(name = "Number of Tracks")
    private int tracks;

    public Album() {
    }

    public Album(String name, String artist, int year, int tracks) {
        this.name = name;
        this.year = year;
        this.artist = artist;
        this.tracks = tracks;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getTracks() {
        return tracks;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }
}

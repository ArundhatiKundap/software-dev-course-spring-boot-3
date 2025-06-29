package com.example.springBoot2.models;
import jakarta.persistence.*;

@Entity
public class Movie  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Year")
    private int year;
    @Column(name = "Director")
    private String director;
    @Column(name = "Runtime")
    private int runtime;

    public Movie() {
    }

    public Movie(String name, String director, int year, int duration) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.runtime = duration;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }
}

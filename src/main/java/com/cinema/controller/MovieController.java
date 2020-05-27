package com.cinema.controller;

import com.cinema.model.Movie;
import com.cinema.service.MovieService;
import com.cinema.service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieServiceImpl movieService) {
        this.movieService = movieService;
    }

    @PostMapping("add")
    public void addMovie(@RequestBody Movie newMovie) {
        movieService.addMovie(newMovie);
    }

    @GetMapping("getAll")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("get/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long movieId) {
        return ResponseEntity.of(movieService.getMovieById(movieId));
    }

    @PutMapping("update")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie updatedMovie) {
        return ResponseEntity.of(movieService.updateMovie(updatedMovie));
    }

    @DeleteMapping("delete/{movieId}")
    public void deleteMovie(@PathVariable Long movieId) {
        movieService.deleteMovie(movieId);
    }

}

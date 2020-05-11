package com.cinema.controller;

import com.cinema.model.Movie;
import com.cinema.service.MovieService;
import com.cinema.service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Boolean> addMovie(@RequestBody Movie newMovie) {
        return new ResponseEntity<>(movieService.addMovie(newMovie), HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("get/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long movieId) {
        return ResponseEntity.of(movieService.getMovie(movieId));
    }

    @PutMapping("update")
    public ResponseEntity<Boolean> updateMovie(@RequestBody Movie updatedMovie) {
        return new ResponseEntity<>(movieService.updateMovie(updatedMovie), HttpStatus.OK);
    }

    @DeleteMapping("delete/{movieId}")
    public ResponseEntity<Boolean> deleteMovie(@PathVariable Long movieId) {
        return new ResponseEntity<>(movieService.deleteMovie(movieId), HttpStatus.OK);
    }
}

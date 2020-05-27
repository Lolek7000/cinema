package com.cinema.service;

import com.cinema.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    void addMovie(Movie newMovie);

    List<Movie> getAllMovies();

    Optional<Movie> getMovieById(Long movieId);

    Optional<Movie> updateMovie(Movie updatedMovie);

    void deleteMovie(Long movieId);

}

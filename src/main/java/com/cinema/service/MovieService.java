package com.cinema.service;

import com.cinema.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    boolean addMovie(Movie newMovie);

    List<Movie> getAllMovies();

    Optional<Movie> getMovie(Long movieId);

    boolean updateMovie(Movie updatedMovie);

    boolean deleteMovie(Long movieId);

}

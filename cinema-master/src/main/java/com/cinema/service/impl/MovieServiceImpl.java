package com.cinema.service.impl;

import com.cinema.model.Movie;
import com.cinema.repository.MovieRepo;
import com.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepo movieRepo;

    @Autowired
    public MovieServiceImpl(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    public void addMovie(Movie newMovie) {
        movieRepo.save(newMovie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    @Override
    public Optional<Movie> getMovieById(Long movieId) {
        return movieRepo.findById(movieId);
    }

    @Override
    public Optional<Movie> updateMovie(Movie updatedMovie) {
        Optional<Movie> movie = movieRepo.findById(updatedMovie.getId());
        if (movie.isPresent()){
            movieRepo.save(updatedMovie);
        }
        return movie;

    }

    @Override
    public void deleteMovie(Long movieId) {
        movieRepo.deleteById(movieId);
    }
}

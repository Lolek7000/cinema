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
    public boolean addMovie(Movie newMovie) {
        if (!movieRepo.findByTitleAndDirector(newMovie.getTitle(), newMovie.getDirector()).isPresent()) {
            movieRepo.save(newMovie);
            return true;
        }
        return false;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    @Override
    public Optional<Movie> getMovie(Long movieId) {
        return movieRepo.findById(movieId);
    }

    @Override
    public boolean updateMovie(Movie updatedMovie) {
        if (!movieRepo.findById(updatedMovie.getId()).isPresent()) {
            movieRepo.save(updatedMovie);
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteMovie(Long movieId) {
        if (movieRepo.findById(movieId).isPresent()) {
            movieRepo.deleteById(movieId);
            return true;
        }
        return false;
    }
}

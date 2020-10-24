package com.nerubia.codingchallenge.controller;

import com.nerubia.codingchallenge.service.MovieService;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@CrossOrigin
@RestController
/**
 * Class where MovieService is called.
 * Mapping of endpoints.
 */
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * Fetch movie detail given the ID.
     * @param movieId Movie ID
     * @return {@link MovieDb } MovieDb Object
     */
    @GetMapping("/api/getMovieDetails")
    public MovieDb getMovieDetails(@RequestParam int movieId) {
        MovieDb movieDb = movieService.getMovieDetails(movieId);
        return movieDb;
    }

    /**
     * Fetch popular movies given page
     * @param page current page
     * @return {@link MovieResultsPage} MovieResultPage Object
     */
    @GetMapping("/api/getPopularMovies")
    public MovieResultsPage getPopularMovies(@RequestParam int page) {
        MovieResultsPage movieResultsPage = movieService.getPopularMovies(page);
        return movieResultsPage;
    }
}

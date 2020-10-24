package com.nerubia.codingchallenge.service;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.properties")
/**
 * Class where TMDB API calls are made.
 */
public class MovieService {

    @Value("${TMDB.api.key}")
    String apiKey;

    private static final String LANGUAGE = "en";

    /**
     * Fetch popular movies given page
     * @param page current page
     * @return {@link MovieResultsPage} MovieResultPage Object
     */
    public MovieResultsPage getPopularMovies(int page) {
        TmdbMovies movies = new TmdbApi(apiKey).getMovies();
        MovieResultsPage movieResultsPage = movies.getPopularMovies(LANGUAGE, page);
        return movieResultsPage;
    }

    /**
     * Fetch movie detail given the ID.
     * @param movieId Movie ID
     * @return {@link MovieDb } MovieDb Object
     */
    public MovieDb getMovieDetails(int movieId) {
        TmdbMovies movies = new TmdbApi(apiKey).getMovies();
        MovieDb movie = movies.getMovie(movieId, LANGUAGE);
        return movie;
    }

}

package com.github.dgett130.A001.controller;

import com.github.dgett130.A001.entity.Movie;
import com.github.dgett130.A001.entity.TMDBConfig;
import com.github.dgett130.A001.service.MovieService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class  MovieController {

    @Resource
    private MovieService movieService;
    @Resource
    private TMDBConfig tmdbConfig;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        //log.info("API Key: {}", tmdbConfig.getApiKey());


        return null;

        // Commentata chiamata di test a DB
        // return new ResponseEntity<>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
        return new ResponseEntity<>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }

}

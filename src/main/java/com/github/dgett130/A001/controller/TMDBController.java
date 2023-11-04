package com.github.dgett130.A001.controller;

import com.github.dgett130.A001.entity.TMDBConfig;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@RestController
@Slf4j
@RequestMapping("/api/v1/tmdb")
@CrossOrigin(origins = "http://localhost:3000")
public class TMDBController {

    private final RestTemplate restTemplate;
    @Resource
    private TMDBConfig tmdbConfig;

    @Autowired
    public TMDBController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/check/auth")
    public ResponseEntity<String> checkAuth() {

        String url = "https://api.themoviedb.org/3/authentication?api_key=" + tmdbConfig.getApiKey();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);

        return response;

    }

    @GetMapping("/movies/popular")
    public ResponseEntity<String> getPopularMovies() {

        String url = "https://api.themoviedb.org/3/movie/popular?api_key=" + tmdbConfig.getApiKey() + "&language=en-US&page=1";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);

        return response;

    }

    @GetMapping("/movies/top_rated")
    public ResponseEntity<String> getTopRatedMovies() {

        String url = "https://api.themoviedb.org/3/movie/top_rated?api_key=" + tmdbConfig.getApiKey() + "&language=en-US&page=1";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);

        return response;

    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<String> getMovieData(@PathVariable("id") String movieId) {

        String url = "https://api.themoviedb.org/3/movie/"+ movieId +"?api_key=" + tmdbConfig.getApiKey() + "&language=en-US&page=1";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);

        return response;
    }



}

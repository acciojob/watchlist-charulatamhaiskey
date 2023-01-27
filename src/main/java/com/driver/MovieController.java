package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        String response = movieService.addMovie(movie);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }
    @PostMapping("/movies/add-director")
    public ResponseEntity addDirector(@RequestBody Director director)
    {
        String response = movieService.director(director);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair( @RequestParam String Movie_name,@RequestParam String Director_name)
    {
        String response = movieService.addMovieDirectorPair(Movie_name,Director_name);
        return new ResponseEntity<>("",HttpStatus.ACCEPTED);
    }
    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@RequestParam("Name") String Movie_name)
    {
        Movie  m = movieService.movieRepository.getMovieByName(Movie_name);
        return new ResponseEntity<>(m,HttpStatus.FOUND);
    }
    @GetMapping(" /movies/get-director-by-name/{name}")
    public ResponseEntity  getDirectorByName(@RequestParam("Name") String Director_Name){
        Director d = movieService.movieRepository.getDirectorByName(Director_Name);
        return new ResponseEntity<>(d,HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity  getMoviesByDirectorName(@RequestParam("director") String director_Name){
        List<String> ans = movieService.movieRepository.getMoviesByDirectorName(director_Name);
        return new ResponseEntity<>(ans,HttpStatus.FOUND);
    }
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity  findAllMovies(){
        List<String> ans = movieService.movieRepository.findAllMovies();
        return new ResponseEntity<>(ans,HttpStatus.FOUND);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam String DirectorName)
    {
        String response = movieService.deleteDirectorByName(DirectorName);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity  deleteAllDirectors()
    {
        String response = movieService.deleteAllDirectors();
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
}

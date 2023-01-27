package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie)
    {
        String response = movieRepository.addMovie(movie);
        return  response;
    }
    public String director(Director director)
    {
        String response = movieRepository.addDirector(director);
        return  response;
    }
    public  String addMovieDirectorPair(String Movie_Name,String Director_Name)
    {
        String response = movieRepository.addMovieDirectorPair(Movie_Name,Director_Name);
        return  response;
    }

    public String deleteDirectorByName(String directorName) {
        String response = movieRepository.deleteDirectorByName(directorName);
        return response;
    }

    public String deleteAllDirectors() {
        String response = movieRepository.deleteAllDirectors();
        return response;
    }
}
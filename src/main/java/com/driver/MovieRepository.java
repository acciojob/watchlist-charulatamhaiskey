package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {
    Map<String,Movie> DBMovie = new HashMap<>();
    Map<String,Director> DBDirector = new HashMap<>();
    Map<String,List<String> > Movie_pair = new HashMap<>();
    public  String addMovie(Movie movie)
    {
        DBMovie.put(movie.getName(),movie);
        return "success";
    }
    public String addDirector(Director director)
    {
        DBDirector.put(director.getName(), director);
        return "success";
    }
    public String addMovieDirectorPair(String MovieName,String DirectorName)
    {
        Movie_pair.put(DirectorName,Movie_pair.getOrDefault(DirectorName,new ArrayList<>()));
        Movie_pair.get(DirectorName).add(MovieName);
        return "success";
    }

    public Movie getMovieByName(String Name)
    {
        return DBMovie.get(Name);
    }
    public Director getDirectorByName(String Director)
    {
        return DBDirector.get(Director);
    }

    public List<String> getMoviesByDirectorName(String DirectorName)
    {

        return Movie_pair.get(DirectorName);
    }
    public List<String> findAllMovies()
    {
        List<String> Movies_Name = new ArrayList<>();
        for(String Name: DBMovie.keySet())
        {
            Movies_Name.add(Name);
        }
        return Movies_Name;
    }
    public String deleteDirectorByName(String DirectorName)
    {
        List<String> ans = Movie_pair.get(DirectorName);
        for(String s : ans)
        {
            if(DBMovie.containsKey(s)) {
                DBMovie.remove(s);
            }
        }
        return  "Success";
    }
    public String deleteAllDirectors()
    {
        for(String s : Movie_pair.keySet())
        {
            List<String> ans = Movie_pair.get(s);
            for(String se : ans)
            {
                if(DBMovie.containsKey(se)) {
                    DBMovie.remove(se);
                }
            }
        }
        return "Success";
    }
}

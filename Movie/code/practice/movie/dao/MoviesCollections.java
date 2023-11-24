package practice.movie.dao;

import practice.movie.model.Movie;

import java.time.LocalDate;

public interface MoviesCollections<M> extends Iterable<Movie> {

   boolean addMovie(Movie movie);
   Movie removeMovie(long imdb);
   Movie findById(long imdb);
   Iterable<Movie> findByName(String name);
   Iterable<Movie> findByGenre(String genre);
   Iterable<Movie> findByDirector(String director);
   Iterable<Movie> findMoviesCreatedBetweenDates(LocalDate from, LocalDate to);
   int totalQuantity();
}

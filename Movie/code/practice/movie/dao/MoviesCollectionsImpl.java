package practice.movie.dao;

import practice.movie.model.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MoviesCollectionsImpl implements MoviesCollections<Movie> {
    private Collection<Movie> movies;

    public MoviesCollectionsImpl() {
        movies = new ArrayList<>();
    }

    public MoviesCollectionsImpl(List<Movie> list) {
        this();
        for (Movie m : list) {
            movies.add(m);
        }
    }

    @Override
    public boolean addMovie(Movie movie) {
        for (Movie m : movies) {
            if (movie == null || m.getImdb() == movie.getImdb()) {
                return false;
            }
        } return movies.add(movie);
    }

    @Override
    public Movie removeMovie(long imdb) {
        for (Movie m : movies) {
            if (m.getImdb() == imdb) {
                movies.remove(m);
                return m;
            }
        } return null;
    }

    @Override
    public Movie findById(long imdb) {
        for (Movie m : movies) {
            if (m.getImdb() == imdb) {
                return m;
            }
        } return null;
    }

    @Override
    public Iterable<Movie> findByName(String name) {
        List<Movie> moviesByName = new ArrayList<>();
        for (Movie m: movies) {
            if (m.getName().equalsIgnoreCase(name)){
                moviesByName.add(m);
            }
        } return moviesByName;
    }

    @Override
    public Iterable<Movie> findByGenre(String genre) {
        List<Movie> moviesByGenre = new ArrayList<>();
        for (Movie m : movies) {
            if (m.getGenre().equalsIgnoreCase(genre)) {
                moviesByGenre.add(m);
            }
        } return moviesByGenre;
    }

    @Override
    public Iterable<Movie> findByDirector(String director) {
        List<Movie> moviesByDirector = new ArrayList<>();
        for (Movie m : movies) {
            if (m.getDirectore().equalsIgnoreCase(director)) {
                moviesByDirector.add(m);
            }
        } return moviesByDirector;
    }

    @Override
    public Iterable<Movie> findMoviesCreatedBetweenDates(LocalDate from, LocalDate to) {
        List result = new ArrayList<>();
        for (Movie movie : movies) {
            LocalDate createdDate = movie.getDate();
            if (createdDate.isAfter(from) && createdDate.isBefore(to)) {
                result.add(movie);
            }
        } return result;
    }

    @Override
    public int totalQuantity() {
        return movies.size();
    }

    @Override
    public Iterator<Movie> iterator() {
        return movies.iterator();
    }
}

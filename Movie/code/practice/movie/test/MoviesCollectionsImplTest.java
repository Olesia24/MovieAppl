package practice.movie.test;

import practice.movie.dao.MoviesCollections;
import practice.movie.dao.MoviesCollectionsImpl;
import practice.movie.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


class MoviesCollectionsImplTest {

    Movie movies;
    MoviesCollections moviesCollections;
    static final LocalDate now = LocalDate.now();

    @BeforeEach
    void setUp() {
        moviesCollections = new MoviesCollectionsImpl(List.of(
                new Movie(1000,"Name1","D1","G1",now.minusYears(5)),
                new Movie(2000,"Name2","D2","G2",now.minusYears(4)),
                new Movie(3000,"Name3","D3","G3",now.minusYears(3)),
                new Movie(4000,"Name4","D4","G4",now.minusYears(2)),
                new Movie(5000,"Name5","D5","G5",now.minusYears(1))
        ));
    }
    @Test
    void addMovieTest() {
        assertFalse(moviesCollections.addMovie(null));
        assertFalse(moviesCollections.addMovie(new Movie(2000, "Name2","D2","G2",now.minusYears(4))));
        assertEquals(5, moviesCollections.totalQuantity());
        assertTrue(moviesCollections.addMovie(new Movie(6000, "F", "F", "F", now.minusYears(7))));
        assertEquals(6, moviesCollections.totalQuantity());
    }

    @Test
    void removeMovie() {
        assertNotNull(moviesCollections.removeMovie(1000));
        assertNull(moviesCollections.removeMovie(7000));
        assertEquals(4, moviesCollections.totalQuantity());
    }

    @Test
    void findById() {
        assertEquals( new Movie(1000,"Name1","D1","G1",now.minusYears(5)), moviesCollections.findById(1000));
        assertNull(moviesCollections.findById(7000));
    }

    @Test
    void findByGenre() {
        assertEquals(1, ((List<Movie>) moviesCollections.findByGenre("G1")).size());
        assertEquals(0, ((List<Movie>) moviesCollections.findByGenre("UnknownGenre")).size());
    }
    @Test
    void findByDirector() {
        assertEquals(1, ((List<Movie>) moviesCollections.findByDirector("D1")).size());
        assertEquals(0, ((List<Movie>) moviesCollections.findByDirector("UnknownDirector")).size());
    }
    @Test
    void findMoviesCreatedBetweenDates() {
        assertEquals(2, ((List<Movie>) moviesCollections.findMoviesCreatedBetweenDates(now.minusYears(4), now.minusYears(1))).size());
        assertEquals(0, ((List<Movie>) moviesCollections.findMoviesCreatedBetweenDates(now.minusYears(10), now.minusYears(8))).size());
    }
    @Test
    void totalQuantity() {
        //assertEquals(5, moviesCollections.totalQuantity());
        assertEquals(5, moviesCollections.totalQuantity());
        moviesCollections.addMovie(new Movie(6000, "Name6", "G6", "D6", now.minusYears(7)));
        assertEquals(6, moviesCollections.totalQuantity());
        moviesCollections.removeMovie(3000);
        assertEquals(5, moviesCollections.totalQuantity());
    }

}
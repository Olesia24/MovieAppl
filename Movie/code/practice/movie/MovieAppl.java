package practice.movie;


import practice.movie.dao.MoviesCollectionsImpl;
import practice.movie.model.Menu_movie;
import practice.movie.model.Movie;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MovieAppl {
    public static void main(String[] args) {
        Movie movies;
        LocalDate now = LocalDate.now();
        MoviesCollectionsImpl movieList = new MoviesCollectionsImpl();
        movieList.addMovie(new Movie(1000, "Inception", "Christopher Nolan", "Action", now.withYear(2010)));
        movieList.addMovie(new Movie(2000, "La La Land", "Damien Chazelle", "Drama", now.withYear(2016)));
        movieList.addMovie(new Movie(3000, "The Social Network", "David Fincher", "Biography", now.withYear(2010)));
        movieList.addMovie(new Movie(4000, "Parasite", "Bong Joon Ho", "Drama", now.withYear(2019)));
        movieList.addMovie(new Movie(5000, "The Revenant", "Alejandro González", "Thriller", now.withYear(2015)));

        System.out.println("Welcome to Cinema World!!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu_movie.printMenu();
            System.out.println("Select number for currency conversion: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) { //print all movies
                    case 1: {
                        for (Movie m : movieList) {
                            System.out.println(m);
                        }
                        System.out.println("====================================================");
                        break;
                    }
                    case 2: { //Find Movie by name
                        System.out.println("Enter the movie name: ");
                        String name = scanner.next();
                        List<Movie> nameRes = (List<Movie>) movieList.findByName(name);
                        for (Movie m: nameRes) {
                            System.out.println(m);
                        }
                        System.out.println("====================================================");
                        break;
                    }
                    case 3: { //Find Movie by Genre
                        System.out.println("Enter the genre: ");
                        String genre = scanner.next();
                        List<Movie> genreRes = (List<Movie>) movieList.findByGenre(genre);
                        for (Movie m: genreRes) {
                            System.out.println(m);
                        }
                        System.out.println("====================================================");
                        break;
                    }
                    case 4: { //Find Movie by Director
                        System.out.println("Enter director's name: ");
                        String director = scanner.next();
                        List<Movie> directorResults = (List<Movie>) movieList.findByDirector(director);
                        for (Movie m: directorResults) {
                            System.out.println(m);
                        }
                        System.out.println("====================================================");
                        break;
                    }
                    case 5: { //find movie between dates
                        System.out.println("Enter the year from: ");
                        int fromDate = scanner.nextInt();
                        System.out.println("Enter the year to: ");
                        int toDate = scanner.nextInt();

                        LocalDate startDate = LocalDate.of(fromDate, 1, 1);
                        LocalDate endDate = LocalDate.of(toDate, 12, 31);

                        List<Movie> res = (List<Movie>) movieList.findMoviesCreatedBetweenDates(startDate, endDate);
                        for (Movie m: res) {
                            System.out.println(m);
                        }
                        System.out.println("====================================================");
                        break;
                    }
                    case 6: {
                        Menu_movie.exit();
                        break;
                    }
                    default: {
                        System.out.println("Wrong input.");
                        Menu_movie.exit();
                    }
                }
            } catch (Exception e) {
                System.out.println("Wrong input");
            }
        }

    }
}




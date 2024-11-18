package software.ulpgc.kata2;

import software.ulpgc.kata2.io.MovieReader;
import software.ulpgc.kata2.io.TsvMovieDeserializer;
import software.ulpgc.kata2.io.TsvMovieReader;
import software.ulpgc.kata2.model.Movie;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        MovieReader reader = new TsvMovieReader(new File("src/main/resources/title.basics.tsv"), new TsvMovieDeserializer());
        try {
            List<Movie> movieList = reader.read();

            long longMovieCount = movieList.stream()
                    .filter(movie -> movie.duration() > 180)
                    .count();
            System.out.println(longMovieCount);

            Map<Integer, Long> movieCountByYear = movieList.stream()
                    .collect(Collectors.groupingBy(Movie::year, Collectors.counting()));

            movieCountByYear.forEach((year, count) ->
                    System.out.println("Year: " + year + " Count: " + count));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

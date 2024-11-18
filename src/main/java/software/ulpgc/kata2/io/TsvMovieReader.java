package software.ulpgc.kata2.io;

import software.ulpgc.kata2.model.Movie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TsvMovieReader implements MovieReader {
    private final File file;
    private final TsvMovieDeserializer deserializer;

    public TsvMovieReader(File file, TsvMovieDeserializer deserializer) {
        this.file = file;
        this.deserializer = deserializer;
    }

    @Override
    public List<Movie> read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<Movie> movies = new ArrayList<>();
        skipHeader(reader);
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            movies.add(deserializer.deserialize(line));
        }
        return movies;
    }

    private static void skipHeader(BufferedReader reader) throws IOException {
        reader.readLine();
    }
}

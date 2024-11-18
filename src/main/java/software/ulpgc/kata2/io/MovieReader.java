package software.ulpgc.kata2.io;

import software.ulpgc.kata2.model.Movie;

import java.io.IOException;
import java.util.List;

public interface MovieReader {
    List<Movie> read() throws IOException;
}

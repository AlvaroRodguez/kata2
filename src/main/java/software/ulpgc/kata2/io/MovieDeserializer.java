package software.ulpgc.kata2.io;

import software.ulpgc.kata2.model.Movie;

import java.io.IOException;

public interface MovieDeserializer {
    Movie deserialize(String text);
}

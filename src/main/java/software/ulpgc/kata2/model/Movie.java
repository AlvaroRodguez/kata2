package software.ulpgc.kata2.model;

import java.util.List;

public record Movie(String id, String primaryTitle, String originalTitle, int year, int duration, List<Genre> genres) {
}

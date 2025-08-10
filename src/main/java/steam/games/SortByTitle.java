package steam.games;

import java.util.List;
import java.util.stream.Collectors;

public class SortByTitle implements SortStrategy {
    @Override
    public List<Game> sort(List<Game> games) {
        return games.stream()
                .sorted((g1, g2) -> g1.getTitle().compareTo(g2.getTitle()))
                .collect(Collectors.toList());
    }
}
package steam.games;

import java.util.List;
import java.util.stream.Collectors;

public class SortByPrice implements SortStrategy {
    @Override
    public List<Game> sort(List<Game> games) {
        return games.stream()
                .sorted((g1, g2) -> Double.compare(g1.getPrice(), g2.getPrice()))
                .collect(Collectors.toList());
    }
}
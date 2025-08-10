package steam.games;

import java.util.List;

public interface SortStrategy {
    List<Game> sort(List<Game> games);
}
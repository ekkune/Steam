package steam.analysis;

import steam.games.Game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LibraryAnalyzer implements Analyzer {
    private List<Game> library;

    public LibraryAnalyzer(List<Game> library) {
        this.library = library;
    }

    @Override
    public void analyze() {
        if (library.isEmpty()) {
            System.out.println("Library is empty. No analysis available.");
            return;
        }

        // Расчёт базовой статистики
        int totalGames = library.size();
        double totalPrice = library.stream().mapToDouble(Game::getPrice).sum();
        double averagePrice = totalPrice / totalGames;
        double maxPrice = library.stream().mapToDouble(Game::getPrice).max().orElse(0);
        double minPrice = library.stream().mapToDouble(Game::getPrice).min().orElse(0);
        Map<String, Long> typeCount = library.stream()
                .collect(Collectors.groupingBy(Game::getType, Collectors.counting()));

        // Более сложный анализ: Стандартное отклонение цен
        double mean = averagePrice;
        double variance = library.stream()
                .mapToDouble(game -> Math.pow(game.getPrice() - mean, 2))
                .sum() / totalGames;
        double stdDev = Math.sqrt(variance);

        // Распределение по ценовым категориям
        Map<String, Long> priceDistribution = new HashMap<>();
        priceDistribution.put("<20", library.stream().filter(g -> g.getPrice() < 20).count());
        priceDistribution.put("20-50", library.stream().filter(g -> g.getPrice() >= 20 && g.getPrice() < 50).count());
        priceDistribution.put("50-100", library.stream().filter(g -> g.getPrice() >= 50 && g.getPrice() < 100).count());
        priceDistribution.put(">100", library.stream().filter(g -> g.getPrice() >= 100).count());

        // Вывод статистики
        System.out.println("Advanced Library Analysis:");
        System.out.println("- Total games: " + totalGames);
        System.out.println("- Total spent: $" + String.format("%.2f", totalPrice));
        System.out.println("- Average price: $" + String.format("%.2f", averagePrice));
        System.out.println("- Max price: $" + String.format("%.2f", maxPrice));
        System.out.println("- Min price: $" + String.format("%.2f", minPrice));
        System.out.println("- Standard deviation of prices: " + String.format("%.2f", stdDev));
        System.out.println("- Games by type:");
        typeCount.forEach((type, count) -> System.out.println("  - " + type + ": " + count));
        System.out.println("- Price distribution:");
        priceDistribution.forEach((range, count) -> System.out.println("  - " + range + ": " + count));

        // Простой ASCII-график для распределения по типам
        System.out.println("- Type distribution bar chart:");
        long maxCount = typeCount.values().stream().max(Long::compare).orElse(1L);
        typeCount.forEach((type, count) -> {
            System.out.print(type + ": ");
            int barLength = (int) (count * 20 / maxCount);
            for (int i = 0; i < barLength; i++) {
                System.out.print("█");
            }
            System.out.println(" (" + count + ")");
        });
    }
}
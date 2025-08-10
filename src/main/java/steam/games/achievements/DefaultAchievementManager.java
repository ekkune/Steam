package steam.games.achievements;

import steam.games.Achievement;
import steam.games.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultAchievementManager implements AchievementManager {
    private Map<Game, List<Achievement>> gameAchievements;

    public DefaultAchievementManager() {
        this.gameAchievements = new HashMap<>();
    }

    @Override
    public void addAchievement(Game game, Achievement achievement) {
        gameAchievements.computeIfAbsent(game, k -> new ArrayList<>()).add(achievement);
        System.out.println("Added achievement '" + achievement.getName() + "' to game: " + game.getTitle());
    }

    @Override
    public void unlockAchievement(Game game, String achievementName) {
        List<Achievement> achievements = gameAchievements.getOrDefault(game, new ArrayList<>());
        for (Achievement achievement : achievements) {
            if (achievement.getName().equals(achievementName)) {
                achievement.unlock();
                return;
            }
        }
        System.out.println("Achievement '" + achievementName + "' not found for game: " + game.getTitle());
    }

    @Override
    public void viewAchievements(Game game) {
        List<Achievement> achievements = gameAchievements.getOrDefault(game, new ArrayList<>());
        if (achievements.isEmpty()) {
            System.out.println("No achievements for game: " + game.getTitle());
            return;
        }
        System.out.println("Achievements for " + game.getTitle() + ":");
        for (Achievement achievement : achievements) {
            System.out.println("- " + achievement.getName() + ": " + achievement.getDescription() +
                    " (" + (achievement.isUnlocked() ? "Unlocked" : "Locked") + ")");
        }
    }

    @Override
    public int getAchievementCount(Game game) {
        return gameAchievements.getOrDefault(game, new ArrayList<>()).size();
    }
}
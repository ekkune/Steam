package steam.games.achievements;

import steam.games.Achievement;
import steam.games.Game;

public interface AchievementManager {
    void addAchievement(Game game, Achievement achievement);
    void unlockAchievement(Game game, String achievementName);
    void viewAchievements(Game game);
    int getAchievementCount(Game game);
}
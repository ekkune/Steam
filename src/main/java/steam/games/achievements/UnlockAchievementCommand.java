package steam.games.achievements;

import steam.games.Achievement;
import steam.games.Game;

public class UnlockAchievementCommand implements AchievementCommand {
    private AchievementManager manager;
    private Game game;
    private String achievementName;

    public UnlockAchievementCommand(AchievementManager manager, Game game, String achievementName) {
        this.manager = manager;
        this.game = game;
        this.achievementName = achievementName;
    }

    @Override
    public void execute() {
        manager.unlockAchievement(game, achievementName);
    }
}
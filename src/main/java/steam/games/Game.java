package steam.games;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {
    protected String title;
    protected double price;
    protected String type;
    protected List<Achievement> achievements;

    public Game(String title, double price, String type) {
        this.title = title;
        this.price = price;
        this.type = type;
        this.achievements = new ArrayList<>();
    }

    public abstract void launch();

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public List<Achievement> getAchievements() {
        return new ArrayList<>(achievements);
    }

    public void addAchievement(Achievement achievement) {
        achievements.add(achievement);
    }
}
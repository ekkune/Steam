package steam.client;

import steam.games.achievements.AchievementManager;
import steam.games.achievements.DefaultAchievementManager;
import steam.games.Game;
import steam.games.SortStrategy;
import steam.chat.FriendChat;
import steam.games.Achievement;
import steam.analysis.Analyzer;
import steam.analysis.LibraryAnalyzer;

import java.util.ArrayList;
import java.util.List;

public class SteamClient {
    private static SteamClient instance;
    private List<Game> library = new ArrayList<>();
    private UserProfile profile;
    private FriendChat friendChat = new FriendChat();
    private AchievementManager achievementManager = new DefaultAchievementManager();

    private SteamClient() {
        // Приватный конструктор для Singleton
    }

    public static SteamClient getInstance() {
        if (instance == null) {
            instance = new SteamClient();
        }
        return instance;
    }

    public void addGameToLibrary(Game game) {
        if (!library.contains(game)) {
            library.add(game);
            System.out.println("Добавлена игра: " + game.getTitle());
        } else {
            System.out.println("Игра уже в библиотеке: " + game.getTitle());
        }
    }

    public void viewLibrary(SortStrategy strategy) {
        List<Game> sortedLibrary = strategy.sort(new ArrayList<>(library));
        System.out.println("Просмотр библиотеки:");
        for (Game game : sortedLibrary) {
            System.out.println("- " + game.getTitle() + " (" + game.getType() + ", $" + game.getPrice() + ")");
        }
    }

    public void sendMessageToFriend(String friendName, String message) {
        friendChat.receiveMessage(friendName, message);
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    public FriendChat getFriendChat() {
        return friendChat;
    }

    public void analyzeLibrary() {
        Analyzer analyzer = new LibraryAnalyzer(library);
        analyzer.analyze();
    }

    public List<Game> getLibrary() {
        return library;
    }

    public AchievementManager getAchievementManager() {
        return achievementManager;
    }
}

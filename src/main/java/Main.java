import steam.client.SteamClient;
import steam.client.UserProfile;
import steam.games.ActionGameFactory;
import steam.games.Game;
import steam.games.GameFactory;
import steam.games.SortByTitle;
import steam.games.SortStrategy;
import steam.games.StrategyGameFactory;
import steam.ui.BasicUI;
import steam.ui.CustomSkinDecorator;
import steam.ui.DarkSkinDecorator;
import steam.ui.UIComponent;
import steam.chat.Friend;
import steam.games.Achievement;
import steam.games.achievements.UnlockAchievementCommand;

public class Main {
    public static void main(String[] args) {
        // Singleton: Получаем экземпляр клиента
        SteamClient client = SteamClient.getInstance();

        // Builder: Создаём профиль
        UserProfile profile = new UserProfile.Builder()
                .withUsername("PlayerOne")
                .withAvatar("avatar.png")
                .withLevel(10)
                .build();
        client.setProfile(profile);

        // Factory: Создаём игры
        GameFactory actionFactory = new ActionGameFactory();
        Game game1 = actionFactory.createGame("Doom", 59.99);
        client.addGameToLibrary(game1);

        Game game3 = actionFactory.createGame("Half-Life", 19.99);
        client.addGameToLibrary(game3);

        Game game5 = actionFactory.createGame("Counter-Strike", 9.99);
        client.addGameToLibrary(game5);

        Game game7 = actionFactory.createGame("Portal", 9.99);
        client.addGameToLibrary(game7);

        GameFactory strategyFactory = new StrategyGameFactory();
        Game game2 = strategyFactory.createGame("Civilization", 39.99);
        client.addGameToLibrary(game2);

        Game game4 = strategyFactory.createGame("Starcraft", 29.99);
        client.addGameToLibrary(game4);

        Game game6 = strategyFactory.createGame("Age of Empires", 19.99);
        client.addGameToLibrary(game6);

        // Добавление достижений
        client.getAchievementManager().addAchievement(game1, new Achievement("Demon Slayer", "Победить 100 демонов"));
        client.getAchievementManager().addAchievement(game1, new Achievement("Hell Walker", "Завершить кампанию"));
        client.getAchievementManager().addAchievement(game1, new Achievement("Speedrunner", "Пройти уровень за 5 минут"));
        client.getAchievementManager().addAchievement(game2, new Achievement("World Conqueror", "Победить на всех картах"));
        client.getAchievementManager().addAchievement(game2, new Achievement("Master Builder", "Построить 100 зданий"));
        client.getAchievementManager().addAchievement(game3, new Achievement("Crowbar Master", "Уничтожить 50 врагов ломом"));

        // Command: Разблокировка нескольких достижений
        UnlockAchievementCommand unlockCommand1 = new UnlockAchievementCommand(client.getAchievementManager(), game1, "Demon Slayer");
        unlockCommand1.execute();
        UnlockAchievementCommand unlockCommand2 = new UnlockAchievementCommand(client.getAchievementManager(), game1, "Hell Walker");
        unlockCommand2.execute();
        UnlockAchievementCommand unlockCommand3 = new UnlockAchievementCommand(client.getAchievementManager(), game2, "World Conqueror");
        unlockCommand3.execute();
        unlockCommand1.execute();

        // Просмотр достижений для нескольких игр
        System.out.println("Просмотр достижений:");
        client.getAchievementManager().viewAchievements(game1);
        client.getAchievementManager().viewAchievements(game2);
        client.getAchievementManager().viewAchievements(game3);

        // Вывод количества достижений для каждой игры
        System.out.println("Количество достижений по играм:");
        System.out.println("- Doom: " + client.getAchievementManager().getAchievementCount(game1) + " достижений");
        System.out.println("- Civilization: " + client.getAchievementManager().getAchievementCount(game2) + " достижений");
        System.out.println("- Half-Life: " + client.getAchievementManager().getAchievementCount(game3) + " достижений");

        // Strategy: Просмотр библиотеки с сортировкой
        SortStrategy sortByTitle = new SortByTitle();
        client.viewLibrary(sortByTitle);

        // Расширенный текстовый анализ
        client.analyzeLibrary();

        // Decorator: Кастомизация UI
        UIComponent ui = new BasicUI();
        ui = new DarkSkinDecorator(ui);
        ui = new CustomSkinDecorator(ui);
        ui.render();
        System.out.println();

        // Observer: Чат и уведомления
        Friend friend1 = new Friend("FriendA");
        Friend friend2 = new Friend("FriendB");
        client.getFriendChat().addObserver(friend1);
        client.getFriendChat().addObserver(friend2);
        client.sendMessageToFriend("FriendA", "Привет!");
    }
}
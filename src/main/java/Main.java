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

        // Factory: Создаём игры (добавим больше для демонстрации анализа)
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
        client.sendMessageToFriend("FriendA", "Hello!");

    }
}
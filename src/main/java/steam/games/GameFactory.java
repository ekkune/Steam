package steam.games;

public interface GameFactory {
    Game createGame(String title, double price);
}
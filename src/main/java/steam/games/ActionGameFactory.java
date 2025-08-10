package steam.games;

public class ActionGameFactory implements GameFactory {
    @Override
    public Game createGame(String title, double price) {
        return new ActionGame(title, price);
    }
}
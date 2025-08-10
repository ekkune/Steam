package steam.games;

public class StrategyGameFactory implements GameFactory {
    @Override
    public Game createGame(String title, double price) {
        return new StrategyGame(title, price);
    }
}
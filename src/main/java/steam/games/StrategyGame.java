package steam.games;

public class StrategyGame extends Game {
    public StrategyGame(String title, double price) {
        super(title, price, "Strategy");
    }

    @Override
    public void launch() {
        System.out.println("Launching strategy game: " + title);
    }
}
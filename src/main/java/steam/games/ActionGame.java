package steam.games;

public class ActionGame extends Game {
    public ActionGame(String title, double price) {
        super(title, price, "Action");
    }

    @Override
    public void launch() {
        System.out.println("Launching action game: " + title);
    }
}
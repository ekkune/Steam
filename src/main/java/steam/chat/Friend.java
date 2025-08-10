package steam.chat;

public class Friend implements Observer {
    private String name;

    public Friend(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Friend " + name + " received: " + message);
    }
}
package steam.ui;

public class DarkSkinDecorator extends UIDecorator {
    public DarkSkinDecorator(UIComponent component) {
        super(component);
    }

    @Override
    public void render() {
        super.render();
        System.out.print(" с темной темой");
    }
}
package steam.ui;

public class CustomSkinDecorator extends UIDecorator {
    public CustomSkinDecorator(UIComponent component) {
        super(component);
    }

    @Override
    public void render() {
        super.render();
        System.out.print(" with custom accents");
    }
}
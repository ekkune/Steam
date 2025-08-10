package steam.ui;

public abstract class UIDecorator implements UIComponent {
    protected UIComponent component;

    public UIDecorator(UIComponent component) {
        this.component = component;
    }

    @Override
    public void render() {
        if (component != null) {
            component.render();
        }
    }
}
public class LifeApp
{
    private LifeModel model;
    private LifeView view;
    private LifePanelView panelView;
    private LifeController controller;

    public LifeApp()
    {
        model = new LifeModel();
        view = new LifeView(model);
        panelView = new LifePanelView(model);
        controller = new LifeController(model);

        while (true) { }
    }

    public static void main(String[] args)
    {
        new LifeApp();
    }
}
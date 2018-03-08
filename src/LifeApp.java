public class LifeApp
{
    private LifeModel model;
    private LifeConsoleView view;
    private LifePanelView panelView;
    private LifeController controller;

    public LifeApp()
    {
        model = new LifeModel();
        view = new LifeConsoleView(model);
        panelView = new LifePanelView(model);
        controller = new LifeController(model);

        while (true) { }
    }

    public static void main(String[] args)
    {
        new LifeApp();
    }
}
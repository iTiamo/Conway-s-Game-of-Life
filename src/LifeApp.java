public class LifeApp
{
    private LifeModel model;
    private LifeView view;
    private LifeController controller;

    public LifeApp()
    {
        model = new LifeModel();
        view = new LifeView(model);
        controller = new LifeController(model, view);

        while (true) { }
    }

    public static void main(String[] args)
    {
        new LifeApp();
    }
}
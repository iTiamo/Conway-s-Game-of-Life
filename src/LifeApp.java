public class LifeApp
{
    private static final int RIJEN = 20;
    private static final int KOLOMMEN = 30;

    private LifeModel model;
    private LifeView view;
    private LifeController controller;

    public LifeApp(int rijen, int kolommen)
    {
        model = new LifeModel(rijen, kolommen);
        view = new LifeView(model);
        controller = new LifeController(model, view);

        while (true) { }
    }

    public static void main(String[] args)
    {
        new LifeApp(RIJEN, KOLOMMEN);
    }
}
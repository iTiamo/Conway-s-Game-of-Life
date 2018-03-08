public class LifeView
{
    private LifeModel model;

    public LifeView(LifeModel model)
    {
        this.model = model;
    }

    protected void toonBord()
    {
        System.out.print("\n");
        for (int r = 0; r < model.bord.length; r++)
        {
            for (int k = 0; k < model.bord[r].length; k++)
            {
                if (model.bord[r][k])
                    System.out.print("X ");
                else
                    System.out.print(". ");
            }
            System.out.print("\n");
        }
    }
}
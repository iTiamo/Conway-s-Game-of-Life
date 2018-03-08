import java.util.Random;

public class LifeModel
{
    private final int KANS_OP_LEVENDE_CEL = 25;
    private final int RIJEN;
    private final int KOLOMMEN;

    private Random generator;
    protected boolean[][] bord;

    public LifeModel(int rijen, int kolommen)
    {
        this.RIJEN = rijen;
        this.KOLOMMEN = kolommen;

        maakBord();
    }

    private void maakBord()
    {
        generator = new Random();
        bord = new boolean[RIJEN][KOLOMMEN];

        for (int r = 0; r < bord.length; r++)
        {
            for (int k = 0; k < bord[r].length; k++)
            {
                if ((generator.nextInt(100) + 1) <= KANS_OP_LEVENDE_CEL)
                    bord[r][k] = true;
                else
                    bord[r][k] = false;
            }
        }
    }

    protected void updateBord()
    {
        boolean[][] nieuwBord = new boolean[RIJEN][KOLOMMEN];
        for (int r = 0; r < bord.length; r++)
        {
            for (int k = 0; k < bord[r].length; k++)
            {
                if(bord[r][k])
                {
                    switch (getAantalBurenCel(r, k))
                    {
                        case 0: case 1:
                            nieuwBord[r][k] = false;
                            break;
                        case 2: case 3:
                            nieuwBord[r][k] = true;
                            break;
                        default:
                            nieuwBord[r][k] = false;
                            break;
                    }
                }
                else
                {
                    if (getAantalBurenCel(r, k) == 3)
                        nieuwBord[r][k] = true;
                }
            }
        }
        bord = nieuwBord;
    }

    private int getAantalBurenCel(int rij, int kolom)
    {
        int aantalBuren=0;
        for (int r = rij-1; r <= rij+1; r++)
            for (int k = kolom-1; k <= kolom+1; k++)
            {
                if (r < 0 | k < 0)
                    continue;
                else if (k >= KOLOMMEN | r >= RIJEN)
                    continue;

                if(bord[r][k] & (r != rij | k != kolom))
                    aantalBuren++;
            }
        return aantalBuren;
    }
}
import java.util.Observable;
import java.util.Random;

public class LifeModel extends Observable
{
    protected final int RIJEN = 20;
    protected final int KOLOMMEN = 30;
    private final int KANS_OP_LEVENDE_CEL = 25;

    protected boolean[][] bord;

    public LifeModel()
    {
        Random generator = new Random();
        bord = new boolean[RIJEN][KOLOMMEN];

        for (int r = 0; r < RIJEN; r++)
            for (int k = 0; k < KOLOMMEN; k++)
                bord[r][k] = ((generator.nextInt(100) + 1) <= KANS_OP_LEVENDE_CEL);
    }

    protected void updateBord()
    {
        boolean[][] nieuwBord = new boolean[RIJEN][KOLOMMEN];
        for (int r = 0; r < RIJEN; r++)
            for (int k = 0; k < KOLOMMEN; k++)
                nieuwBord[r][k] = checkLevend(r, k);
        bord = nieuwBord;

        setChanged();
        notifyObservers();
    }

    private boolean checkLevend(int rij, int kolom)
    {
        if (bord[rij][kolom] & getAantalBurenCel(rij, kolom) == 2)
            return true;
        else if (getAantalBurenCel(rij, kolom) == 3)
            return true;
        else
            return false;
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
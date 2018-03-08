import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class LifePanelView extends JPanel implements Observer
{
    private JFrame lifeFrame;
    private LifeModel model;
    private JButton[][] jButtons;

    public LifePanelView(LifeModel model)
    {
        this.model = model;
        model.addObserver(this);

        maakJButtons();
        toonGUI();
    }

    private void toonGUI()
    {
        setLayout(new GridLayout(model.RIJEN, model.KOLOMMEN));
        lifeFrame = new JFrame();
        lifeFrame.setBounds(100, 100, model.KOLOMMEN*20, model.RIJEN*20);
        lifeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lifeFrame.setTitle("John Conway's Game of Life");
        lifeFrame.add(this);
        lifeFrame.setVisible(true);
    }

    private void maakJButtons()
    {
        jButtons = new JButton[model.RIJEN][model.KOLOMMEN];
        for (int r = 0; r < model.RIJEN; r++)
            for (int k = 0; k < model.KOLOMMEN; k++)
            {
                jButtons[r][k] = new JButton();
                jButtons[r][k].setBackground(getBGColor(r, k));
                jButtons[r][k].setOpaque(true);
                jButtons[r][k].setBorderPainted(false);
                add(jButtons[r][k]);
            }
    }

    private JButton[][] nextGenButtons()
    {
        JButton[][] nieuwJButtons = new JButton[model.RIJEN][model.KOLOMMEN];
        for (int r = 0; r < model.RIJEN; r++)
        {
            for (int k = 0; k < model.KOLOMMEN; k++)
            {
                nieuwJButtons[r][k] = new JButton();
                nieuwJButtons[r][k].setBackground(getBGColor(r, k));
                nieuwJButtons[r][k].setOpaque(true);
                nieuwJButtons[r][k].setBorderPainted(false);
            }
        }
        return nieuwJButtons;
    }

    private void redrawBord()
    {
        removeAll();
        repaint();
        jButtons = nextGenButtons();
        for (JButton[] bArr : jButtons)
            for (JButton b : bArr)
                add(b);
        revalidate();
    }

    private Color getBGColor(int rij, int kolom)
    {
        if (model.bord[rij][kolom])
            return Color.BLACK;
        else
            return Color.WHITE;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        redrawBord();
    }
}
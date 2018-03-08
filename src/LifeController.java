import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LifeController implements ActionListener
{
    private LifeModel model;
    private LifeView view;

    private Timer timer;

    public LifeController(LifeModel model, LifeView view)
    {
        this.model = model;
        this.view = view;

        timer = new Timer(1000, this);
        timer.start();

        view.toonBord();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        model.updateBord();
        view.toonBord();
    }
}
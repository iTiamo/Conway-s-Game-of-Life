import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LifeController implements ActionListener
{
    private Timer timer;
    private LifeModel model;

    public LifeController(LifeModel model)
    {
        timer = new Timer(1000, this);
        this.model = model;
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        model.updateBord();
    }
}
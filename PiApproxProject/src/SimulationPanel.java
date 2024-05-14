import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SimulationPanel extends JPanel {
    public SimulationPanel()
    {
        Timer timer = new Timer(16, e -> {
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        List<Draw> Figures = new ArrayList<>();
        //Tutaj dodajemy nowe obiekty do rysowania:
        Figures.add(new Square(60, 400, 100, 1, 0));
        super.paintComponent(g);
        for(Draw f: Figures){
            f.draw(g);
        }
    }
}

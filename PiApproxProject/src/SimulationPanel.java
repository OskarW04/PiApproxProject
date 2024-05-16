import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SimulationPanel extends JPanel {
    private int count = 0;
    private List<Draw> Figures = new ArrayList<>();

    public SimulationPanel()
    {
        Figures.add(new Square(100,250,50,1,0));
        Figures.add(new Square(500, 200, 100, 100, -1 ));
        Timer timer = new Timer(16, e -> {
            updateState();
            repaint();
        });
        timer.start();
    }

    private void updateState()
    {
        Square s1 = (Square)Figures.get(0);
        Square s2 = (Square)Figures.get(1);

        if(PhysicsEngine.wallCollision(s1)){
            count++;
            System.out.println(count);
            s1.setVel(s1.getVel()*-1);
        }

        if(PhysicsEngine.isColliding(s1, s2)){
            count++;
            System.out.println(count);
            PhysicsEngine.calculateNewVel(s1, s2);
        }

        s1.move();
        s2.move();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Draw f: Figures){
            f.draw(g);
        }
    }
}

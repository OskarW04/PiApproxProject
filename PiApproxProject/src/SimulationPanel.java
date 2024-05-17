import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SimulationPanel extends JPanel {
    private int count = 0;
    private final List<Draw> Figures = new ArrayList<>();
    public SimulationPanel()
    {
        Figures.add(new Square(100,225,75,1,0));
        Figures.add(new Square(500, 200, 100, 1000000, -100));
        Figures.add(new Line(5, 0, 5, 300, 3));
        Figures.add(new Line(5, 300, 1800, 300, 3));
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

        double deltaTime = 16.6667 / 1000;

        if(PhysicsEngine.wallCollision(s1)){
            count++;
            s1.setVel(s1.getVel()*-1);
            s1.setX(9);
        }
        else if(PhysicsEngine.isColliding(s1, s2)){
            count++;
            PhysicsEngine.calculateNewVel(s1, s2);
            s1.setX(s2.getX()-s1.getSize()-3);
        }
        else {
            s1.move(deltaTime);
        }
        if(s2.getX() > s1.getSize()+10 || s2.getVel() > 0 && count >= (int)(Math.PI*Math.sqrt(s2.getMass())-12))
        {
            s2.move(deltaTime);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Draw f: Figures) {
            f.draw(g);
        }
        Font font = new Font("", Font.PLAIN, 32);
        g.setFont(font);
        g.setColor(Color.PINK);
        g.drawString("Colissions:" + count,100,100);
    }
}

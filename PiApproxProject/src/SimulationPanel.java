import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SimulationPanel extends JPanel {
    private int count = 0;

    private final int initMass;
    private final List<Draw> Figures = new ArrayList<>();
    private final List<Point> Points = new ArrayList<>();

    public SimulationPanel(int initMass)
    {
        this.initMass = initMass;
        //Nowe elementy do rysowania
        Figures.add(new Square(100,225,75,1,0));
        Figures.add(new Square(500, 200, 100, initMass, -100));
        Figures.add(new Line(5, 0, 5, 300, 3, Color.BLACK));
        Figures.add(new Line(5, 300, 1800, 300, 3, Color.BLACK));

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setBackground(Color.gray);
        Figures.add(new CoordinateSystem(screenSize.width/2, (int)(screenSize.height/1.6), initMass));
        Timer timer = new Timer(16, e -> {
            updateState();
            repaint();
        });
        timer.start();
    }

    private void updateState()
    {

        Points.clear();
        Square s1 = (Square)Figures.get(0);
        Square s2 = (Square)Figures.get(1);

        double deltaTime = 16.6667 / 1000;
        Points.add(new Point((int)(s2.getVel()* Math.sqrt(s2.getMass())),(int)(s1.getVel()* Math.sqrt(s1.getMass())),8, (CoordinateSystem)Figures.get(4), initMass));
        if(PhysicsEngine.wallCollision(s1)){
            count++;
            s1.setVel(s1.getVel()*-1);
            newPoint(s1, s2);
            s1.setX(9);

        }
        else if(PhysicsEngine.isColliding(s1, s2)){
            count++;
            PhysicsEngine.calculateNewVel(s1, s2);
            newPoint(s1, s2);

            s1.setX(s2.getX()-s1.getSize()-3);

        }
        else {
            s1.move(deltaTime);
        }
        if(s2.getX() > s1.getSize()+10 || s2.getVel() > 0 && count >= (int)(Math.PI*Math.sqrt(s2.getMass())-12))
        {
            s2.move(deltaTime);
        }
        if(Points.size() == 2)
        {
            Figures.add(new Line(Points.get(0).getPointCoordinates()[0], Points.get(0).getPointCoordinates()[1], Points.get(1).getPointCoordinates()[0], Points.get(1).getPointCoordinates()[1], 2, Color.yellow));
        }
    }

    private void newPoint(Square s1, Square s2) {
        Figures.add(new Point((int)(s2.getVel()* Math.sqrt(s2.getMass())),(int)(s1.getVel()* Math.sqrt(s1.getMass())),8, (CoordinateSystem)Figures.get(4), initMass));
        Points.add(new Point((int)(s2.getVel()* Math.sqrt(s2.getMass())),(int)(s1.getVel()* Math.sqrt(s1.getMass())),8, (CoordinateSystem)Figures.get(4), initMass));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Draw f: Figures) {
            f.draw(g);
        }

        Font font = new Font("Arial", Font.PLAIN, 32);
        g.setFont(font);
        g.setColor(Color.YELLOW);
        g.drawString("Collisions:" + count,100,100);
    }
}

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
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        //Nowe elementy do rysowania
        Figures.add(new Square(100,225,75,1,0));
        Figures.add(new Square(500, 200, 100, initMass, -100));
        Figures.add(new Line(5, 0, 5, 300, 3, Color.BLACK));
        Figures.add(new Line(5, 300, 1800, 300, 3, Color.BLACK));
        Figures.add(new CoordinateSystem(screenSize.width/2, (int)(screenSize.height/1.6), initMass));

        WriteOn writing = new WriteOn(WriteOn.generateFileName());
        setBackground(Color.gray);
        Timer timer = new Timer(16, e -> {
            updateState(writing);
            repaint();
        });
        timer.start();
    }

    private void updateState(WriteOn writing)
    {

        Points.clear();
        Square s1 = (Square)Figures.get(0);
        Square s2 = (Square)Figures.get(1);
        double deltaTime = 16.6667 / 1000;
        Points.add(new Point((int)(s2.getVel()* Math.sqrt(s2.getMass())),(int)(s1.getVel()* Math.sqrt(s1.getMass())),8, (CoordinateSystem)Figures.get(4), initMass));
        if(PhysicsEngine.wallCollision(s1)){
            count++;
            s1.setVel(s1.getVel()*-1);
            writing.writeNew(count, s1.getVel(), s1.getMass(), s2.getVel(), s2.getMass());
            newPoint(s1, s2);
            s1.setX(9);

        }
        else if(PhysicsEngine.isColliding(s1, s2)){
            count++;
            PhysicsEngine.calculateNewVel(s1, s2);
            writing.writeNew(count, s1.getVel(), s1.getMass(), s2.getVel(), s2.getMass());
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

        //Wyświetlanie ilości kolizji
        Font font1 = new Font("Arial", Font.PLAIN, 32);
        g.setFont(font1);
        g.setColor(Color.YELLOW);
        g.drawString("Collisions:" + count,100,100);
        //Wyświetlanie prędkości w danym momencie
        Font font2 = new Font("Arial", Font.PLAIN, 16);
        g.setColor(Color.BLACK);
        g.setFont(font2);
        Square s1 = (Square)Figures.getFirst();
        Square s2 = (Square)Figures.get(1);
        g.drawString("V1: " + String.format("%.2f", s1.getVel()/100), 20, 330);
        g.drawString("V2: " + String.format("%.2f", s2.getVel()/100), 20, 350);

    }
}

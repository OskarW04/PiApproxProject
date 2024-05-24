import java.awt.*;
// jeszcze nie działa ale kij z tym, coś jest
public class Circle extends Draw {
    private double radius;

    public Circle(int x, int y, double mass2, double velocity2) {
        super(x, y);
        this.radius = Math.sqrt(mass2) * velocity2;
    }

    @Override
    public void draw(Graphics g) {
        int diameter = (int) (2 * radius);
        g.drawOval((int) (x - radius), (int) (y - radius), diameter, diameter);
        g.setColor(Color.GRAY);
    }
}

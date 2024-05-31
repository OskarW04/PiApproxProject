import java.awt.*;

public class Line extends Draw{
    private final int x2;
    private final int y2;
    private final int stroke;
    private final Color color;
    public Line(int x, int y, int x2, int y2, int stroke, Color color)
    {
        super(x, y);
        this.x2 = x2;
        this.y2 = y2;
        this.stroke = stroke;
        this.color = color;
    }

    @Override
    public void draw(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(stroke));
        g.drawLine(x, y, x2, y2);
    }
}

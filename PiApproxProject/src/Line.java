import java.awt.*;

public class Line extends Draw{
    private int x2;
    private int y2;

    public Line(int x, int y, int x2, int y2)
    {
        super(x, y);
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawLine(x, y, x2, y2);
    }
}

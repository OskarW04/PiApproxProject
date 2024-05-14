import java.awt.*;

public class Square extends Draw{
    private int size;
    private double vel0;
    private int mass;

    public Square(int x, int y, int size, int mass, double vel0)
    {
        super(x, y);
        this.size = size;
        this.mass = mass;
        this.vel0 = vel0;
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, size, size);
    }
}

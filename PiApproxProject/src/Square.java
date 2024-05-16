import java.awt.*;

public class Square extends Draw{
    private int size;
    private double vel;
    private int mass;

    public Square(int x, int y, int size, int mass, double vel)
    {
        super(x, y);
        this.size = size;
        this.mass = mass;
        this.vel = vel;
    }

    public int getMass()
    {
        return mass;
    }

    public double getVel()
    {
        return vel;
    }

    public int getX()
    {
        return x;
    }

    public int getSize()
    {
        return size;
    }

    public void setVel(double vel)
    {
        this.vel = vel;
    }

    public void move(){
        x += (int)Math.round(vel);
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, size, size);
    }
}

import java.awt.*;

public class Square extends Draw{
    private final int size;
    private double vel;
    private final int mass;

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

    public void setX(int x)
    {
        this.x = x;
    }
    public void move(double deltaTime){
        if(vel < 0) {
            x += (int) (Math.floor(vel * deltaTime));
        }
        else{
            x += (int) (Math.ceil(vel * deltaTime));
        }
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, size, size);
        Font font = new Font("Arial", Font.BOLD, 16);
        FontMetrics fm = g.getFontMetrics(font);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(mass), x+size/2-String.valueOf(mass).length()*fm.charWidth('0')/2, y-5);
    }
}

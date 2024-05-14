import java.awt.*;

public abstract class Draw {
    public int x;
    public int y;

    public Draw(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public abstract void draw(Graphics g);

}

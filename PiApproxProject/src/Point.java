import java.awt.*;
// klasa będzie ustalała pozycje punktów
    public class Point extends Draw{
        private final int r;
    private final int[] center;

    public Point(int x, int y, int r, CoordinateSystem coordinateSystem, int initMass) {
        super(x,y);
        this.x = (int)(x/Math.sqrt(initMass)/0.5);
        this.y = (int)(y/(Math.sqrt(initMass))/0.5);
        this.r = r;
        this.center = coordinateSystem.getCoordinates();
    }

    public int[] getPointCoordinates()
    {
        return new int[]{center[0] + (x), center[1] - (y)};
    }



    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.ORANGE);
        g.fillOval(center[0] + (x-(r/2)), center[1] - (y+(r/2)), r, r);
    }
}

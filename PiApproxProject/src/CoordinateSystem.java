import java.awt.*;

// klasa będzie rysowała układ współrzędnych
    public class CoordinateSystem extends Draw{

    private final int initMass;
    public CoordinateSystem(int x, int y, int initMass) {
        super(x, y);
        this.initMass = initMass;
    }

    public int[] getCoordinates()
    {
        return new int[]{x, y};
    }

    @Override
    public void draw(Graphics g){
        new Line(x-300, y,x+300, y, 4, Color.BLACK ).draw(g);
        new Line(x, y-250, x, y+250, 4,  Color.BLACK ).draw(g);
        int div = -1;
        //Linie pomocnicze poziome
        for(int i = 200; i >= -200 ; i-=100)
        {
            new Line(x+i, y+5, x+i, y-5, 2, Color.BLACK).draw(g);
            if(div != -3)
            {
                g.drawString(String.format("%.2f",(-Math.sqrt(initMass)/div)), x+i+3, y+20);
            }
            if(div==-3)
            {
                div = 3;
            }
            div--;
        }
        div = -1;
        //Linie pomocnicze pionowe
        for(int i = 200; i >= -200; i-=100 )
        {
            new Line(x-5, y+i, x+5, y+i, 2, Color.BLACK).draw(g);
            if(div != -3)
            {
                g.drawString(String.format("%.2f",(Math.sqrt(initMass)/div)), x+10, y+i+3);
            }
            if(div==-3)
            {
                div = 3;
            }
            div--;
        }
        g.drawString("0", x+10, y+20);
        g.drawString("v1 * √m1", x+300, y-5 );
        g.drawString("v2 * √m2", x+5, y-245);
    }
}

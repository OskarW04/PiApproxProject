public class PhysicsEngine {
    public static void calculateNewVel(Square s1, Square s2)
    {
        int m = s1.getMass();
        double vm = s1.getVel();
        int M = s2.getMass();
        double vM = s2.getVel();

        double newvm = ((double)(m-M)/(m+M))*vm + ((double)(2*M)/(M+m))*vM;
        double newvM = ((double)(2*m)/(M+m))*vm + ((double)(M-m)/(M+m))*vM;

        System.out.println(vm);
        System.out.println(newvm);
        System.out.println(vM);
        System.out.println(newvM);
        s1.setVel(newvm);
        s2.setVel(newvM);
    }

    public static boolean isColliding(Square s1, Square s2)
    {
        return s1.getX() < s2.getX() + s2.getSize() && s1.getX() + s1.getSize() > s2.getX();
    }

    public static boolean wallCollision(Square s1)
    {
        return s1.getX() <= 0;
    }
}

package Exercitiu1;

public class Parabola {
    private int a;
    private int b;
    private int c;

    public Parabola(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String mij(int a, int b, int c){
        float x1, y1, x2, y2;

        x1 = (-(this.b))/2*this.a;
        y1 = (-(this.b^2) + 4 * this.a * this.c)/this.a * 4;
        x2 = -(b / 2 * a);
        y2 = (-(b^2) + 4 * a * c)/ a * 4;
        return (x1 + x2)/2 + " " + (y1 + y2)/2;
    }

    public static void mjsd(Parabola g, Parabola h){
        double x1, y1, x2, y2, x, y;

        x1 = -(g.b/2*g.a);
        y1 = (-(g.b^2) + 4  * g.a * g.c)/g.a * 4;
        x2 = -(h.b / 2 * h.a);
        y2 = (-(h.b^2) + 4 * h.a * h.c)/ h.a * 4;

        x = (x1 + x2) / 2;
        y = (y1 + y2) / 2;

    }

    public double segd(int a, int b, int c){
        double x1, y1, x2, y2, x, y;

        x1 = -(this.b/2*this.a);
        y1 = (-(this.b^2) + 4*this.a * this.c)/this.a * 4;
        x2 = -(b / 2 * a);
        y2 = (-(b^2) + 4 * a * c)/ a * 4;

        return Math.hypot((x2 - x1), (y2 - y1));
    }

    public static void segdv(Parabola g, Parabola h){
        double x1, y1, x2, y2, x;

        x1 = -(g.b/2*g.a);
        y1 = (-(g.b^2) + 4*g.a * g.c)/g.a * 4;
        x2 = -(h.b / 2 * h.a);
        y2 = (-(h.b^2) + 4 * h.a * h.c)/ h.a * 4;

        x = Math.hypot((x2 - x1), (y2 - y1));
    }

    @Override
    public String toString() {
        return "f(x)=" + a + " x^2 + " + b + " x + " + c;
    }
}

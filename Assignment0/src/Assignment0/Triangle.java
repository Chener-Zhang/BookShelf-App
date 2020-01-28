
package Assignment0;

public class Triangle extends Shape{

         double a;
         double b;
         double c;



    public Triangle(double x, double y, double z) {
        super("Triangle");
        this.a = x;
        this.b = y;
        this.c = z;

    }

    public double getArea() {
        double s = (a + b + c)/2.0;
        double x = (s * (s-a) * (s-b) * (s-c));
        double Area= Math.sqrt(x);
        return Area;
    }


    public void printDimensions()
                
    {
        System.out.println("Triangle");
    }



}

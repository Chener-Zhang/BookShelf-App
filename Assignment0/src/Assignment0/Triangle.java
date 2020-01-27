
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

    @Override
    public double getArea() {
        double s = 0.5;
        double Area = Math.sqrt((s*(s-a)*(s-b)*(s-c)));

        System.out.println("The Area of Triangle is :" + Area);
        return Area;
    }
}

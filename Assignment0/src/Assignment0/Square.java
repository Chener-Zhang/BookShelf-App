package Assignment0;

public class Square extends Shape {


    double len;
    double height;
    public Square(double length, double height) {
        super("Square");
        this.len = length;
        this.height = height;
    }


    public double getArea() {
        double Area;
        Area = len *height;
        return Area;
    }

    public void printDimensions()

    {
        System.out.println("This is a Square");
    }

}

package Assignment0;

public class Square extends Shape {


    int len;
    int height;
    public Square(int length, int height) {
        super("Square");
        this.len = length;
        this.height = height;
    }


    public double getArea() {
        int Area;
        Area = len *height;
        return Area;
    }

    public void printDimensions()

    {
        System.out.println("Square");
    }

}

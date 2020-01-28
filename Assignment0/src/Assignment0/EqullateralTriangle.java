package Assignment0;

public class EqullateralTriangle extends Triangle {



    public EqullateralTriangle(double x, double y, double z) {
        super(x, y, z);
    }

    public double getArea() {
        double s = (a + b + c)/2.0;
        double x = (s * (s-a) * (s-b) * (s-c));
        double Area= Math.sqrt(x);
        return Area;
    }


    public void printDimensions()
    {
        System.out.println("EqullateralTriangle");
    }


}

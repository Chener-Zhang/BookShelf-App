package Assignment0;

public class main {
    public static void main(String[] args){

        Shape item2 = new Triangle(4,5,3);
        double c=item2.getArea();
        System.out.println(c);

        Shape item3 = new Square(4,7);
        System.out.println(item3.getArea());

        Shape item4 = new Circle(8);
        System.out.println(item4.getArea());

    }
}

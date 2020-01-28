package Assignment0;

public class main {
    public static void main(String[] args){

        Shape shape_arr[] = new Shape[5];
        shape_arr[0] = new Square(5,5);
        shape_arr[1] = new Circle(5.5);
        shape_arr[2] = new Triangle(3,4,5);
        shape_arr[3] = new Square(5,5);
        shape_arr[4] = new Triangle(3,3,3);


        for (int i = 0; i < shape_arr.length;i++){
            System.out.println("The shape is :" + shape_arr[i].getName());
            System.out.println("The Area is :" + shape_arr[i].getArea());
            shape_arr[i].printDimensions();
            System.out.println();
        }

    }
}

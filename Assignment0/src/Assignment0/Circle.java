package Assignment0;


class Circle extends Shape{
    int radius;

  public Circle(int radius){
      super("Circle");
      this.radius = radius;
  }


    public double getArea() {
        double Area;
        double pi = 3.1415926;
        double r_sq = radius^2;
        return pi * r_sq;
    }



    public void printDimensions()

    {
        System.out.println("Circle");
    }

}


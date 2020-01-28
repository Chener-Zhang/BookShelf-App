package Assignment0;


class Circle extends Shape{
    double radius;

  public Circle(double radius){
      super("Circle");
      this.radius = radius;
  }


    public double getArea() {
        double Area;
        double pi = 3.1415926;
        double r_sq = radius * radius;
        return pi * r_sq;
    }



    public void printDimensions()

    {
        System.out.println("This is a Circle");
    }

}


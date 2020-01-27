package Assignment0;


class Circle extends Shape{
    int radius;

  public Circle(int radius){
      super("Circle");
      this.radius = radius;
  }

    @Override
    public double getArea() {
        return 0.0;
    }
}


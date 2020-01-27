
package Assignment0;
import java.lang.Math.*;

public class Shape{
    
    private String name;
    
    
    public Shape(String name)
    {

        this.name = name;
    }
    
    
    public String getName() {
        System.out.println(name);
        return name;
    }
    
    
    public double getArea() {
        return 0.0;
    }
    
    public void printDimensions()
    {
        System.out.println("No dimensions");
    }


}

package question1;

import java.util.Comparator;

/**
* This class creates sorting functions for shapes.
* @author Rahul Vijay
* 
*/
public class ShapeSort
{

    /**
     * sort shapes by area
     */
    public static Comparator<Shape> sortByArea = new Comparator<Shape>() {
        public int compare(Shape s1, Shape s2) {

            return (s1.getArea() < s2.getArea() ? -1 :                     
                  (s1.getArea() == s2.getArea() ? 0 : 1));      
        }
    };
    
    /**
     * sort shapes by perimeter
     */
    public static Comparator<Shape> sortByPerimeter = new Comparator<Shape>() {
        public int compare(Shape s1, Shape s2) {

            return (s1.getPerimeter() < s2.getPerimeter() ? -1 :                     
                  (s1.getPerimeter() == s2.getPerimeter() ? 0 : 1));      
        }
    };
    
    /**
     * sort shapes by origin distance
     */
    public static Comparator<Shape> sortByOriginDistance = new Comparator<Shape>() {
        public int compare(Shape s1, Shape s2) {

            return (s1.getOriginDistance() < s2.getOriginDistance() ? -1 :                     
                  (s1.getOriginDistance() == s2.getOriginDistance() ? 0 : 1));      
        }
    };
    
}

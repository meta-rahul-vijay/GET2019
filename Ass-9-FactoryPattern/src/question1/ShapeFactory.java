package question1;

import java.util.ArrayList;
import java.util.Date;

import question1.Shape.ShapeType;
/**
* This class creates object for various shape class.
* @author Rahul Vijay
* 
*/
public class ShapeFactory
{

    /**
     * creates shape of given type with given values
     * @param shape
     * @param originPoint
     * @param parameters
     * @return object of shape type
     */
    public static Shape createShape(ShapeType shape, Point originPoint, ArrayList<Double> parameters) {
        
    	Date date = new Date();
    	Shape shapeObject = null;
    	
        switch(shape) {
        case SQUARE:
        	shapeObject = new Square(parameters.get(0), date, originPoint);
        	break;
        
        case RECTANGLE:
        	shapeObject = new Rectangle(parameters.get(0), parameters.get(1), date, originPoint);
        	break;
        	
        case CIRCLE:
        	shapeObject = new Circle(parameters.get(0), date, originPoint);
        	break;
        	
        case TRIANGLE:
        	shapeObject = new Triangle(parameters.get(0), parameters.get(1), parameters.get(2), parameters.get(3), date, originPoint);
        	break;
            
        default:
            System.out.println("Wrong shape passed");
            break;
        }
        
        return shapeObject;
    }
}
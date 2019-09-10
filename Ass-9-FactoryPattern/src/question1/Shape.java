package question1;

import java.util.Date;

/**
* This interface declares function of various shape.
* @author Rahul Vijay
* 
*/
public interface Shape
{
	
    double getArea();
    
    double getPerimeter();
    
    Point getOrigin();
    
    boolean isPointEnclosed(Point givenPoint);
    
    Date getTimeStamp();
    
    String getShapeType();
    
    double getOriginDistance();
    
    static enum ShapeType { SQUARE, RECTANGLE, CIRCLE, TRIANGLE, }
}
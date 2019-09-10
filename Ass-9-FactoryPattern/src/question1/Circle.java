package question1;

import java.util.Date;

/**
* This class defines function of circle.
* @author Rahul Vijay
* 
*/
public class Circle implements Shape
{
   
    double radius;
    Date date;
    Point originPoint;
    Point center;

    public Circle(double radius, Date date,Point originPoint)
    {
        this.radius = radius;
        this.date = date;
        this.originPoint = originPoint;
        this.center = getCenterCoordinates();
    }
    
    @Override
    public double getArea() {
        return (Math.PI * radius* radius);
    }
    
    @Override
    public double getPerimeter() {
        return (2 * Math.PI * radius);
    }
    
    @Override
    public Point getOrigin() {
        return originPoint;
    }
    
    @Override
    public boolean isPointEnclosed(Point givenPoint) {
    	
        if(getDistance(center, givenPoint) < radius) {
        	return true;
        }
        return false;
    }
    
    @Override
    public Date getTimeStamp() {
    	return date;
    }
    
    @Override
    public String getShapeType() {
    	return "CIRCLE";
    }
    
    @Override
    public double getOriginDistance() {
        
        return Math.sqrt((originPoint.x - 0) * (originPoint.x - 0) + (originPoint.y - 0) * (originPoint.y - 0));
    }
    
    /**
     * @param center
     * @param givenPoint
     * @return distance between center and given point
     */
    private double getDistance(Point center, Point givenPoint) {
    	//distance = square root of ((x2-x1)^2 + (y2-y1)^2)
    	return Math.sqrt((center.x - givenPoint.x) * (center.x - givenPoint.x) + (center.y - givenPoint.y) * (center.y - givenPoint.y));
    }
    
    /**
     * 
     * @return coordinates of center
     */
    private Point getCenterCoordinates() {
    	double xAxis, yAxis;
    	double theta = Math.atan(originPoint.y / originPoint.x);			//tan inverse of slope
    	
    	yAxis = radius * Math.sin(theta);
    	xAxis = radius * Math.cos(theta);
    	
    	return new Point(originPoint.x + xAxis, originPoint.y + yAxis);   	
    }

}

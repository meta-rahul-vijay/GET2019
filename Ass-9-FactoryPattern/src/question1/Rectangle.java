package question1;

import java.util.Date;

/**
* This class defines function of rectangle.
* @author Rahul Vijay
* 
*/
public class Rectangle implements Shape
{
    double length, width;
    Date date;
    Point originPoint;
    Point maxRectanglePoint;
    
    public Rectangle(double length, double width, Date date, Point originPoint)
    {
        this.length = length;
        this.width = width;
        this.date = date;
        this.originPoint = originPoint;
        this.maxRectanglePoint = getMaxRectanglePoint();
    }
    
	@Override
    public double getArea() {
        return length * width;
    }
    
	@Override
    public double getPerimeter() {
        return (2 * (length + width));
    }
    
	@Override
    public Date getTimeStamp() {
    	return date;
    }
    
	@Override
    public Point getOrigin() {
        return originPoint;
    }

	@Override
	public boolean isPointEnclosed(Point givenPoint) {
		if(givenPoint.x > originPoint.x && givenPoint.x < maxRectanglePoint.x && givenPoint.y > originPoint.y && givenPoint.y < maxRectanglePoint.y) {
			return true;
		}
		return false;
	}
	
	@Override
	public String getShapeType() {
		return "RECTANGLE";
	}

	@Override
	public double getOriginDistance() {
		
		return Math.sqrt((originPoint.x - 0) * (originPoint.x - 0) + (originPoint.y - 0) * (originPoint.y - 0));
	}
	
	/**
	 * @return diagonally opposite points of rectangle.
	 */
	private Point getMaxRectanglePoint() {
        return new Point(originPoint.x + width, originPoint.y + length);
    }
	
}

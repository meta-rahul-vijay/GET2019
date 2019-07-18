
// TODO: Auto-generated Javadoc
/**
 * The Class CalculateArea.
 */
public class CalculateArea {
	
	/**
	 * Triangle area.
	 *
	 * @param triangle the triangle
	 */
	public void triangleArea(Triangle triangle){
		try{
			triangle.setArea((triangle.getWidth() * triangle.getHeight())/2);
		}catch(Exception e){
			triangle.setArea(-1);
			System.out.println("Exception ocuur while calculating triangle area");
		}
	 }
	    
	/**
	 * Rectangle area.
	 *
	 * @param rectangle the rectangle
	 */
	public void rectangleArea(Rectangle rectangle){
		rectangle.setArea(rectangle.getLength() * rectangle.getBreadth());
	 }
	    
	/**
	 * Square area.
	 *
	 * @param square the square
	 */
	public void squareArea(Square square){
		square.setArea(square.getSide() * square.getSide());
	}
	    
	/**
	 * Circle area.
	 *
	 * @param circle the circle
	 */
	public void circleArea(Circle circle){
		circle.setArea(3.14 * circle.getRadius() * circle.getRadius());
	}
}
